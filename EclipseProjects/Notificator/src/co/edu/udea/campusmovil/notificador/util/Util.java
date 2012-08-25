package co.edu.udea.campusmovil.notificador.util;

public class Util {
	
	
	
	public static boolean emptyOrInvalidString(String value){
		
		if(value==null || value.length() == 0 ){
			return true;
		}
		
		return false;
		
	}
	

}
