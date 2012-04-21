package co.udea.edu.campusmovil.notificador.ui;

import co.udea.edu.campusmovil.notificador.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MessageHandler extends Activity
{
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
        setContentView(R.layout.view_menssage);	
	}
	
	public void compartir(View view)
	{
		Toast.makeText(this,"Compartiendo contenido..." , Toast.LENGTH_SHORT).show();
	}
	
	public void guardar (View view)
	{
		
		Toast.makeText(this,"Guardando contenido..." , Toast.LENGTH_SHORT).show();
	}
	
	public void borrar(View view)
	{
		Toast.makeText(this,"Borrando contenido..." , Toast.LENGTH_SHORT).show();
	}

}
