package com.mycompany.java1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

public class tes extends JPanel implements ActionListener, KeyListener {

    // Tamaño del juego
    private static final int WIDTH = 400;
    private static final int HEIGHT = 600;

    // Jugador
    private Rectangle player;
    private final int playerWidth = 50;
    private final int playerHeight = 50;

    // Obstáculos
    private ArrayList<Rectangle> obstacles;
    private final int obstacleWidth = 50;
    private final int obstacleHeight = 50;
    private Random random;

    // Variables del juego
    private boolean running = true;
    private Timer timer;

    public tes() {
        // Configurar el panel
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);

        // Inicializar jugador
        player = new Rectangle(WIDTH / 2 - playerWidth / 2, HEIGHT - 100, playerWidth, playerHeight);

        // Inicializar obstáculos
        obstacles = new ArrayList<>();
        random = new Random();

        // Configurar el temporizador
        timer = new Timer(16, this); // 60 FPS
        timer.start();

        // Agregar controles
        addKeyListener(this);
        setFocusable(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (running) {
            // Dibujar jugador
            g.setColor(Color.BLUE);
            g.fillRect(player.x, player.y, player.width, player.height);

            // Dibujar obstáculos
            g.setColor(Color.RED);
            for (Rectangle obstacle : obstacles) {
                g.fillRect(obstacle.x, obstacle.y, obstacle.width, obstacle.height);
            }
        } else {
            // Pantalla de fin de juego
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 36));
            g.drawString("¡Fin del Juego!", WIDTH / 2 - 100, HEIGHT / 2);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            // Mover obstáculos
            for (Rectangle obstacle : obstacles) {
                obstacle.y += 5; // Velocidad del obstáculo
            }

            // Eliminar obstáculos que salen de la pantalla
            obstacles.removeIf(obstacle -> obstacle.y > HEIGHT);

            // Generar nuevos obstáculos
            if (random.nextInt(20) == 0) { // Probabilidad de generar un obstáculo
                int x = random.nextInt(WIDTH - obstacleWidth);
                obstacles.add(new Rectangle(x, 0, obstacleWidth, obstacleHeight));
            }

            // Verificar colisiones
            for (Rectangle obstacle : obstacles) {
                if (obstacle.intersects(player)) {
                    running = false;
                    timer.stop();
                }
            }

            repaint();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (running) {
            // Movimiento del jugador
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_LEFT && player.x > 0) {
                player.x -= 10; // Mover a la izquierda
            } else if (key == KeyEvent.VK_RIGHT && player.x < WIDTH - playerWidth) {
                player.x += 10; // Mover a la derecha
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    public static void main(String[] args) {
        // Configurar la ventana
        JFrame frame = new JFrame("Juego Simple");
        tes game = new tes();

        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
