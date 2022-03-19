package crt;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class barras extends JFrame {

	private JPanel contentPane;
	private JTextField n1;
	private JTextField n2;
	private JTextField n3;
	private JButton btnNewButton_1;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					barras frame = new barras();
					frame.setLocationRelativeTo(null);
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public barras() {
		setAutoRequestFocus(false);
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 810, 569);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		n1 = new JTextField();
		n1.setBounds(248, 75, 199, 27);
		contentPane.add(n1);
		n1.setColumns(10);
		
		n2 = new JTextField();
		n2.setColumns(10);
		n2.setBounds(248, 133, 199, 27);
		contentPane.add(n2);
		
		n3 = new JTextField();
		n3.setColumns(10);
		n3.setBounds(248, 194, 199, 27);
		contentPane.add(n3);
		
		JPanel panel1 = new JPanel();
		panel1.setBounds(167, 317, 548, 163);
		contentPane.add(panel1);
		
		JButton btnNewButton = new JButton("Calificar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultCategoryDataset datos=new DefaultCategoryDataset();
			
				
							
							
							datos.setValue(90, "Alumno", "Juan");
				
					
					
					
							JFreeChart barChart = ChartFactory.createBarChart3D(
						"Calificaiones de matematicas",		//Nombre del grafico
						"Estudiante de matematicas",		//Nombre de la barra o columnas
						"Calificacion",						//nombre de la numeracion
						datos,								//Datos del grafico
						PlotOrientation.VERTICAL,			//Orientacion
						true,								//Leyenda de barras individuales por color
						true,								//Herramientas
						false								//url del grafico
							
					);
					
		
							ChartPanel panel = new ChartPanel(barChart);        
							 panel1.setLayout(new java.awt.BorderLayout());
						        panel1.add(panel);   
						        panel1.validate();
					
			}
		});
		btnNewButton.setBounds(578, 134, 141, 49);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Regrear");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				principal pr=new principal();
				pr.setVisible(true);
				barras.this.dispose();
			}
		});
		btnNewButton_1.setBounds(104, 120, 89, 23);
		contentPane.add(btnNewButton_1);
		
		
		
		
		
		

		
		
		
			
		
		
		
		
		
	}
}
