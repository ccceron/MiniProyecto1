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
import Modelo.PanelFondo;



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
    private ImageIcon imagenClickeada;
    private final JPanel panelBotones;
    private int indiceArrayAleatorio;
    //public PanelFondo jpFondoInicial;
    private final ImageIcon[][] arrayDeArraysDeImagenes;
    private int aciertos = 0;
    private int total = 0;
    private final JLabel puntaje;

    public VentanaJuego () {
        
        
          //Configuración del Encabezado
        /* > PENDIENTE POR MIRAR PARA PONER EL FONDO < jpFondoInicial = new PanelFondo("/modelo/fondo2.png"); 
        jpFondoInicial.setSize(1400,700);     
        jpFondoInicial.setLayout(null);
        add(jpFondoInicial); */
        
        // Crear arrays de ImageIcon (imágenes)
        ImageIcon[] cuadrados = {
                new ImageIcon("src/modelo/Cuadrado1.png","1"),
                new ImageIcon("src/modelo/Cuadrado2.png","2"),
                new ImageIcon("src/modelo/Cuadrado3.png","3"),
                new ImageIcon("src/modelo/Cuadrado4.png","4")
        };

        ImageIcon[] triangulos = {
                new ImageIcon("src/modelo/Triangulo1.png","1"),
                new ImageIcon("src/modelo/Triangulo2.png","2"),
                new ImageIcon("src/modelo/Triangulo3.png","3"),
                new ImageIcon("src/modelo/Triangulo4.png","4")
        };
        ImageIcon[] circulos = {
                new ImageIcon("src/modelo/Circulo1.png","1"),
                new ImageIcon("src/modelo/Circulo2.png","2"),
                new ImageIcon("src/modelo/Circulo3.png","3"),
                new ImageIcon("src/modelo/Circulo4.png","4")
        };

        ImageIcon[] rombo = {
                new ImageIcon("src/modelo/Rombo1.png","1"),
                new ImageIcon("src/modelo/Rombo2.png","2"),
                new ImageIcon("src/modelo/Rombo3.png","3"),
                new ImageIcon("src/modelo/Rombo4.png","4")
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
        
        
        // Crear un panel para la izquierda con una imagen y un botón "Terminar" y el puntaje
        panelIzquierdo = new JPanel(new BorderLayout());

        // Crear un panel para una imagen
        panelIzquierdoImagen = new JPanel(new BorderLayout());
        
        
        //Imagen random de referencia
        Random random = new Random();
        indiceArrayAleatorio = random.nextInt(arrayDeArraysDeImagenes.length);
        
        
        
        //Contador
        puntaje = new JLabel("Contador: 0");

        //Panel Izquierdo Imagen
        imagenIzquierda = arrayDeArraysDeImagenes[0][indiceArrayAleatorio];
        imagenReferencia = new JLabel(imagenIzquierda);
        
        System.out.println("Imagen a seleccionar: " + imagenReferencia.getIcon());
        
        
        // Agregar JButton "Terminar"
        panelIzquierdoTBoton = new JPanel();
        JButton botonTerminar = new JButton("Terminar");
        botonTerminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Botón 'Terminar' presionado");
                dispose(); //Para cerrar la ventana
                
                // Aquí puedes agregar lógica para manejar la acción del botón "Terminar"
                
            }
        });
             
        
        // Agregar paneles al panel izquierdo
        panelIzquierdoTBoton.add(botonTerminar);
        panelIzquierdo.add(puntaje,BorderLayout.NORTH);
        panelIzquierdo.add(imagenReferencia, BorderLayout.CENTER);
        panelIzquierdo.add(panelIzquierdoTBoton, BorderLayout.SOUTH);
        
        panelIzquierdo.setPreferredSize(new Dimension(300, 400));

        // Crear un panel para los botones con GridLayout
        panelBotones = new JPanel(new GridLayout(1, arrayDeArraysDeImagenes[0].length));

        

        
        //Crea label con imagen y funcion del click
        for (ImageIcon image : arrayDeArraysDeImagenes[0]) {
            iconos = new JLabel(image);
            iconos.setPreferredSize(new Dimension(image.getIconWidth(), image.getIconHeight()));
            iconos.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("Label clickeado: " + image.getDescription());
                    imagenClickeada = image;
                    compararResultados();
                    
                    
                    
                    // FALTA QUE FUNCIONE EL CONTADOR BIEN
                    //FALTA ARREGLAR BUG DE "LABEL CLICKEADO"
                    
                    
                    
                    
                    mostrarSiguienteArrayAleatorio();
                }
            });
            panelBotones.add(iconos);
            // > PENDIENTE POR ARREGLAR < jpFondoInicial.add(iconos);
        }

        // Agregar los paneles al JFrame
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panelIzquierdo, BorderLayout.WEST);
        getContentPane().add(panelBotones, BorderLayout.CENTER);
        
        setSize(1400, 450);
        setLocationRelativeTo(null); // Centrar el JFrame en la pantalla
        setVisible(true);
    }

    // Método para mostrar el siguiente array aleatorio
    public void mostrarSiguienteArrayAleatorio() {
        Random random = new Random();
        indiceArrayAleatorio = random.nextInt(arrayDeArraysDeImagenes.length);

        // Mezclar el array aleatorio
        Collections.shuffle(Arrays.asList(arrayDeArraysDeImagenes[indiceArrayAleatorio]));

        // Imprimir el array aleatorio
        System.out.println("Array aleatorio: " + Arrays.toString(arrayDeArraysDeImagenes[indiceArrayAleatorio]));

        // Actualizar la imagen en imagenReferencia del panelIzquierdoImagen
        imagenIzquierda = arrayDeArraysDeImagenes[indiceArrayAleatorio][indiceArrayAleatorio];
        imagenReferencia.setIcon(imagenIzquierda);
    
        System.out.println("Imagen a seleccionar: " + imagenReferencia.getIcon());
        
        // Actualizar los labels con las nuevas imágenes mezcladas
       for (int i = 0; i < arrayDeArraysDeImagenes[indiceArrayAleatorio].length; i++) {
            iconos = (JLabel) ((JPanel) getContentPane().getComponent(1)).getComponent(i);
            iconos.setIcon(arrayDeArraysDeImagenes[indiceArrayAleatorio][i]);
            
        }
    }   


    private void compararResultados() {
       
        // Comparar resultados
        //FALTA VER SI FUNCIONA
        if ( imagenClickeada.equals(imagenIzquierda) ) {
            
            aciertos++;
            total++;
            actualizarLabelContador();
            
        }else{
            
            total++;
            
        }
  
    }

    private void actualizarLabelContador() {
        // Actualizar el texto del JLabel con el valor del contador
        puntaje.setText("Puntaje: " + aciertos);
        panelIzquierdo.repaint();
        panelBotones.repaint();
    }
}