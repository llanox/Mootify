package co.udea.edu.campusmovil.notificador.exceptions;

@SuppressWarnings("serial")
public class MootifyException extends Exception {
	
	public MootifyException(Exception ex,String msg){
		super(msg,ex);		
	}
	

}
