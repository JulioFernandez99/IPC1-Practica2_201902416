package crt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.Principal;

import javax.swing.JLabel;
import javax.swing.Timer;

public class timer extends Thread{
	@SuppressWarnings("unused")
	public static Timer tiempo;
	public static  int centetesimas_segundos=0;
	private int segundos=0;
	private int minutos=0;
	private int horas=0;
	public static boolean res;
	private String tiemp;
	
	
	





	public static void setTiempo(Timer tiempo) {
		timer.tiempo = tiempo;
	}





	public static void setCentetesimas_segundos(int centetesimas_segundos) {
		timer.centetesimas_segundos = centetesimas_segundos;
	}





	public void setSegundos(int segundos) {
		this.segundos = segundos;
	}





	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}





	public void setHoras(int horas) {
		this.horas = horas;
	}





	public static void setRes(boolean res) {
		timer.res = res;
	}





	public void setAcciones(ActionListener acciones) {
		this.acciones = acciones;
	}





	public void run() {
		tiempo=new Timer(10,acciones);
			tiempo.start();	
	
		
		
	}
	
	
	
	
	
	private void actualizarEtiqueta() {
		
		String texto=(horas<=9?"0":"")+horas+":"+(minutos<=9?"0":"")+minutos+":"+(segundos<=9?"0":"")+segundos+":"+(centetesimas_segundos<=9?"0":"")+centetesimas_segundos;
	
		principal.tiempo.setText(texto);
	}
	
	private ActionListener acciones=new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			centetesimas_segundos++;
			
			if(centetesimas_segundos==60) {
				segundos++;
				centetesimas_segundos=0;
			}
			
			if(segundos==60) {
				minutos++;
				segundos=0;
			}
			
			if(minutos==60) {
				horas++;
				minutos=0;
			}
			
			if(horas==24) {
				horas=0;
			}
			actualizarEtiqueta();
		}
	};
	
	
	
	
	
	public String getTiemp() {
		return tiemp;
	}





	public void setTiemp(String tiemp) {
		this.tiemp = tiemp;
	}





	public  void orden() {
		
		
		centetesimas_segundos=0;
		segundos=0;
		minutos=0;
		horas=0;
		actualizarEtiqueta();
	}
}
