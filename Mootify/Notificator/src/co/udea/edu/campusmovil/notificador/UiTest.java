package co.udea.edu.campusmovil.notificador;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.view.*;

/*
 * Esta clase es utilizada por el momento para probar los 
 * diseños XML, para poder observar como se muestra 
 * la información en la ejecución de la aplicación.
 * */

public class UiTest extends Activity 
{
	ListView lista;
	
	ItemLista a = new ItemLista("Prueba de contenido 1","Ingles I","12/35/89","Nota 1");
	ItemLista b = new ItemLista("Prueba de contenido 2","Ingles II","12/35/89","Nota 2");
	ItemLista c = new ItemLista("Prueba de contenido 3","Ingles III","12/35/89","Nota 3");
	ItemLista d = new ItemLista("Prueba de contenido 4","Ingles IV","12/35/89","Nota 4");
	ItemLista e = new ItemLista("Prueba de contenido 5","Ingles V","12/35/89","Nota 5");
	ItemLista f = new ItemLista("Prueba de contenido 6","Ingles VI","12/35/89","Nota 6");
	ItemLista g = new ItemLista("Prueba de contenido 7","Ingles VII","12/35/89","Nota 7");
	ItemLista h = new ItemLista("Prueba de contenido 8","Ingles VIII","12/35/89","Nota 8");
	ItemLista i = new ItemLista("Prueba de contenido 9","Ingles IX","12/35/89","Nota 9");
	ItemLista j = new ItemLista("Prueba de contenido 10","Ingles X","12/35/89","Nota 10");
	
	ItemLista[] elementos = {a,b,c,d,e,f,g,h,i,j};//Esta lista la utilizo para guardar la informacion que va a contener el ListView
	
	
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lista_items);		
		lista = (ListView) findViewById(R.id.lista_elementos);
		
		Adaptador ad = new Adaptador(this);
		lista.setAdapter(ad); 
		
		lista.setOnItemClickListener //Tengo un problema aqui, al escoger algun elemento de la lista no ocurre nada, el escuchador no responde
		(
		  new OnItemClickListener()
		  {
			 public void onItemClick(AdapterView <?> pad,View vista,int pos,long ident)
			 {
			   Intent inte = new Intent(UiTest.this,Mensaje.class);
			   startActivity(inte);
			   }         
			 }        
		);
		
		
         	
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
	
	
	@SuppressWarnings("rawtypes")
	public class Adaptador extends ArrayAdapter //Clase temporal para probar el ListView
	{
		Activity contexto;
		@SuppressWarnings("unchecked")
		public Adaptador(Activity contexto)
	    {
	    	super(contexto,R.layout.item_lista,elementos);
	    	this.contexto= contexto;
	    }
		
		public View getView(int position,View convertView, ViewGroup parent)
		{
			LayoutInflater inflater = contexto.getLayoutInflater();
		    View item = inflater.inflate(R.layout.item_lista, null);
		    
		    TextView titulo = (TextView)item.findViewById(R.id.titulo_mensaje);
		    titulo.setText(elementos[position].getTitulo());
		    
		    TextView materia = (TextView) item.findViewById(R.id.materia);
		    materia.setText(elementos[position].getMateria());
		    
		    return item;
		}
		
	}

}
