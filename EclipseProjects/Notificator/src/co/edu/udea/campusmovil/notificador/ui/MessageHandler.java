package co.edu.udea.campusmovil.notificador.ui;

import co.edu.udea.campusmovil.notificador.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MessageHandler extends Activity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.view_menssage);
    }
    
  //Opción menu de preferencias en la vista del mensaje, accede al recurso creado en la carpeta res > menu
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

    public void onShare(View view) {
        Toast.makeText(this,"Sharing Content ..." , Toast.LENGTH_SHORT).show();
    }

    public void onSave(View view) {
        Toast.makeText(this,"Saving Content ..." , Toast.LENGTH_SHORT).show();
    }

    public void onDelete(View view) {
        Toast.makeText(this,"Deleting Content ..." , Toast.LENGTH_SHORT).show();
    }
}
