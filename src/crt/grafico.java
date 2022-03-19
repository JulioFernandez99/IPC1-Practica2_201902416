package crt;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class grafico extends Thread {
	private String titulo;
	
	 int nums[]=new int[5000];
	 String noms[]=new String[5000];
	
	
	
	

	public grafico(int[] nums, String[] noms,String titulo) {
		
		this.nums = nums;
		this.noms = noms;
		this.titulo = titulo;
	}



	public void run() {
		DefaultCategoryDataset datos=new DefaultCategoryDataset();
		
		for(int m=0;m<nums.length;m++) {
			if(noms[m]!=null) {
				String nombre=noms[m];
				int numero=nums[m];
				System.out.println("---Nombre: "+nombre+" Numero: "+numero+"---" );						
				
				datos.setValue(numero,nombre,"");
				
			}
			
			
			
		}
		
		
		
		JFreeChart grafico_barras= ChartFactory.createBarChart3D(
			titulo,		//Nombre del grafico
			"X_Value",		//Nombre de la barra o columnas
			"Y_Value",						//nombre de la numeracion
			datos,								//Daatos del grafico
			PlotOrientation.VERTICAL,			//Orientacion
			true,								//Leyenda de barras individuales por color
			true,								//Herramientas
			false								//url del grafico
				
		);
		
		
		
	
		ChartPanel panel = new ChartPanel(grafico_barras);     
		panel.setMouseWheelEnabled(true);
		
		principal.panel1.setLayout(new java.awt.BorderLayout());
		principal.panel1.add(panel);   
		
		principal.panel1.validate();
		principal.panel1.repaint();
		

	}
	
}
