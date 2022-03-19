package crt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class shell_des extends Thread {
	private  String ruta;
	private  String titulo;
	private int contador;
	public   int nums[];
	public   String noms[];
	private int numsdes[];
	private  String nomsdes[];
	

	public shell_des(String ruta,String titulo) {
		super();
		this.ruta = ruta;
		this.titulo=titulo;
	}

	public void run()  {
	
		
		int cn=0;
		
		int cm=0;
		
		
		String textLine="";
        String str="";
		  
		
		 BufferedReader readTxt;
		try {
			readTxt = new BufferedReader(new FileReader(new File(ruta)));
		
			 

		       
					while(( textLine=readTxt.readLine())!=null){

					          str+=","+ textLine;
					          
					 }
		
		
		} catch (IOException e1) {
			
			
		}

	      
			

	        String [] numbersArray = str.split (",");
	        nums=new int[(numbersArray.length/2)-1];
	        noms=new String[nums.length];
	        numsdes=new int[nums.length];
	        nomsdes=new String[nums.length];
	        System.out.println("Longitud nums: "+nums.length);
	        System.out.println("Longitud noms: "+noms.length);
	       
	        for(int i=3;i<numbersArray.length;i++) {
	        	
	        	if(i%2==0) {
	        		nums[cn]=Integer.parseInt(numbersArray[i]);
	        		numsdes[cn]=Integer.parseInt(numbersArray[i]);
	        		cn++;
	        	}
	        	
	        	else {
	        		noms[cm]=numbersArray[i];
	        		nomsdes[cm]=numbersArray[i];
	        		cm++;
	        	}
	        }
	        
	        for(int i=0;i<numbersArray.length;i++) {	        	
     		System.out.println(i+": "+numbersArray[i]);
	        }
	        
	        for(int i=0;i<noms.length;i++) {
	        	for(int s=0;s<noms.length-1;s++) {
	        		if( i!=s) {
	        		if(noms[i].equals(noms[s]) && noms[i]!="") {
	        			
	        			System.out.println("Se repite el pais: "+noms[i]);
	        			nums[i]+=nums[s];
	        			noms[s]="";
	        			numsdes[i]+=numsdes[s];
	        			nomsdes[s]="";
	        		}
	        		}
	        	}
	        		
	        }
			
	        System.out.println("---------Todo sin ordenar----------");
			for(int i=0;i<noms.length;i++) {
				if(noms[i]!="") {
     		System.out.println(noms[i]+" | "+nums[i]);
     	
	        	}
			}
	        
	        
			
	    	System.out.println("---------Numeros sin ordenar----------");
			for(int i=0;i<nums.length;i++) {
				if(noms[i]!="") {
     		System.out.println(nums[i]);
     	
	        	}
			}
			
			
			
			System.out.println("---------Nombres sin ordenar----------");
			for(int i=0;i<noms.length;i++) {
				if(noms[i]!="") {
     		System.out.println(noms[i]);
     	
	        	}
			}
		
			//Metodo de seleccion
			int salto, aux, r;
	        boolean cambios;
	        String auxnom;
	        
	        for (salto = nums.length / 2; salto != 0; salto /= 2) {
	            cambios = true;
	            while (cambios) {   // Mientras se intercambie algún elemento                                         
	                cambios = false;
	                for (r= salto; r < nums.length; r++)   // se da una pasada
	                {
	                	principal.panel1.removeAll();
	                	barras();
	                    if (nums[r - salto] < nums[r] && noms[r]!=null) {       // y si están desordenados
	                    	try {
								this.sleep(800);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
	                    	aux = nums[r];                  // se reordenan
	                        nums[r] = nums[r - salto];
	                        nums[r - salto] = aux;
	                       
	                        auxnom = noms[r];                  
	                        noms[r] = noms[r - salto];
	                        noms[r - salto] = auxnom;
	                        
	                        
	                        
	                        cambios = true;              // y se marca como cambio.                                   
	                    contador++;
	                    principal.contador.setText(String.valueOf(contador));
	                    }
	                }
	            }
	        }

	     
		

			System.out.println("---------Numeros Ordenados----------");
			for(int i=0;i<nums.length;i++) {
				if(noms[i]!="") {        		
     		System.out.println(nums[i]);
	        	}
			}
			
	
			
			System.out.println("---------Nombres ordenados----------");
			for(int i=0;i<noms.length;i++) {
				if(noms[i]!="") {
     		System.out.println(noms[i]);
     	
	        	}
     }
			
			
			
			
			System.out.println("---------Todo ordenado----------");
			for(int i=0;i<noms.length;i++) {
				if(noms[i]!="") {
     		System.out.println(noms[i]+" | "+nums[i]);
	        	}
			}
			
			System.out.println("La tabla se ordeno en "+contador+" movimientos");
			
		//	principal.contador.setText(String.valueOf(contador));
			
			System.out.println("termino");
			
			if(timer.tiempo.isRunning()) {
				timer.tiempo.stop();
			}       
			reporte();
			
			
			
	}
	
	
	
	
	
	public  void reporte() {
		String tiempo=principal.tiempo.getText();
		String movimientos=principal.contador.getText();
		
		String cadenaHTML="<html>\n"
				+ "<head>\n"
				+"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/>\n"
				+ "	<title>Reporte</title>\n"
				+ "</head>\n"
				+ "<body>\n"
				+ "<font color=\"#020200\">\n"
				+ "<body background= \"html.jpg\">"
				+ "<h1>Datos </h1>\n"
				+"<p>"
				+"Estudiante: Julio Alfredo Fernandez Rodriguez"
				+"</p>"
				+"<p>"
				+"No. Carnet: 201902416"
				+"</p>"
				+"<p>"
				+"Se utilizo el metodo de Shell (insercion mejorada)"
				+"</p>"
				+"<p>"
				+"Tiempo transcurrido: "+tiempo 
				+"</p>"
				+"<p>"
				+"Numero de movimientos: "+movimientos
				+"</p>"
				+ "<font color=\"#020200\">"

				+ "<table>\n"
				+ "<th>\n"
				+ "</th>"
				+ "<style>\n"
				+ "	.demo {\n"
				+ "		border:1px solid #020200;\n"
				+ "		border-collapse:collapse;\n"
				+ "		padding:5px;\r\n"
				+ "	}\n"
				+ "	.demo th {\n"
				+ "		border:1px solid #020200;\n"
				+ "		padding:5px;\n"
				+ "	}\n"
				+ "	.demo td {\r\n"
				+ "		border:1px solid #020200;\n"
				+ "text-align:centrar;"
				+ "		padding:5px;\n"
				+ "	}\n"
				+ "</style>\r\n"
				+ "<table class=\"demo\"> \n"
				+ "<th class=\"tg-0pky\"><span style=\"font-weight:bold;color:#020200\">Nombres</th>"
				+ "<th class=\"tg-0pky\"><span style=\"font-weight:bold;color:#020200\">Numeros</th>"
				+"<p>"
				+"Tabla sin ordenar"
				+"</p>";
		
		for(int i=0;i<numsdes.length;i++) {
			if(nomsdes[i]!="") {

				cadenaHTML	+= "<tr>";
				cadenaHTML+="<td class=\"tg-0pky\"><span style=\"font-weight:bold;color:#020200\"> &nbsp;"+nomsdes[i]+"</td>";
				cadenaHTML+="<center> "+"<td align = \"center\" class=\"tg-0pky\"><span style=\"font-weight:bold;color:#020200\"> &nbsp;"+numsdes[i]+"</td>"+" </center>";
				cadenaHTML+="</tr>";
			}
		}
						
		cadenaHTML+="</tbody>\n"
				+ "<table>\n"
				+ "<th>\n"
				+ "</th>"
				+ "<style>\n"
				+ "	.demo {\n"
				+ "		border:1px solid #020200;\n"
				+ "		border-collapse:collapse;\n"
				+ "		padding:5px;\r\n"
				+ "	}\n"
				+ "	.demo th {\n"
				+ "		border:1px solid #020200;\n"
				+ "		padding:5px;\n"
				+ "	}\n"
				+ "	.demo td {\r\n"
				+ "		border:1px solid #020200;\n"
				+ "text-align:centrar;"
				+ "		padding:5px;\n"
				+ "	}\n"
				+ "</style>\r\n"
				+ "<table class=\"demo\"> \n"
				+ "<th class=\"tg-0pky\"><span style=\"font-weight:bold;color:#020200\">Nombres</th>"
				+ "<th class=\"tg-0pky\"><span style=\"font-weight:bold;color:#020200\">Numeros</th>"
				+ "	<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/>\n"
				+"<p>"
				+"Tabla  ordenada descendentemente"
				+"</p>";
		
		for(int i=0;i<nums.length;i++) {
			
				if(noms[i]!="") {
				cadenaHTML	+= "<tr>";
				cadenaHTML+="<td class=\"tg-0pky\"><span style=\"font-weight:bold;color:#020200\"> &nbsp;"+noms[i]+"</td>";
				cadenaHTML+="<center> "+"<td align = \"center\" class=\"tg-0pky\"><span style=\"font-weight:bold;color:#020200\"> &nbsp;"+nums[i]+"</td>"+" </center>";
				cadenaHTML+="</tr>";
			}
		};
						
		cadenaHTML+="</tbody>\n"	
				
				
			+ "</body>\n"
				+ "</html>";
		File archivo=new File("Numeros ordenados.html");
		
		try {
			
			
			BufferedWriter bw=new BufferedWriter(new FileWriter(archivo));
			bw.write(cadenaHTML);
			bw.close();
			
			
			
		}catch(Exception p) {
			
		}
	
		
		
    }
	
	
	
	
	
	
	public void barras() {
		
		   //...........................................................................................
					DefaultCategoryDataset datos=new DefaultCategoryDataset();
					
					for(int m=0;m<nums.length;m++) {
						if(noms[m]!="" ) {
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
					
					principal.panel1.setLayout(new java.awt.BorderLayout());
					principal.panel1.add(panel);   
					principal.panel1.validate();
			
					//...........................................................................................
					
	
	}

}
