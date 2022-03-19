package crt;

public class CierreAplicacion {
	public void attachShutDownHook(){
		Runtime.getRuntime().addShutdownHook(new Thread() {
			  @Override
			  public void run() {
			    System.out.println("Esto lo ejecutamos cuando acabe el programa");
			  }
			} );
		  System.out.println("Creado el hook en el programa");
				
		}
	
	
	
	
}
