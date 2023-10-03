package Modelo;
import javax.swing.*;
import Modelo.PanelFondo;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaFinal extends JFrame {
    
    private JButton botonSalir;
    
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

        // Agregar texto
        JLabel labeltotal = new JLabel(" Total intentos:  "+ total);
        labeltotal.setBounds(60, 120, 400, 35);
        labeltotal.setForeground(Color.GRAY);
        labeltotal.setFont(new Font("Agency FB", Font.BOLD, 25));
        jpFondo.add(labeltotal);
        
        JLabel labelaciertos = new JLabel(" Usted tuvo  "+  aciertos +  "  aciertos");
        labelaciertos.setBounds(60, 160, 400, 35);
        labelaciertos.setForeground(Color.GRAY);
        labelaciertos.setFont(new Font("Agency FB", Font.BOLD, 25));
        jpFondo.add(labelaciertos);
        
         // Agregar texto2
        JLabel fallas = new JLabel(" Usted tuvo  "+ fallos + "  fallas");
        fallas.setBounds(60, 200, 400, 35);
        fallas.setForeground(Color.GRAY);
        fallas.setFont(new Font("Agency FB", Font.BOLD, 25));
        jpFondo.add(fallas);
        
        botonSalir = new JButton("Salir");
        botonSalir.setFont(new Font("Agency FB", Font.BOLD, 20)); 
        botonSalir.setBounds(290, 320, 110, 35);
        jpFondo.add(botonSalir);

        // Agregar ActionListener al botón "Salir" para cerrar la ventana
        botonSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cierra la ventana actual
                dispose();
            }
        });
    }
}