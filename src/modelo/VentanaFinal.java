package Modelo;
import javax.swing.*;
import Modelo.PanelFondo;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modelo.VentanaInicial;

public class VentanaFinal extends JFrame {
    
    private JButton botonSalir;
    private JButton botonJugarDeNuevo;
    
    public VentanaFinal(int aciertos, int fallos, int total) {
        // Configuración de la ventana
        setTitle("Tamaños");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);

        // Configuración del fondo
        PanelFondo jpFondo = new PanelFondo("/modelo/fondo2.png");
        jpFondo.setSize(700, 500);
        jpFondo.setLayout(null);
        add(jpFondo);

        int porcentajeAciertos = (int) ((aciertos * 100.0) / total);
        int porcentajeFallos = (int) ((fallos * 100.0) / total);
        
        
        JLabel labelaciertos = new JLabel(" Usted tuvo  "+  aciertos +  "  aciertos");
        labelaciertos.setBounds(50, 140, 400, 35);
        labelaciertos.setForeground(Color.GRAY);
        labelaciertos.setFont(new Font("Agency FB", Font.BOLD, 25));
        jpFondo.add(labelaciertos);
        
        // Agregar barra de progreso para aciertos
        JProgressBar progressBarAciertos = new JProgressBar(0, 100);
        progressBarAciertos.setBounds(140, 180, 400, 35);
         progressBarAciertos.setForeground(Color.green);
        progressBarAciertos.setValue(porcentajeAciertos);
        progressBarAciertos.setStringPainted(true);
        jpFondo.add(progressBarAciertos);

           // Agregar texto2
        JLabel fallas = new JLabel(" Usted tuvo  "+ fallos + "  fallas");
        fallas.setBounds(60, 220, 400, 35);
        fallas.setForeground(Color.GRAY);
        fallas.setFont(new Font("Agency FB", Font.BOLD, 25));
        jpFondo.add(fallas);
        
        
        // Agregar barra de progreso para fallos
        JProgressBar progressBarFallos = new JProgressBar(0, 100);
        progressBarFallos.setBounds(140, 260, 400, 35);
        progressBarFallos.setForeground(Color.red);
        progressBarFallos.setValue(porcentajeFallos);
        progressBarFallos.setStringPainted(true);
        jpFondo.add(progressBarFallos);

       
        JLabel labeltotal = new JLabel(" Total intentos:  "+ total);
        labeltotal.setBounds(50, 100, 400, 35);
        labeltotal.setForeground(Color.GRAY);
        labeltotal.setFont(new Font("Agency FB", Font.BOLD, 25));
        jpFondo.add(labeltotal);
        
        
         botonJugarDeNuevo = new JButton("Jugar de Nuevo");
        botonJugarDeNuevo.setFont(new Font("Agency FB", Font.BOLD, 20));
        botonJugarDeNuevo.setBounds(270, 330, 160, 35);
        jpFondo.add(botonJugarDeNuevo);
        
        botonSalir = new JButton("Salir");
        botonSalir.setFont(new Font("Agency FB", Font.BOLD, 20)); 
        botonSalir.setBounds(290, 370, 110, 35);
        jpFondo.add(botonSalir);

        
       
        
        // Agregar ActionListener al botón "Salir" para cerrar la ventana
        botonSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cierra la ventana actual
                dispose();
            }
        });
        
        botonJugarDeNuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Crea una nueva instancia de VentanaInicial
                new VentanaInicial();
                // Cierra la ventana actual
                dispose();
            }
        });
        
    }
}