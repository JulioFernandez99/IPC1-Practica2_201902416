package crt;

public class arregloDatos {

	  public static datos arreglo[]=new datos[5000];
	
	  
	  public void guardarDatos(datos dat,int pos) {
		  arreglo[pos]=dat;
	  }
	  
	  
	  public String toStrin() {
			String s="";
		
			
			for(int i=1;i<arreglo.length;i++) {
				if(arreglo[i]!=null) {
					s+=arreglo[i].toString();
				}
				
				
			}
			return s;
		}
}
