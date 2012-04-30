package co.edu.udea.campusmovil.notificador.ui;

import co.edu.udea.campusmovil.notificador.exceptions.MootifyException;
import co.edu.udea.campusmovil.notificador.helpers.MessageHelper;
import co.edu.udea.campusmovil.notificador.model.ListItem;
import co.edu.udea.campusmovil.notificador.R;

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

    private ListView list;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.view_principal);

        list = (ListView) findViewById(R.id.elements_list);
        List<ListItem> elementos = new ArrayList<ListItem>();

        try {
            elementos = MessageHelper.findAllMsgs("343434", "sasas");
        } catch (MootifyException e) {
            showError(e);
        }

        Adaptador ad = new Adaptador(this, elementos);
        list.setAdapter(ad);
    }

    // Create an anonymous implementation of OnClickListener.
    private OnClickListener mCorkyListener = new OnClickListener() {
        public void onClick(View v) {
            Intent intent = new Intent(UITest.this, MessageHandler.class);
            startActivity(intent);
        }
    };

    private void showError(MootifyException e) {
        
    }

    // Método para la opcion filtrar información.
    public void filter(View view) {
        Toast.makeText(this,"Filtering Content ..." , Toast.LENGTH_SHORT).show();
    }

    // Método para la opción leer mensajes.
    public void message(View view) {
        Toast.makeText(this,"Loading Messages ..." , Toast.LENGTH_SHORT).show();
    }

    // Método para la opcion buscar mensajes.
    public void search(View view) {
        Toast.makeText(this,"Seaching Content ..." , Toast.LENGTH_SHORT).show();
    }

    public void showQuickActionMenu(View view) {
        Toast.makeText(this, "Showing A QuickAction ...", Toast.LENGTH_LONG).show();
    }

    // Clase temporal para probar el ListView.
    private class Adaptador extends ArrayAdapter<ListItem> {
        private Activity activity;

        public Adaptador(Activity activity, List<ListItem> element) {
            super(activity, R.layout.item_list, element);
            this.activity = activity;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = activity.getLayoutInflater();
            View item = inflater.inflate(R.layout.item_list, null);

            TextView title = (TextView)item.findViewById(R.id.message_title);
            title.setText(getItem(position).getTitle());

            TextView materia = (TextView) item.findViewById(R.id.subject);
            materia.setText(getItem(position).getSubject());

            item.setOnClickListener(mCorkyListener);

            return item;
        }
    }
}
