
package Modelo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;



public final class VentanaInicial extends JFrame {
    
    
    private PanelFondo jpFondoInicial;
    private JLabel jlNombre;
    private JTextField txtNombre;
    private JButton btnIngresar; 
    private JButton btnAyuda;
    
    //Método constructor
    public VentanaInicial(){
        iniciarComponentes();
    }
    
    private void iniciarComponentes(){
        //Configuración de la ventana
        setTitle("T A M A Ñ O S");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,500);
        setLocationRelativeTo(null);
        setVisible(true); 
        setResizable(false);
 
        Toolkit miPantalla = Toolkit.getDefaultToolkit();
        //para poner icono cambiar ubicacion
        //Image miIcono = miPantalla.getImage("src/imagenes/icono.png");
	//setIconImage(miIcono);
               
        
        
        //Configuración del Encabezado
        jpFondoInicial = new PanelFondo("/modelo/fondo2.png"); 
        jpFondoInicial.setSize(700,500);     
        jpFondoInicial.setLayout(null);
        add(jpFondoInicial);
        
        
        jlNombre = new JLabel("Ingresa tu nombre",SwingConstants.CENTER );
        

        jlNombre.setBounds(150,100, 400,35);
        jlNombre.setForeground(Color.GRAY);
        jlNombre.setFont(new Font("Agency FB", Font.BOLD, 30)); 
        
        //Boton para iniciar juego
        btnIngresar = new JButton("Jugar");
        btnIngresar.setFont(new Font("Agency FB", Font.BOLD, 15));
        btnIngresar.setBounds(290,260, 110,35);
        
        //Botón para instrucciones
        btnAyuda = new JButton("Intrucciones");
        btnAyuda.setFont(new Font("Agency FB", Font.BOLD, 15)); 
        btnAyuda.setBounds(290,210, 110,35);
        
        //Caja para ingresar nombre
        txtNombre = new JTextField("");
        txtNombre.setHorizontalAlignment(JTextField.CENTER);
        txtNombre.setForeground(Color.GRAY);
        txtNombre.setFont(new Font("Agency FB", Font.BOLD, 20)); 
        txtNombre.setBounds(225,155,240, 30);
        
        jpFondoInicial.add(txtNombre);
        jpFondoInicial.add(jlNombre);
        jpFondoInicial.add(btnIngresar);
        jpFondoInicial.add(btnAyuda);
        
        ManejadorDeEventos manejadorEventos = new ManejadorDeEventos();
        
        btnIngresar.addActionListener(manejadorEventos);
        btnAyuda.addActionListener(manejadorEventos);
        txtNombre.addKeyListener(manejadorEventos);
        
        txtNombre.requestFocusInWindow();
        
}
    
   
    
    
    
            class ManejadorDeEventos implements ActionListener, KeyListener{
        @Override
        public void actionPerformed(ActionEvent evento){
            if(evento.getSource() == btnIngresar){                
                
            }
            if(evento.getSource() == btnAyuda){                
                JOptionPane.showMessageDialog(rootPane, """
                                                        CUCHAU SOY EL RAIO MACQUEEN
                                                         Y HE PERDIDO MI HETEROSEXUALIDAD¿Nos ayudas a encontrarlas? """);
            }
        }
        
        @Override
        public void keyReleased(KeyEvent e) {
           /* System.out.println("Se liberó la tecla " + e.getKeyChar() +
                    " Con codigo " + e.getKeyCode());*/

        }
        
        @Override
        public void keyPressed(KeyEvent e) {
            /*System.out.println("Se presionó la tecla " + e.getKeyChar()+
                    " Con codigo " + e.getKeyCode());*/
            
        }
        
        @Override
        public void keyTyped(KeyEvent e) {
            /*System.out.println("Se digitó la tecla " + e.getKeyChar()+
                    " Con codigo " + e.getKeyCode());*/
        }
               
    }
}            
       
