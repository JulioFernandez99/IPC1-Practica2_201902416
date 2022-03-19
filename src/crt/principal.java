package crt;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.net.URL;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import com.jgoodies.looks.plastic.Plastic3DLookAndFeel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Window;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.RepaintManager;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Toolkit;

public class principal extends JFrame {

	public Image imagenFondo;
	public URL fondo;
	public static JLabel tiempo;
	private JTextField txtruta;
	public static JLabel contador;
	public static JPanel panel1;
	public static boolean des;
	public static boolean as;
	public String ruta;
	public  JTextField txttitulo;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					principal frame = new principal();
					frame.paintAll(null);
					frame.setVisible(true);
					frame.setExtendedState(MAXIMIZED_BOTH);
								
					try {
						UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
						
						//UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
						//SwingUtilities.updateComponentTreeUI(frame);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (InstantiationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IllegalAccessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (UnsupportedLookAndFeelException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			
				
			}
		});
	}

	protected void setUndecorated(Color black) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Create the frame.
	 */
	public  principal() {
		setTitle("Ordenamientos");
		setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/crt/engineering_13640.png")));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1281, 729);
		
		
		fondo=this.getClass().getResource("/crt/blanco.jpg");
		imagenFondo=new ImageIcon(fondo).getImage();
		Container contenedor=getContentPane();
		contenedor.add(panel);
		panel.setLayout(null);
		
		tiempo = new JLabel("00:00:00:00");
		tiempo.setForeground(new Color(255, 255, 255));
		tiempo.setFont(new Font("Tahoma", Font.PLAIN, 50));
		tiempo.setBounds(160, 208, 414, 56);
		panel.add(tiempo);
		
		JRadioButton rdbascendente = new JRadioButton("Ascendente");
		rdbascendente.setForeground(Color.WHITE);
		rdbascendente.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbascendente.setBounds(1102, 250, 111, 23);
		rdbascendente.setOpaque(false);
		rdbascendente.setContentAreaFilled(false);
		rdbascendente.setBorderPainted(false);
		rdbascendente.setFocusPainted(false);
		panel.add(rdbascendente);
		
		
		JRadioButton rdbdescendente = new JRadioButton("Descendente");
		rdbdescendente.setForeground(Color.WHITE);
		rdbdescendente.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbdescendente.setBounds(1102, 276, 125, 23);
		rdbdescendente.setOpaque(false);
		rdbdescendente.setContentAreaFilled(false);
		rdbdescendente.setBorderPainted(false);
		rdbdescendente.setFocusPainted(false);
		panel.add(rdbdescendente);

		txtruta = new JTextField();
		txtruta.setBounds(211, 55, 350, 36);
		panel.add(txtruta);
		txtruta.setColumns(10);
		
		 panel1 = new JPanel();
		 panel1.setBounds(22, 405, 969, 229);
		 panel1.setOpaque(false);
		 panel.add(panel1);
		 
		 JRadioButton rdba1 = new JRadioButton("Algoritmo1");
		 rdba1.setForeground(Color.WHITE);
		 rdba1.setBackground(new Color(176, 196, 222));
		 rdba1.setFont(new Font("Tahoma", Font.BOLD, 14));
		 rdba1.setBounds(1102, 135, 111, 23);
		 rdba1.setOpaque(false);
		 rdba1.setContentAreaFilled(false);
		 rdba1.setBorderPainted(false);
		 rdba1.setFocusPainted(false);
		 
		 panel.add(rdba1);
		
		JRadioButton rdba2 = new JRadioButton("Algoritmo 2");
		rdba2.setForeground(Color.WHITE);
		rdba2.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdba2.setBounds(1102, 161, 111, 23);
		rdba2.setOpaque(false);
		panel.add(rdba2);	
		
		JRadioButton rdba3 = new JRadioButton("Algoritmo 3");
		rdba3.setForeground(Color.WHITE);
		rdba3.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdba3.setBounds(1102, 187, 111, 23);
		rdba3.setOpaque(false);
		panel.add(rdba3);
			
		ButtonGroup botones=new ButtonGroup();
		botones.add(rdbascendente);
		botones.add(rdbdescendente);
		
		
		ButtonGroup botones_Algoritmos=new ButtonGroup();
		botones_Algoritmos.add(rdba1);
		botones_Algoritmos.add(rdba2);
		botones_Algoritmos.add(rdba3);
		txttitulo = new JTextField();
		txttitulo.setBounds(211, 113, 350, 36);
		panel.add(txttitulo);
		txttitulo.setColumns(10);
		
		JButton btnexaminar = new JButton("Examinar");
		btnexaminar.setForeground(new Color(0, 0, 0));
		btnexaminar.setBackground(new Color(255, 255, 255));
		btnexaminar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnexaminar.setBounds(586, 60, 111, 23);
		panel.add(btnexaminar);
		btnexaminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser fc=new JFileChooser();
				
				int seleccion=fc.showOpenDialog(principal.this);
				if(seleccion==JFileChooser.APPROVE_OPTION) {
					File fichero=fc.getSelectedFile();
					txtruta.setText(fichero.getAbsolutePath());
				}
				
				
			}
		});
		
		contador = new JLabel("0");
		contador.setForeground(new Color(255, 255, 255));
		contador.setFont(new Font("Tahoma", Font.PLAIN, 37));
		contador.setBounds(232, 278, 320, 56);
		panel.add(contador);
		
		JLabel lblNewLabel = new JLabel("Movimientos");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel.setBounds(58, 302, 164, 23);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tiempo");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel_1.setBounds(58, 218, 89, 36);
		panel.add(lblNewLabel_1);
		panel1.setLayout(new BorderLayout());

		JButton btnNewButton_2 = new JButton("barras");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			barras br=new barras();
			br.setVisible(true);
			principal.this.dispose();
			}
		});
		btnNewButton_2.setBounds(544, 11, 89, 23);
		//contentPane.add(btnNewButton_2);
		
		
		
		JButton btnordenar = new JButton("Ordenar");
		btnordenar.setForeground(new Color(255, 255, 255));
		btnordenar.setBackground(new Color(0, 0, 0));
		btnordenar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnordenar.setBounds(1102, 499, 125, 23);
		panel.add(btnordenar);
		btnordenar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
				
					
				
			
				timer ret=new timer();
				panel1.removeAll();
				
				ruta=txtruta.getText();
				String[] parts = ruta.split("\\.");
				
				
			System.out.println(parts[1]);
			
			if(parts[1].equals("csv") ) {
				
				if(!txttitulo.getText().equals("")) {
					
				
				String titulo=txttitulo.getText();
				
			
				//Metodo burbuja----------------------------------------------------------------
				if(rdba1.isSelected() && rdbascendente.isSelected() ) {
					 contador.setText("0");
					panel1.removeAll();
					repaint();
					contador.setText("0");
					ret.orden();
					
					orden_burbuja_acendente burbuja_as=new orden_burbuja_acendente(txtruta.getText(),titulo);
					timer crono=new timer();
					crono.start();
					burbuja_as.start();					
					repaint();
				}
				
				 if(rdba1.isSelected() && rdbdescendente.isSelected()) {	 
					 contador.setText("0");
					 ret.orden();				
					repaint();
					orden_burbuja_descendente burbuja_des=new orden_burbuja_descendente(txtruta.getText(),titulo);
					timer crono3=new timer();
					crono3.start();
					burbuja_des.start();
					repaint();
				}	
				
				 //Fin metodo burbuja----------------------------------------------------------------

				
				
				//Metodo insercion----------------------------------------------------------------
				if(rdba2.isSelected() && rdbascendente.isSelected() ) {					
					contador.setText("0");
					repaint();
					ret.orden();
					ins_as insercion_as=new ins_as(txtruta.getText(),titulo);
					timer crono=new timer();
					crono.start();
					 insercion_as.start();			
					repaint();
					
				}
				
				 if(rdba2.isSelected() && rdbdescendente.isSelected() ) {	
					 contador.setText("0");	
					 repaint();
					 	ret.orden();
					 	ins_descendente	insercion_des=new ins_descendente(txtruta.getText(),titulo);
						timer crono=new timer();
						crono.start();
						insercion_des.start();
						repaint();
				 }
				//Fin metodo de insercion----------------------------------------------------------------

				//Metodo shell----------------------------------------------------------------
					if(rdba3.isSelected() && rdbascendente.isSelected() ) {					
						contador.setText("0");
						repaint();
						ret.orden();
						shell_as seleccion_as=new shell_as(txtruta.getText(),titulo);
						
						timer crono=new timer();
						crono.start();
						seleccion_as.start();			
						repaint();
						
					}
					
					 if(rdba3.isSelected() && rdbdescendente.isSelected() ) {	
						 contador.setText("0");	
						 repaint();
						 	ret.orden();
						 	shell_des seleccion_des=new shell_des(txtruta.getText(),titulo);
							timer crono=new timer();
							crono.start();
							seleccion_des.start();
							repaint();
				}
					
				 
					//Fin metodo de seleccion----------------------------------------------------------------
				}
				else {
					JOptionPane.showMessageDialog(null, "<html> Asigne un titulo a la grafica.<html>"
							, "Error", JOptionPane.ERROR_MESSAGE);
				}
				 
			}
			else {
				
				JOptionPane.showMessageDialog(null, "<html> El documento no cumple con el formato CSV.<html>"
						, "Error", JOptionPane.ERROR_MESSAGE);
			}	
			
				}catch(Exception k) {
					JOptionPane.showMessageDialog(null, "<html> Ingrese una ruta. <html>"
							, "Error", JOptionPane.ERROR_MESSAGE);
				} 
				 
			}
		});
		
		JLabel lblNewLabel_3 = new JLabel("Ruta");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(58, 64, 49, 14);
		panel.add(lblNewLabel_3);
		
		
		
		
		
		JButton btnNewButton_4 = new JButton("Reporte");
		btnNewButton_4.setForeground(new Color(255, 255, 255));
		btnNewButton_4.setBackground(new Color(0, 0, 0));
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_4.setBounds(1102, 443, 125, 23);
		panel.add(btnNewButton_4);
		
		JLabel lblNewLabel_4 = new JLabel("Titulo de la grafica");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(58, 115, 143, 29);
		panel.add(lblNewLabel_4);
		
		
		
		ImageIcon br=new ImageIcon(this.getClass().getResource("/crt/gris.jpg"));
		
		
		
		JLabel borde = new JLabel("");
		borde.setFont(new Font("Tahoma", Font.BOLD, 11));
		borde.setBounds(1025, 0, 276, 681);
		
		borde.setIcon(new ImageIcon(br.getImage().getScaledInstance(borde.getWidth(),borde.getHeight(), Image.SCALE_SMOOTH)));
		panel.add(borde);
		
		ImageIcon br2=new ImageIcon(this.getClass().getResource("/crt/negro.jpg"));
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(0, 0, 1030, 404);
		lblNewLabel_2.setIcon(new ImageIcon(br2.getImage().getScaledInstance(lblNewLabel_2.getWidth(),lblNewLabel_2.getHeight(), Image.SCALE_SMOOTH)));
		panel.add(lblNewLabel_2);
		
	
		
	
		
		
		
		
		
		
		
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
					"<html> Reporte generado con exito. <html>"
					, "Aviso", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		
		
		
		JButton btnNewButton_3 = new JButton("Formato");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
				
				
			}
		});
		btnNewButton_3.setBounds(661, 296, 89, 23);
		//contentPane.add(btnNewButton_3);
		
		
		
		
		
	}
	
	
	public JPanel panel=new JPanel() {
		
		/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

		public void paintComponent(Graphics g) {
			
			g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
		}
		};
}
