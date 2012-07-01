package co.edu.udea.campusmovil.notificador.ui;

import co.edu.udea.campusmovil.notificador.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

/*
 * Esta clase contiene la primera actividad que se ejecuta una vez iniciada la
 * aplicación, contiene dos métodos, el "onCreate" que son las acciones que se
 * hacen recién se inicia la actividad. Otro método "login" que lo único que
 * hace es llevarnos a la actividad UiTest.
 */

public class AppNotificadorActivity extends Activity {

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.main);//Cargamos el layout main.
    }

    //Pasamos de la actividad AppNotificador a la actividad UiTest
    public void onLogin(View view) {
        Intent intent = new Intent(AppNotificadorActivity.this, MessageListHandler.class);
        this.startActivity(intent);
    }
    
    //Opci�n menu de preferencias en la vista del login, accede al recurso creado en la carpeta res > menu
    public boolean onCreateOptionsMenu(Menu menu)
    {
    	MenuInflater inflater = getMenuInflater();
    	inflater.inflate(R.menu.menu, menu);
    	return true;
    	
    }
    
    //Implementacion de cada una de las opciones del menu
    public boolean onOptionsItemSelected(MenuItem item)
    {
    	switch (item.getItemId())
    	{
    	case R.id.number_messages:
    		Toast.makeText(this,"Option number messages" , Toast.LENGTH_SHORT).show();
    		return true;
    	
    	case R.id.login_preferences:
    		Toast.makeText(this,"Option login preferences" , Toast.LENGTH_SHORT).show();
    		return true;
    	
    	case R.id.social_preferences:
    		Toast.makeText(this,"Option social preferences" , Toast.LENGTH_SHORT).show();
    		return true;
    		
    	case R.id.about:
    		Toast.makeText(this,"Option About" , Toast.LENGTH_SHORT).show();
    		return true;
    	
    	default:
    		return super.onOptionsItemSelected(item);
    	}
    }
}