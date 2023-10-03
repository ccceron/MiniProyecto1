package Modelo;
import javax.swing.*;
import Modelo.PanelFondo;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaFinal extends JFrame {
    
    private JButton botonSalir;
    
    public VentanaFinal() {
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
        JLabel label = new JLabel("Texto de la nueva ventana");
        label.setBounds(20, 220, 400, 35);
        label.setForeground(Color.GRAY);
        label.setFont(new Font("Agency FB", Font.BOLD, 30));
        jpFondo.add(label);
        
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