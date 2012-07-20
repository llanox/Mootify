package co.edu.udea.campusmovil.notificador.ui;

import android.app.AlertDialog;
import android.content.Context;
import co.edu.udea.campusmovil.notificador.exceptions.MootifyException;

public class MessageUtil {

	public static void showError(Context context, MootifyException e) {
		String messageError = e.getMessage();
		
		showError(context, messageError);		
	}

	public static void showError(Context context, String messageError) {
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		builder.setMessage(messageError).setCancelable(true);
		AlertDialog alert = builder.create();
		alert.show();
	}
}
