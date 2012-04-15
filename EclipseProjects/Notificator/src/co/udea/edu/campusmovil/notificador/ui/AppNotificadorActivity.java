package co.udea.edu.campusmovil.notificador.ui;

import co.udea.edu.campusmovil.notificador.R;
import co.udea.edu.campusmovil.notificador.R.layout;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
/* *
 * Esta clase contiene la primer actividad que se ejecuta 
 * una vez iniciada la aplicaci�n, contiene dos m�todos,
 * el onCreate que son las acciones que se hacen reci�n se inicia
 * la actividad. Otro m�todo entrar que lo �nico que hace es 
 * llevarnos a la actividad UiTest.
 * 
 * */
 

public class AppNotificadorActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);//Cargamos el layout main
    }
    
    public void entrar(View view)//Pasamos de la actividad AppNotificador a la actividad UiTest
    {
    	Intent intent = new Intent(AppNotificadorActivity.this,UiTest.class);
    	startActivity(intent);
    	
    }
}