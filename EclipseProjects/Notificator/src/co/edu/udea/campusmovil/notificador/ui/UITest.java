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
import android.content.ContentValues;
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

        if (this.dao != null) {
            Course c = new Course("INGEMPLEADOS", "Ingles I - Empleados");
            Forum f = new Forum("9219", "Novedades y anuncios", "news", "INGEMPLEADOS");
            Message m = new Message("37037", "CHAT DEL DIA MIERCOLES 9 DE MARZO DE 2010", "2011-03-09 11:33:32",
                "My dear students:\nI will be in the chat today Wednesday from" +
                " 4:30 to 5:30 if you have something to share. Have a nice day, Olga Gil .\n\nComo ya se" +
                " termina el capitulo 1 esta semana, al principio de la otra semana enviar\u00e8 feedback" +
                " a todos los que han enviado las tareas.\nRecuerden que el caso de estudio para la Unidad" +
                " 1, es conseguir un amgio a trav\u00e9s de www.italki.com y solicitarle todos los datos\nPor" +
                " favoro ingresen a www.skpe.com abran una cuenta y tan pronto la tengan me envian su password" +
                " para yo agregarlos porque la semana entrante ustedes deber\u00e0n estar presentando el caso" +
                " de estudio que\ndebe ser comunicarse conmigo por skpe, saludarme en ingl\u00e9s hacer su" +
                " presentaci\u00f2n personal y la de la persona que conoci\u00f2 por skype.\nEspero la" +
                " participaci\u00f2n de todos. Feliz dia, Olga Gil \n", "9219");

            this.onSave(c, f, m);
        }
    }

    private void onSave(Course course, Forum forum, Message message) {
        if (this.dao != null) {
            ContentValues values = new ContentValues();
            values.put(Course.COLS[1], course.getId());
            values.put(Course.COLS[2], course.getName());
            this.dao.insert(Course.DATABASE_TABLE, values);

            values = new ContentValues();
            values.put(Forum.COLS[1], forum.getId());
            values.put(Forum.COLS[2], forum.getName());
            values.put(Forum.COLS[3], forum.getType());
            values.put(Forum.COLS[4], forum.getCourseId());			// course.getId();
            this.dao.insert(Forum.DATABASE_TABLE, values);

            values = new ContentValues();
            values.put(Message.COLS[1], message.getId());
            values.put(Message.COLS[2], message.getName());
            values.put(Message.COLS[3], message.getDate());
            values.put(Message.COLS[4], message.getContent());
            values.put(Message.COLS[5], message.getForumId());		// forum.getId();
            this.dao.insert(Message.DATABASE_TABLE, values);
        }
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
        super.onStop();

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
