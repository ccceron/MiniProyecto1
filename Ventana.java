/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
package modelo;

import javax.swing.*;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ComponentListener;



public class Ventana extends JFrame implements ActionListener {

    private JLabel  titulo;
    private JLabel nombre;
    private JTextField cajaNombre;
    public  JButton botonEnviar; //Declaro el nombre de mi botón
    
    
   //Método constructor
    public Ventana(){
            
        setLayout(null);
       
        setDefaultCloseOperation(EXIT_ON_CLOSE); //Al cerrar la ventana termina la operación
         
        setLocationRelativeTo(null); //Centra la ventana al ejecutar el programa
        setBounds(350,60,650,650); //Asigno medidas a mi ventana
        getContentPane().setBackground(Color.ORANGE);
        setResizable(false); //No permite modificar el tamaño de la ventana
        setVisible(true);
        setTitle("Tamaños");
        
        //Llamo mis métodos
        ColocarEtiquetas();
        ColocarBotones();
        
}
    
     public void ColocarEtiquetas(){
          
         setLayout(new GridLayout(4,1));
         
        //Creo un titulo para mi juego 
        titulo = new JLabel("T   A   M   A   Ñ   O   S");
        
        //titulo.setBounds(200, 20, 400, 150);
        titulo.setHorizontalAlignment(JLabel.CENTER);
        
        titulo.setFont(new Font("Agency FB", Font.BOLD, 34));
        add(titulo);
        
        //Creo mi segundo texto en donde pido al usuario su nombre
        
        nombre = new JLabel("Ingresa tu nombre: ");
        nombre.setHorizontalAlignment(JLabel.CENTER);
        //nombre.setBounds(200, 190, 400, 150);
        nombre.setFont(new Font("Agency FB", Font.BOLD, 34));
        add(nombre);
        
            //Pongo la caja de texto para que ingrese su nombre
        cajaNombre = new JTextField();
        cajaNombre.setMaximumSize(new Dimension(Short.MAX_VALUE, 30));
        cajaNombre.setBounds(220, 350, 180, 20);
        cajaNombre.setHorizontalAlignment(JTextField.CENTER);
        add(cajaNombre);
        
     }
     
     //Método para crear los botones
    public void ColocarBotones(){
       
        botonEnviar = new JButton("Enviar");
        botonEnviar.setHorizontalAlignment(JButton.CENTER); //centro el botón
        botonEnviar.setBounds(250,400,120,20);
        add(botonEnviar);
        botonEnviar.addActionListener(this); //Le agrego un evento
      
    }
    
    
    //Capturo mis eventos
    public void actionPerformed(ActionEvent eventoBotonEnviar) {
        if (eventoBotonEnviar.getSource() == botonEnviar){
            System.exit(0);
        }
}
        }


*/
package modelo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ventana extends JFrame implements ActionListener {

    private JLabel titulo;
    private JLabel nombre;
    private JTextField cajaNombre;
    private JLabel imagen;
    public JButton botonEnviar; // Declaro el nombre de mi botón

    // Método constructor
    public Ventana() {

        setDefaultCloseOperation(EXIT_ON_CLOSE); // Al cerrar la ventana termina la operación

        setLocationRelativeTo(null); // Centra la ventana al ejecutar el programa
        setBounds(350,60,700,500); //Asigno medidas a mi ventana
        //setSize(650, 650); // Asigno medidas a mi ventana
        getContentPane().setBackground(Color.ORANGE);
        setResizable(false); // No permite modificar el tamaño de la ventana
        setTitle("Tamaños");

        // Llamo mis métodos
        ColocarEtiquetas();
        ColocarBotones();

        setVisible(true);
    }

    public void ColocarEtiquetas() {
        setLayout(new GridBagLayout());

        // Creo un titulo para mi juego
        titulo = new JLabel("T   A   M   A   Ñ   O   S");
        titulo.setHorizontalAlignment(JLabel.CENTER);
        titulo.setFont(new Font("Agency FB", Font.BOLD, 36));
        GridBagConstraints titulo1 = new GridBagConstraints();
        titulo1.insets = new Insets(10, 10, 10, 10);
        add(titulo);

        // Creo mi segundo texto en donde pido al usuario su nombre
        nombre = new JLabel("Ingresa tu nombre: ");
        nombre.setHorizontalAlignment(JLabel.CENTER);
        nombre.setFont(new Font("Agency FB", Font.BOLD, 32));
        GridBagConstraints nombre1 = new GridBagConstraints();
        nombre1.gridx = 0;
        nombre1.gridy = 1;
        nombre1.insets = new Insets(10, 10, 10, 10);
        add(nombre, nombre);

        // Pongo la caja de texto para que ingrese su nombre
        cajaNombre = new JTextField();
        cajaNombre.setPreferredSize(new Dimension(200, cajaNombre.getPreferredSize().height));
        cajaNombre.setHorizontalAlignment(JTextField.CENTER);
        GridBagConstraints CajaNombre = new GridBagConstraints();
        CajaNombre.gridx = 0;
        CajaNombre.gridy = 2;
        CajaNombre.insets = new Insets(10, 10, 10, 10);
        add(cajaNombre, CajaNombre);
        
        //Ingreso la imagen
        imagen = new JLabel();
        imagen.setIcon(new ImageIcon("imagenProyecto.png"));
        GridBagConstraints imagen1 = new GridBagConstraints();
        imagen1.gridx = 55;
        imagen1.gridy = 5;
        imagen1.insets= new Insets(1,1,0,0);
        add(imagen);
        
        /*imagen = new JLabel(new ImageIcon("colors.jpg"));
        GridBagConstraints imagen1 = new GridBagConstraints();
        imagen1.gridx = 55;
        imagen1.gridy = 5;
        imagen1.insets= new Insets(1,1,0,0);
        add(imagen);*/
    }

    // Método para crear los botones
    public void ColocarBotones() {

        botonEnviar = new JButton("Enviar");
        botonEnviar.setHorizontalAlignment(JButton.CENTER); // centro el botón
        GridBagConstraints BotonEnviar = new GridBagConstraints();
        BotonEnviar.gridx = 0;
        BotonEnviar.gridy = 3;
        BotonEnviar.insets = new Insets(10, 10, 10, 10);
        add(botonEnviar, BotonEnviar);
        botonEnviar.addActionListener(this); // Le agrego un evento
    }

    // Capturo mis eventos
    @Override
    public void actionPerformed(ActionEvent eventoBotonEnviar) {
        if (eventoBotonEnviar.getSource() == botonEnviar) {
            System.exit(0);
        }
    }

}






