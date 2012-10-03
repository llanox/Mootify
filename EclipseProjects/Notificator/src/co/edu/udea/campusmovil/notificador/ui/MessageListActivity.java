package co.edu.udea.campusmovil.notificador.ui;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import co.edu.udea.campusmovil.notificador.R;
import co.edu.udea.campusmovil.notificador.exceptions.MootifyException;
import co.edu.udea.campusmovil.notificador.helpers.GenericDAO;
import co.edu.udea.campusmovil.notificador.helpers.MessageHelper;
import co.edu.udea.campusmovil.notificador.model.Course;
import co.edu.udea.campusmovil.notificador.model.Forum;
import co.edu.udea.campusmovil.notificador.model.ListItem;
import co.edu.udea.campusmovil.notificador.model.Message;
import co.edu.udea.campusmovil.notificador.services.MessageService;
import co.edu.udea.campusmovil.notificador.services.ServiceLocator;
import co.edu.udea.campusmovil.notificador.services.ServiceNames;
import co.edu.udea.campusmovil.notificador.ui.quickaction.QuickActionMenu;

/*
 * Esta clase es utilizada por el momento (temporalmente) para probar los
 * diseños XML, para poder observar como se muestra la información en la
 * ejecución de la aplicación.
 */

public class MessageListActivity extends Activity {

    
    private GenericDAO dao;
    private ListView list;
    private QuickActionMenu quickAction;
    private SharedPreferences preferences;//con esto puedo acceder a las preferencias del usuario   
    private Dialog dialogo;    
    private ArrayList<ListItem> listWithPreferences;
    private EditText editText;
    private ImageButton refresh_search;
    private ImageView separator_search;
    private String words;
    private boolean in_search = false;

