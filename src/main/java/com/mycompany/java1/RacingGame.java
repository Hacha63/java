import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class RacingGame extends JFrame {
    public RacingGame() {
        setTitle("Juego de Carreras");
        setSize(800, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(new GamePanel());
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(RacingGame::new);
    }
}

class GamePanel extends JPanel implements ActionListener, KeyListener {
    private Timer timer;
    private PlayerCar player;
    private ArrayList<EnemyCar> enemies;
    private ArrayList<Bullet> bullets;
    private int score = 0;
    private Random random;
    private boolean shooting = false;

    public GamePanel() {
        setFocusable(true);
        addKeyListener(this);
        setDoubleBuffered(true); // Activa el doble buffer para mejorar el rendimiento
        player = new PlayerCar(350, 500); // Posición inicial del coche del jugador
        enemies = new ArrayList<>();
        bullets = new ArrayList<>();
        random = new Random();
        timer = new Timer(16, this); // Aproximadamente 60 FPS
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Dibujar bordes negros
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 200, getHeight());      // Banda izquierda
        g.fillRect(600, 0, 200, getHeight());    // Banda derecha

        // Dibujar carretera gris
        g.setColor(Color.GRAY);
        g.fillRect(200, 0, 400, getHeight());

        // Dibujar líneas de la carretera
        g.setColor(Color.WHITE);
        for (int i = 0; i < getHeight(); i += 50) {
            g.fillRect(295, i, 10, 30); // Línea izquierda
            g.fillRect(495, i, 10, 30); // Línea derecha
        }

        // Dibujar coche del jugador
        player.draw(g);

        // Dibujar coches enemigos
        for (EnemyCar enemy : enemies) {
            enemy.draw(g);
        }

        // Dibujar balas
        for (Bullet bullet : bullets) {
            bullet.draw(g);
        }

        // Dibujar puntuación
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Puntuación: " + score, 10, 20);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        player.update();

        // Generar coches enemigos aleatoriamente en los 4 carriles
        if (random.nextInt(100) < 3) { // Reducimos la frecuencia para mejorar rendimiento
            int lane = random.nextInt(4);
            int xPos = 220 + lane * 100;
            boolean movingDown = (lane < 2); // Carriles 0 y 1 hacia abajo, 2 y 3 hacia arriba
            enemies.add(new EnemyCar(xPos, movingDown ? -100 : getHeight(), movingDown));
        }

        // Actualizar posición de coches enemigos y verificar colisiones
        for (int i = enemies.size() - 1; i >= 0; i--) {
            EnemyCar enemy = enemies.get(i);
            enemy.update();

            // Chequeo de colisión entre jugador y enemigos
            if (player.getBounds().intersects(enemy.getBounds())) {
                timer.stop();
                JOptionPane.showMessageDialog(this, "¡Choque! Fin del juego. Puntuación final: " + score);
                System.exit(0);
            }

            // Eliminar coches enemigos que salen de la pantalla
            if (enemy.getY() > getHeight() || enemy.getY() < -100) {
                enemies.remove(i);
                score += 10;
            }
        }

        // Actualizar posición de balas y verificar si golpean un coche enemigo
        for (int i = bullets.size() - 1; i >= 0; i--) {
            Bullet bullet = bullets.get(i);
            bullet.update();

            // Verificar si una bala choca con un enemigo
            for (int j = enemies.size() - 1; j >= 0; j--) {
                EnemyCar enemy = enemies.get(j);
                if (bullet.getBounds().intersects(enemy.getBounds())) {
                    enemies.remove(j);
                    bullets.remove(i);
                    score += 20;
                    break;
                }
            }

            // Eliminar balas que salen de la pantalla
            if (bullet.getY() < 0) {
                bullets.remove(i);
            }
        }

        // Generar disparo continuo si está presionada la barra espaciadora
        if (shooting) {
            bullets.add(new Bullet(player.getX() + 20, player.getY()));
        }

        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W -> player.setSpeed(20); // Acelerar
            case KeyEvent.VK_S -> player.setSpeed(-20); // Frenar
            case KeyEvent.VK_A -> player.setDx(-10); // Izquierda
            case KeyEvent.VK_D -> player.setDx(10); // Derecha
            case KeyEvent.VK_SPACE -> shooting = true; // Disparar
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W, KeyEvent.VK_S -> player.setSpeed(0); // Parar
            case KeyEvent.VK_A, KeyEvent.VK_D -> player.setDx(0); // Detener movimiento lateral
            case KeyEvent.VK_SPACE -> shooting = false; // Dejar de disparar
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}
}

class PlayerCar {
    private int x, y;
    private int speed = 0;
    private int dx = 0;

    public PlayerCar(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void update() {
        x += dx;
        y -= speed;

        // Limitar movimiento a la carretera entre las bandas negras
        if (x < 200) x = 200;
        if (x > 550) x = 550;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(x, y, 50, 80); // Cuerpo del coche
        g.setColor(Color.BLACK);
        g.fillRect(x + 5, y + 60, 40, 15); // Techo
        g.setColor(Color.YELLOW);
        g.fillRect(x + 15, y - 10, 20, 10); // Luces
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 50, 80);
    }

    public int getX() { return x; }
    public int getY() { return y; }
}

class EnemyCar {
    private int x, y;
    private int speed = 4;
    private boolean movingDown;

    public EnemyCar(int x, int y, boolean movingDown) {
        this.x = x;
        this.y = y;
        this.movingDown = movingDown;
    }

    public void update() {
        y += movingDown ? speed : -speed;
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, 50, 80); // Cuerpo del coche
        g.setColor(Color.BLACK);
        g.fillRect(x + 5, y + 60, 40, 15); // Techo
        g.setColor(Color.WHITE);
        g.fillRect(x + 15, y - 10, 20, 10); // Luces
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 50, 80);
    }

    public int getY() {
        return y;
    }
}

class Bullet {
    private int x, y;
    private int speed = 90;

    public Bullet(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void update() {
        y -= speed;
    }

    public void draw(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillRect(x, y, 5, 15);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 5, 15);
    }

    public int getY() {
        return y;
    }
}
