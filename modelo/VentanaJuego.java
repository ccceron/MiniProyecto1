package modelo;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;



public class VentanaJuego extends JFrame {
    
    public static void main(String[] args) {
        new VentanaJuego();
    }
    
    private final JPanel panelIzquierdo;
    private final JPanel panelIzquierdoImagen;
    private final JPanel panelIzquierdoTBoton;
    private final JLabel imagenReferencia;
    private JLabel iconos;
    private ImageIcon imagenIzquierda;
    private final JPanel panelBotones;
    private int indiceArrayAleatorio;
    
    private final ImageIcon[][] arrayDeArraysDeImagenes;

    public VentanaJuego() {
        // Crear arrays de ImageIcon (imágenes)
        ImageIcon[] cuadrados = {
                new ImageIcon("src/modelo/Cuadrado1.png"),
                new ImageIcon("src/modelo/Cuadrado2.png"),
                new ImageIcon("src/modelo/Cuadrado3.png"),
                new ImageIcon("src/modelo/Cuadrado4.png")
        };

        ImageIcon[] triangulos = {
                new ImageIcon("src/modelo/Triangulo1.png"),
                new ImageIcon("src/modelo/Triangulo2.png"),
                new ImageIcon("src/modelo/Triangulo3.png"),
                new ImageIcon("src/modelo/Triangulo4.png")
        };
        ImageIcon[] circulos = {
                new ImageIcon("src/modelo/Circulo1.png"),
                new ImageIcon("src/modelo/Circulo2.png"),
                new ImageIcon("src/modelo/Circulo3.png"),
                new ImageIcon("src/modelo/Circulo4.png")
        };

        ImageIcon[] rombo = {
                new ImageIcon("src/modelo/Rombo1.png"),
                new ImageIcon("src/modelo/Rombo2.png"),
                new ImageIcon("src/modelo/Rombo3.png"),
                new ImageIcon("src/modelo/Rombo4.png")
        };
        
        // Crear un array de arrays de ImageIcon
        arrayDeArraysDeImagenes = new ImageIcon[][]{cuadrados, triangulos,circulos,rombo};

        // Mezclar todos los arrays
        for (ImageIcon[] subarray : arrayDeArraysDeImagenes) {
            Collections.shuffle(Arrays.asList(subarray));
        }
        Collections.shuffle(Arrays.asList(arrayDeArraysDeImagenes));

        // Configuración básica del JFrame
        setTitle("Juego");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        // Crear un panel para la izquierda con una imagen y un botón "Terminar"
        panelIzquierdo = new JPanel(new BorderLayout());

        // Crear un panel para una imagen
        panelIzquierdoImagen = new JPanel(new BorderLayout());
        
        imagenIzquierda = arrayDeArraysDeImagenes[indiceArrayAleatorio][0];
        imagenReferencia = new JLabel(imagenIzquierda);
        panelIzquierdoImagen.add(imagenReferencia, BorderLayout.CENTER);
        
        
        // Agregar JButton "Terminar"
        panelIzquierdoTBoton = new JPanel();
        JButton botonTerminar = new JButton("Terminar");
        botonTerminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Botón 'Terminar' presionado");
                
                // Aquí puedes agregar lógica para manejar la acción del botón "Terminar"
                
            }
        });
        
        panelIzquierdoTBoton.add(botonTerminar);
        
        
        // Agregar paneles al panel izquierdo
        panelIzquierdoImagen.add(panelIzquierdoTBoton, BorderLayout.SOUTH);
        panelIzquierdo.add(panelIzquierdoImagen, BorderLayout.CENTER);

        // Crear un panel para los botones con GridLayout
        panelBotones = new JPanel(new GridLayout(1, arrayDeArraysDeImagenes[0].length));

        

        
        //Crea label con imagen y funcion del click
        for (ImageIcon imagen : arrayDeArraysDeImagenes[0]) {
            iconos = new JLabel(imagen);
            iconos.setPreferredSize(new Dimension(imagen.getIconWidth(), imagen.getIconHeight()));

            iconos.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("Label clickeado: " + imagen.getDescription());
                    mostrarSiguienteArrayAleatorio();
                }
            });

            panelBotones.add(iconos);
        }


        // Agregar los paneles al JFrame
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panelIzquierdo, BorderLayout.WEST);
        getContentPane().add(panelBotones, BorderLayout.CENTER);
        
        
        pack(); // Ajustar el tamaño del JFrame según su contenido
        setLocationRelativeTo(null); // Centrar el JFrame en la pantalla
        setVisible(true);
    }

    // Método para mostrar el siguiente array aleatorio
    private void mostrarSiguienteArrayAleatorio() {
        Random random = new Random();
        indiceArrayAleatorio = random.nextInt(arrayDeArraysDeImagenes.length);

        // Mezclar el array aleatorio
        Collections.shuffle(Arrays.asList(arrayDeArraysDeImagenes[indiceArrayAleatorio]));

        // Imprimir el array aleatorio
        System.out.println("Array aleatorio: " + Arrays.toString(arrayDeArraysDeImagenes[indiceArrayAleatorio]));

        // Actualizar la imagen en imagenReferencia del panelIzquierdoImagen
        imagenIzquierda = arrayDeArraysDeImagenes[indiceArrayAleatorio][0];
        imagenReferencia.setIcon(imagenIzquierda);

        // Actualizar los labels con las nuevas imágenes mezcladas
       for (int i = 0; i < arrayDeArraysDeImagenes[indiceArrayAleatorio].length; i++) {
            iconos = (JLabel) ((JPanel) getContentPane().getComponent(1)).getComponent(i);
            iconos.setIcon(arrayDeArraysDeImagenes[indiceArrayAleatorio][i]);
        }
    }
}