    @Override
    public void onBackPressed() 
    {
    	super.onBackPressed();
    	Log.d(this.getClass().getName(), "Pressing Back Button");
    	this.finish();

    	Intent intent = new Intent(this.getApplicationContext(), AppNotificadorActivity.class);
    	intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    	intent.putExtra("EXIT", true);
    	this.startActivity(intent);
    }

    
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.principal_view);

        this.list = (ListView) findViewById(R.id.elements_list);
        ArrayList<ListItem> elements = new ArrayList<ListItem>();        
        
        try 
        {
            elements = (ArrayList<ListItem>) MessageHelper.findAllMsgs("343434", "sasas");
        } 
        catch (MootifyException e) 
        {
            showError(e);
        }       
        
          // En este segmento est� la nueva implementacion del adapter y la implementacion del onItemClickListener
        	this.preferences = this.getSharedPreferences("co.edu.udea.campusmovil.notificador_preferences", Context.MODE_PRIVATE); // Obtengo las preferencias del usuario        
        	//listWithPreferences = (ArrayList<ListItem>) elements.subList(0, Integer.parseInt(preferences.getString("number_messages", "10")));//guardo en un nuevo arreglo la cantidad que el usuario escogio, desde una posicion 0 hasta la posicion requerida        	
        	
        	MessageListActivityAdapter adapter = new MessageListActivityAdapter(this,elements);//cargo la cantidad de mensajes que el usuario elige
        	this.list.setAdapter(adapter);
        
        	list.setOnItemClickListener(new OnItemClickListener()//utilizo el listener del listview para capturar la seleccion sobre un elemento de la lista
        	{

        		public void onItemClick(AdapterView<?> parent, View view, int position, long id) 
        		{	
        			//Cambio la apariencia del action bar cuando elijo la opcion search
        			if(in_search == true)
                	{
                		editText.setText(null);
                		editText.setVisibility(View.INVISIBLE);
                    	editText.setClickable(false);        	
                    	
                    	refresh_search.setVisibility(View.VISIBLE);
                    	refresh_search.setClickable(true) ;        	
                    	
                    	separator_search.setVisibility(View.VISIBLE);
                    	separator_search.setClickable(true);
                    	
                    	in_search = false;        		
                	}
        			//Cambio la apariencia del action bar cuando elijo la opcion search
        			
        			ListItem m = (ListItem) list.getItemAtPosition(position);  //creo un objeto del tipo ListItem para pasar informacion de una actividad a otra   							
				
        			Intent intent = new Intent(MessageListActivity.this, MessageActivity.class);
				
        			//Agregamos los datos del mensaje al intent
        			intent.putExtra("date", m.getDate());
        			intent.putExtra("title", m.getTitle());
        			intent.putExtra("sender", m.getSender());
        			intent.putExtra("subject", m.getSubject());
        			intent.putExtra("content", m.getContent());
        			//Agregamos los datos del mensaje al intent
				
        			//Iniciamos el intent que llama a la actividad que muestra el contenido del mensaje
        			startActivity(intent);
        		}
        	
        	} );
        	// En este segmento est� la nueva implementacion del adapter y la implementacion del onItemClickListener
         
        
        
        this.dao = GenericDAO.getInstance(getApplicationContext(), GenericDAO.DATABASE_NAME, Course.TABLE_CREATE, Course.DATABASE_TABLE, 1);
        this.dao = GenericDAO.getInstance(getApplicationContext(), GenericDAO.DATABASE_NAME, Forum.TABLE_CREATE, Forum.DATABASE_TABLE, 1);
        this.dao = GenericDAO.getInstance(getApplicationContext(), GenericDAO.DATABASE_NAME, Message.TABLE_CREATE, Message.DATABASE_TABLE, 1);
    }

  //Opcion menu en la vista de la lista de mensajes, accede al recurso creado en la carpeta res > menu
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return true;
    }

  //Implementacion de cada una de las opciones del menu
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.preferences:
                Intent intent = new Intent(this, PreferencesActivity.class);//con el intent puedo llamar a la clase que maneja el xml settings
                startActivity(intent);

                return true;

            case R.id.about:
                this.dialogo = new Dialog(this);
                this.dialogo.requestWindowFeature(Window.FEATURE_NO_TITLE);
                this.dialogo.setContentView(R.layout.about_text);
                this.dialogo.show();

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
  //Implementacion de cada una de las opciones del menu

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(this.getClass().getName(), "Destroyin the application");
        if (this.dao != null) {
            this.dao.close();
        }
    }   

    private void showError(MootifyException e) {
    	MessageUtil.showError(this, e);
    }


    public void onRefresh(View view) {
        Toast.makeText(this,"Loading Messages ..." , Toast.LENGTH_SHORT).show();

        MessageService serviceMessage =  (MessageService) ServiceLocator.getInstance(ServiceNames.MESSAGE_SERVICE);
       // serviceMessage.findAllMessage(idEstudiante, password, firstRecord, lastRecord)
    }

    private boolean onSaveCourse(Course course) {

        return (this.dao.insertCourse(course));
   }

    private boolean onSaveForum(Forum forum) {

        return (this.dao.insertForum(forum));
    }

    private boolean onSaveMessage(Message message) {

        return (this.dao.insertMessage(message));
    }

    // Método para la opcion buscar mensajes.
    public void onSearch(View view) 
    {
        //Toast.makeText(this,"Seaching Content ..." , Toast.LENGTH_SHORT).show();
    	if(in_search == false)
    	{
    	editText = (EditText) findViewById(R.id.search_box);
    	editText.setVisibility(View.VISIBLE);
    	editText.setClickable(true);    	
    	
    	refresh_search = (ImageButton) findViewById(R.id.refresh);
    	refresh_search.setVisibility(View.INVISIBLE);
    	refresh_search.setClickable(false) ;
    	
    	separator_search = (ImageView) findViewById(R.id.separator3);
    	separator_search.setVisibility(View.INVISIBLE);
    	separator_search.setClickable(false);
    	
    	in_search = true;
    	}
    	else
    	{
    		words = editText.getText().toString();
    		
    		//aqui va el metodo de busqueda en la base de datos del smartphone
    		Toast.makeText(this, words, Toast.LENGTH_LONG).show();
    		//aqui va el metodo de busqueda en la base de datos del smartphone
    		
    		//despues el metodo retorna el resultado y lo infla en la lista de mensajes
    		//despues de encontrar el mensaje se tienen que volver visibles el separador y el boton y hacer invisible el editText
    		
    		editText.setText(null);
    		editText.setVisibility(View.INVISIBLE);
        	editText.setClickable(false);        	
        	
        	refresh_search.setVisibility(View.VISIBLE);
        	refresh_search.setClickable(true) ;        	
        	
        	separator_search.setVisibility(View.VISIBLE);
        	separator_search.setClickable(true);
        	
        	in_search = false;
    	}
    	
        
    }

    public void showQuickActionMenu(View view) {
        Toast.makeText(this, "Showing A QuickAction ...", Toast.LENGTH_LONG).show();

        this.quickAction = new QuickActionMenu(view);
        this.quickAction.showQuickAction(10, 0);
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d("UITest", "Entrando Al Stop...");
        if (this.quickAction != null) {
            this.quickAction.dismiss();
        }
    }    
}
