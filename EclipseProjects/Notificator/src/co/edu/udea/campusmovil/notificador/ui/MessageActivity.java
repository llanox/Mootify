package co.edu.udea.campusmovil.notificador.ui;

import co.edu.udea.campusmovil.notificador.R;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

public class MessageActivity extends Activity {
	Dialog dialogo;

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
    	case R.id.preferences:
    		Toast.makeText(this,"Option preferences" , Toast.LENGTH_SHORT).show();
    		return true;   	
    		
    	case R.id.about:
    		dialogo = new Dialog(this);    		
    		dialogo.requestWindowFeature(Window.FEATURE_NO_TITLE);
    		dialogo.setContentView(R.layout.about_text);    		
    		dialogo.show();   		
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
