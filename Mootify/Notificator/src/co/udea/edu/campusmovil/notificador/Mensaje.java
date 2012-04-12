package co.udea.edu.campusmovil.notificador;

import android.app.Activity;
import android.os.Bundle;
/* * 
 * Esta clase está encargada de manejar los datos del mensaje,
 * mostrarlos y manejar los eventos que se hagan sobre el mismo.
 * */
import android.view.View;
import android.widget.Toast;

public class Mensaje extends Activity
{
	public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vista_mensaje);//Utilizo el layout vista_mensaje
    }
	
	public void borrar(View view)//Metodo para la opcion buscar mensajes
	{
		Toast.makeText(this,"Borrando mensaje..." , Toast.LENGTH_SHORT).show();
	}
	
	public void guardar(View view)//Metodo para la opcion filtrar informacion
	{
		Toast.makeText(this,"Guardando mensaje..." , Toast.LENGTH_SHORT).show();
	}
	
	public void compartir(View view)//Metodo para la opcion leer mensajes
	{
		Toast.makeText(this,"Compartiendo mensaje..." , Toast.LENGTH_SHORT).show();
	}

}
