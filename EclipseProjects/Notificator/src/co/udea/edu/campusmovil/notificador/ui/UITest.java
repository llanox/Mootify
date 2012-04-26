package co.udea.edu.campusmovil.notificador.ui;

import co.udea.edu.campusmovil.notificador.R;
import co.udea.edu.campusmovil.notificador.exceptions.MootifyException;
import co.udea.edu.campusmovil.notificador.helpers.MessageHelper;
import co.udea.edu.campusmovil.notificador.model.ItemLista;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.view.*;
import android.view.View.OnClickListener;

/*
 * Esta clase es utilizada por el momento (temporalmente) para probar los
 * diseños XML, para poder observar como se muestra la información en la
 * ejecución de la aplicación.
 */

public class UITest extends Activity {

    ListView lista;

    // Create an anonymous implementation of OnClickListener.
    private OnClickListener mCorkyListener = new OnClickListener() {
        public void onClick(View v) {
            Intent intent = new Intent(UITest.this, MessageHandler.class);
            startActivity(intent);
        }
    };

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.view_principal);

        lista = (ListView) findViewById(R.id.lista_elementos);
        List<ItemLista> elementos = new ArrayList<ItemLista>();

        try {
            elementos = MessageHelper.findAllMsgs("343434", "sasas");
        } catch (MootifyException e) {
            showError(e);
        }

        Adaptador ad = new Adaptador(this, elementos);
        lista.setAdapter(ad);
    }

    private void showError(MootifyException e) {
        
    }

    // Método para la opcion buscar mensajes.
    public void buscar(View view) {
        Toast.makeText(this,"Buscando contenido..." , Toast.LENGTH_SHORT).show();
    }

    // Método para la opcion filtrar información.
    public void filtrar(View view) {
        Toast.makeText(this,"Filtrando contenido..." , Toast.LENGTH_SHORT).show();
    }

    // Método para la opción leer mensajes.
    public void mensajes(View view) {
        Toast.makeText(this,"Cargando mensajes..." , Toast.LENGTH_SHORT).show();
    }

    // Clase temporal para probar el ListView.
    public class Adaptador extends ArrayAdapter<ItemLista> {
        Activity contexto;

        public Adaptador(Activity contexto, List<ItemLista> elementos) {
            super(contexto, R.layout.item_list, elementos);
            this.contexto = contexto;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = contexto.getLayoutInflater();
            View item = inflater.inflate(R.layout.item_list, null);

            TextView titulo = (TextView)item.findViewById(R.id.titulo_mensaje);
            titulo.setText(getItem(position).getTitulo());

            TextView materia = (TextView) item.findViewById(R.id.materia);
            materia.setText(getItem(position).getMateria());

            item.setOnClickListener(mCorkyListener);

            return item;
        }
    }
}
