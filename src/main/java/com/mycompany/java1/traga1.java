package com.mycompany.java1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class traga1 extends JFrame {

    private int dinero = 50;
    private JLabel dineroLabel;
    private JLabel[] slotLabels;
    private JLabel resultadoLabel;
    private Random random;
    private Timer timer;
    private int[] slots = new int[3];
    private int animationStep = 0;
    private JButton jugarButton;
    private JPanel contentPane;  // Panel principal donde cambiaremos el color

    // Definimos los símbolos que vamos a usar
    private final String[] simbolos = {"◆", "❤", "☘"};

    public traga1() {
        random = new Random();

        // Configuración de la ventana
        setTitle("Loco Win");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 1));

        // Crear un panel principal para poder cambiar su color
        contentPane = new JPanel();
        contentPane.setLayout(new GridLayout(5, 1));
        setContentPane(contentPane);  // Usamos este panel como contenido principal

        // Etiqueta para mostrar el dinero
        dineroLabel = new JLabel("Dinero: " + dinero, SwingConstants.CENTER);
        contentPane.add(dineroLabel);

        // Panel para los resultados de los slots
        JPanel slotPanel = new JPanel();
        slotPanel.setLayout(new GridLayout(1, 3));

        slotLabels = new JLabel[3];
        for (int i = 0; i < 3; i++) {
            slotLabels[i] = new JLabel("0", SwingConstants.CENTER);
            slotLabels[i].setFont(new Font("Serif", Font.BOLD, 50));
            slotPanel.add(slotLabels[i]);
        }
        contentPane.add(slotPanel);

        // Botón para jugar
        jugarButton = new JButton("Jugar (Costo 5)");
        jugarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarAnimacion();
            }
        });
        contentPane.add(jugarButton);

        // Etiqueta para mostrar el resultado
        resultadoLabel = new JLabel("", SwingConstants.CENTER);
        contentPane.add(resultadoLabel);

        // Botón para salir
        JButton salirButton = new JButton("Salir");
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salirButton.setText("No pares");
            }
        });
        contentPane.add(salirButton);

        // Configuración del Timer para la animación
        timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarSlots();
            }
        });
    }

    private void iniciarAnimacion() {
        if (dinero >= 5) {
            dinero -= 5;
            dineroLabel.setText("Dinero: " + dinero);
            animationStep = 0;
            resultadoLabel.setText("");
            jugarButton.setEnabled(false);  // Desactivar el botón mientras la animación ocurre
            timer.start();  // Iniciar la animación
        } else {
            resultadoLabel.setText("Vende un órgano para continuar.");
        }
    }

    private void actualizarSlots() {
        // Generar y mostrar símbolos aleatorios mientras la animación está en curso
        for (int i = 0; i < 3; i++) {
            slots[i] = random.nextInt(3);  // Generar un número aleatorio entre 0 y 2
            slotLabels[i].setText(simbolos[slots[i]]);  // Mostrar el símbolo correspondiente
        }

        animationStep++;

        // Detener la animación tras cierto número de pasos
        if (animationStep >= 10) {
            timer.stop();
            verificarResultado();
        }
    }

    private void verificarResultado() {
        // Verificar si los tres símbolos son iguales
        if (slots[0] == slots[1] && slots[1] == slots[2]) {
            resultadoLabel.setText("¡GANASTE!");
            dinero += 50;
            cambiarColorVentanaTemporalmente(Color.GREEN, 1000); // Cambiar el color al ganar
        } else {
            resultadoLabel.setText("PERDISTE");
            cambiarColorVentanaTemporalmente(Color.RED, 500);
        }
        dineroLabel.setText("Dinero: " + dinero);
        jugarButton.setEnabled(true);  // Reactivar el botón después de la animación
    }

    // Método para cambiar el color de la ventana temporalmente
    private void cambiarColorVentanaTemporalmente(Color color, int duracion) {
        // Cambiar el color del panel principal
        contentPane.setBackground(color);

        // Crear un Timer para restaurar el color original después de la duración especificada
        Timer colorTimer = new Timer(duracion, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Restaurar el color original
                contentPane.setBackground(null);  // Restablecer el color predeterminado
            }
        });

        // Solo ejecuta el Timer una vez (tras la duración)
        colorTimer.setRepeats(false);
        colorTimer.start();
    }

    public static void main(String[] args) {
        // Ejecutar la GUI en el hilo de la interfaz gráfica
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                traga1 frame = new traga1();
                frame.setVisible(true);
            }
        });
    }
}
