package co.udea.edu.campusmovil.notificador.ui;

import java.util.ArrayList;
import java.util.List;

import co.udea.edu.campusmovil.notificador.R;
import co.udea.edu.campusmovil.notificador.R.id;
import co.udea.edu.campusmovil.notificador.R.layout;
import co.udea.edu.campusmovil.notificador.exceptions.MootifyException;
import co.udea.edu.campusmovil.notificador.helpers.MessageHelper;
import co.udea.edu.campusmovil.notificador.model.ItemLista;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.util.Log;
import android.view.*;
import android.view.View.OnClickListener;

/*
 * Esta clase es utilizada por el momento para probar los 
 * dise�os XML, para poder observar como se muestra 
 * la informaci�n en la ejecuci�n de la aplicaci�n.
 * */

public class UiTest extends Activity 
{
	ListView lista;
	

	
	// Create an anonymous implementation of OnClickListener
	private OnClickListener mCorkyListener = new OnClickListener() {
	    public void onClick(View v) {
	    	Toast.makeText(v.getContext(),"On Click..." , Toast.LENGTH_SHORT).show();
	    }
	};

	
	
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lista_items);		
		lista = (ListView) findViewById(R.id.lista_elementos);
		List<ItemLista> elementos = new ArrayList<ItemLista>();
	
		try {
			elementos = MessageHelper.findAllMsgs("343434", "sasas");
		} catch (MootifyException e) {
			showError(e);
		}
		
		Adaptador ad = new Adaptador(this,elementos);
		lista.setAdapter(ad); 
		 //Tengo un problema aqui, al escoger algun elemento de la lista no ocurre nada, el escuchador no responde
		
	

		
         	
	}
	
	private void showError(MootifyException e) {
		// TODO Auto-generated method stub
		
	}

	public void buscar(View view)//Metodo para la opcion buscar mensajes
	{
		Toast.makeText(this,"Buscando contenido..." , Toast.LENGTH_SHORT).show();
	}
	
	public void filtrar(View view)//Metodo para la opcion filtrar informacion
	{
		Toast.makeText(this,"Filtrando contenido..." , Toast.LENGTH_SHORT).show();
	}
	
	public void mensajes(View view)//Metodo para la opcion leer mensajes
	{
		Toast.makeText(this,"Cargando mensajes..." , Toast.LENGTH_SHORT).show();
	}
	
	
	
	public class Adaptador extends ArrayAdapter<ItemLista> //Clase temporal para probar el ListView
	{
		Activity contexto;
		@SuppressWarnings("unchecked")
		public Adaptador(Activity contexto, List<ItemLista> elementos)
	    {
	    	super(contexto,R.layout.item_lista,elementos);
	    	this.contexto= contexto;
	    }
		
		public View getView(int position,View convertView, ViewGroup parent)
		{
			LayoutInflater inflater = contexto.getLayoutInflater();
		    View item = inflater.inflate(R.layout.item_lista, null);
		
		    item.setOnClickListener(mCorkyListener);
		    
		  
		    
		    TextView titulo = (TextView)item.findViewById(R.id.titulo_mensaje);
		    titulo.setText(getItem(position).getTitulo());
		    
		    TextView materia = (TextView) item.findViewById(R.id.materia);
		    materia.setText(getItem(position).getMateria());
		    
		    return item;
		}
		
	}






}
