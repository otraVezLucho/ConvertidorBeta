package Convertidor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//Intentar para mostrar el resultado, simplemente crear un JOptionPane para ver si depronto muestra el resultado


public class Frame1 extends JFrame implements ActionListener{

	//Variables Globales
	
	JFrame frame1; // Patalla princiapal
	JLabel label1; // mensaje 
	JLabel label2; // muestra el resultado de la conversion
	JButton button1; // Ejecuta el comando para convertir 
	JTextField textField; // Campo para escribir el valor y capturarlo
	
	int texto; // Guarda el valor a convertiry lo castea a integer  
	int resultado; // Guarda el valor del resultado de la conversion de la clase Convertidor
	
	Convertidor convertidor; // Para inicializar una instancia


	//Constructor
	 Frame1() {
				
		//Nuevos elementos
		frame1 = new JFrame();
		label1 = new JLabel("Convertidor de divisas");
		button1 = new JButton("Convertir");
		textField = new JTextField();
		label2 = new JLabel();
		
		label2.setText("aqui va el resultado: " + resultado); // EL problema esta aqui, deberia mostrar el String concatenando el resultado int, pero devuelve 0 no muestra el valor del resultado
		
		// configuracion label para mostrar el resultado
		
		label2.setVisible(false);	
		
		//Configuracion textField
		textField.setPreferredSize(new Dimension(50,20));
		textField.setFont(new Font("Consolas",Font.ROMAN_BASELINE,12));
		
		//Configuracion boton
		button1.setBounds(0, 0, 50, 20);
		button1.addActionListener(this);
		
			
		//Elementos agregados al frame
		
		frame1.add(label2);
		frame1.add(textField);
		frame1.add(button1);
		frame1.add(label1);
		
		//Configuracion Frame
		
		frame1.setLayout(new FlowLayout());
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setSize(500, 80);
		frame1.setVisible(true);
	}
	 
	 //Metodo de conversion
	 public int copToUsd (int numero){
			numero *= 4559;  // Operacion de conversion
			return (int) numero; // casteo  a int
		}
	 
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()== button1) {
			
			texto = Integer.parseInt(textField.getText());
			System.out.println(texto);
			textField.setEditable(false);
			//convertidor = new Convertidor();
			resultado = this.copToUsd(texto);	
			System.out.println(resultado);
			label2.setVisible(true);
					
		}
		
		
	}
}
