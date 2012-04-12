package co.udea.edu.campusmovil.notificador;

import android.app.Activity;
import android.os.Bundle;
/*
 * Esta clase es la encargada de manejar los datos que 
 * tiene el mensaje: título, materia, fecha y remitente.
 * A través de esta clase y de sus métodos accesores podemos 
 * obtener cada uno de los datos del mensaje.
 * 
 * */



public class ItemLista extends Activity
{
	private String titulo;
	private String materia;
	private String fecha;
	private String remitente;
	
	public ItemLista(String h,String i, String j,String k)//constructor
	{
	   titulo = h;
	   materia = i;
	   fecha = j;
	   remitente = k;
	}
	
	public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_lista);//Utilizo el layout item_lista       
    }
	
	public String getTitulo()
	{
		return titulo;
	}	
	
	public String getFecha()
	{
		return fecha;
	}
	
	public String getMateria()
	{
		return materia;
	}
	
	public String getRemitente()
	{
		return remitente;
	}
}
