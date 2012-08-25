package co.edu.udea.campusmovil.notificador.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import co.edu.udea.campusmovil.notificador.R;
import co.edu.udea.campusmovil.notificador.helpers.GenericDAO;
import co.edu.udea.campusmovil.notificador.model.Course;
import co.edu.udea.campusmovil.notificador.model.Forum;
import co.edu.udea.campusmovil.notificador.model.Message;
import co.edu.udea.campusmovil.notificador.ui.quickaction.MyPopUpWindow;
import co.edu.udea.campusmovil.notificador.util.Util;

/*
 * Esta clase contiene la primera actividad que se ejecuta una vez iniciada la
 * aplicaciÃ³n, contiene dos mÃ©todos, el "onCreate" que son las acciones que se
 * hacen reciÃ©n se inicia la actividad. Otro mÃ©todo "login" que lo Ãºnico que
 * hace es llevarnos a la actividad UiTest.
 */

public class AppNotificadorActivity extends Activity {

    /**
     * Called when the activity is first created.
     */
    private Dialog dialogo;

    @Override
    public void onCreate(Bundle savedInstanceState) {
       
    	super.onCreate(savedInstanceState);
    	
        if (getIntent().getBooleanExtra("EXIT", false)) {
            super.finish();
        }        
        this.setContentView(R.layout.main);//Cargamos el layout main.
        
    }

    //Pasamos de la actividad AppNotificador a la actividad UiTest
    public void onLogin(View view) {
    	
    	String login =((EditText)this.findViewById(R.id.user_name)).getText().toString();
    	String password = ((EditText)this.findViewById(R.id.password)).getText().toString();
    	   	
    	
    	boolean validationOk = validateLoginData(login,password);
    	
    	if(!validationOk)
    		return;
    	
    	SharedPreferences sp = this.getSharedPreferences("co.edu.udea.campusmovil.notificador_preferences", Context.MODE_PRIVATE);
    	SharedPreferences.Editor Ed = sp.edit();
    	Ed.putString("user_name", login);              
    	Ed.putString("password", password);   
    	Ed.commit();
    	
        Intent intent = new Intent(AppNotificadorActivity.this, MessageListActivity.class);
        this.startActivity(intent);
    }

    private boolean validateLoginData(String login, String password) {
		StringBuilder error = new StringBuilder();
		boolean validationOk = true;
    	
		if(Util.emptyOrInvalidString(login)) {    	    
			error.append("El campo login está vacio.\n");
    		validationOk= false;
    	}
		
		if(Util.emptyOrInvalidString(password)) {
			
			error.append("El campo de password está vacio.\n");
			validationOk=false;
		}
		
		if(!validationOk) {
			MessageUtil.showError(this, error.toString());
		}
    	
		return validationOk;
	}

	//Opción menu de preferencias en la vista del login, accede al recurso creado en la carpeta res > menu
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);

        return true;
    }

    //Implementacion de cada una de las opciones del menu
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about:
                this.dialogo = new Dialog(this);
                this.dialogo.requestWindowFeature(Window.FEATURE_NO_TITLE);//opcion para mostrar el dialog sin el titulo o cabecera
                this.dialogo.setContentView(R.layout.about_text);
                this.dialogo.show();

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
