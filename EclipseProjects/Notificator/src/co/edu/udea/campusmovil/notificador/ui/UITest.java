package co.edu.udea.campusmovil.notificador.ui;

import co.edu.udea.campusmovil.notificador.exceptions.MootifyException;
import co.edu.udea.campusmovil.notificador.helpers.GenericDAO;
import co.edu.udea.campusmovil.notificador.helpers.MessageHelper;
import co.edu.udea.campusmovil.notificador.model.Course;
import co.edu.udea.campusmovil.notificador.model.Forum;
import co.edu.udea.campusmovil.notificador.model.ListItem;
import co.edu.udea.campusmovil.notificador.model.Message;
import co.edu.udea.campusmovil.notificador.ui.quickaction.QuickActionMenu;
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
import android.util.Log;
import android.view.*;
import android.view.View.OnClickListener;

/*
 * Esta clase es utilizada por el momento (temporalmente) para probar los
 * diseños XML, para poder observar como se muestra la información en la
 * ejecución de la aplicación.
 */

public class UITest extends Activity {

    public static String DATABASE_NAME = "Mootify";
    public static int DATABASE_VERSION = 1;

    private GenericDAO dao;
    private ListView list;
    private QuickActionMenu quickAction;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.principal_view);

        list = (ListView) findViewById(R.id.elements_list);
        List<ListItem> elementos = new ArrayList<ListItem>();

        try {
            elementos = MessageHelper.findAllMsgs("343434", "sasas");
        } catch (MootifyException e) {
            showError(e);
        }

        Adaptador ad = new Adaptador(this, elementos);
        list.setAdapter(ad);
        
        this.dao = GenericDAO.getInstance(getApplicationContext(), DATABASE_NAME, Course.TABLE_CREATE, Course.DATABASE_TABLE, 1);
        this.dao = GenericDAO.getInstance(getApplicationContext(), DATABASE_NAME, Forum.TABLE_CREATE, Forum.DATABASE_TABLE, 1);
        this.dao = GenericDAO.getInstance(getApplicationContext(), DATABASE_NAME, Message.TABLE_CREATE, Message.DATABASE_TABLE, 1);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        if (this.dao != null) {
            this.dao.close();
        }
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
    public void onFilter(View view) {
        Toast.makeText(this,"Filtering Content ..." , Toast.LENGTH_SHORT).show();
    }

    // Método para la opción leer mensajes.
    public void onMessage(View view) {
        Toast.makeText(this,"Loading Messages ..." , Toast.LENGTH_SHORT).show();
    }

    // Método para la opcion buscar mensajes.
    public void onSearch(View view) {
        Toast.makeText(this,"Seaching Content ..." , Toast.LENGTH_SHORT).show();
    }

    public void showQuickActionMenu(View view) {
        Toast.makeText(this, "Showing A QuickAction ...", Toast.LENGTH_LONG).show();
        
        this.quickAction = new QuickActionMenu(view);
        this.quickAction.showQuickAction(10, 0);
    }

    @Override
    protected void onStop() {
        super.onStart();

        Log.d("UITest", "Entrando Al Stop...");
        if (this.quickAction != null) {
            this.quickAction.dismiss();
        }
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
