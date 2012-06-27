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
import android.database.Cursor;
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

        this.dao = GenericDAO.getInstance(getApplicationContext(), UITest.DATABASE_NAME, Course.TABLE_CREATE, Course.DATABASE_TABLE, 1);
        this.dao = GenericDAO.getInstance(getApplicationContext(), UITest.DATABASE_NAME, Forum.TABLE_CREATE, Forum.DATABASE_TABLE, 1);
        this.dao = GenericDAO.getInstance(getApplicationContext(), UITest.DATABASE_NAME, Message.TABLE_CREATE, Message.DATABASE_TABLE, 1);
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
    public void onRefresh(View view) {
        Toast.makeText(this,"Loading Messages ..." , Toast.LENGTH_SHORT).show();

        /*int temp1 = 0, temp2 = 0, temp3 = 0;
        if (this.dao != null) {
            for (int c = 0; c < 5; c++) {
                Course course = new Course("" + temp1, "Course #" + (temp1 + 1));
                this.onSaveCourse(course);
                for (int f = 0; f < 10; f++) {
                    Forum forum = new Forum("" + temp2, "Forum #" + (temp1 + 1) * (temp2 + 1),
                        "Forum Type #" + (temp1 * temp2), "" + temp1);
                    this.onSaveForum(forum);
                    for (int m = 0; m < 20; m++) {
                        Message message = new Message("" + temp3,
                            "Message #" + (temp1 + 1) * (temp1 + 2) * (temp3 + 1),
                            "Date: " + (c + 1) * (f + 1) * (m + 1), "This is the message ... " + (temp1 + 1) * (temp1 + 2) * (temp3 + 1),
                            "" + temp2);
                        this.onSaveMessage(message);
                        temp3++;
                    }
                    temp2++;
                }
                temp1++;
            }
        }*/

        //int counter = this.dao.deleteCourse("0");
        //Toast.makeText(getApplicationContext(), "Eliminated: " + counter, Toast.LENGTH_SHORT).show();
        
        /*Cursor cursor = this.dao.getAllFromTable(Course.DATABASE_TABLE, Course.COLS);
        cursor.moveToFirst();
        int indexId = cursor.getColumnIndex(Course.COLS[1]);
        int indexName = cursor.getColumnIndex(Course.COLS[2]);

        for (int i = 0; i < cursor.getCount(); i++) {
            String id = cursor.getString(indexId);
            String name = cursor.getString(indexName);
            Course course = new Course(id, name);

            Toast.makeText(getApplicationContext(), "Course #" + (i + 1) + "\n\nID: " + course.getId() + "\nName: " + course.getName(), Toast.LENGTH_SHORT).show();
            cursor.moveToNext();
        }
        cursor.close();*/
    }

    private void onSaveCourse(Course course) {
         if (this.dao != null) {
            ContentValues values = new ContentValues();
            values.put(Course.COLS[1], course.getId());
            values.put(Course.COLS[2], course.getName());
            this.dao.insert(Course.DATABASE_TABLE, values);
         }
    }

    private void onSaveForum(Forum forum) {
        if (this.dao != null) {
            ContentValues values = new ContentValues();
            values.put(Forum.COLS[1], forum.getId());
            values.put(Forum.COLS[2], forum.getName());
            values.put(Forum.COLS[3], forum.getType());
            values.put(Forum.COLS[4], forum.getCourseId());			// course.getId();
            this.dao.insert(Forum.DATABASE_TABLE, values);
        }
    }

    private void onSaveMessage(Message message) {
        if (this.dao != null) {
            ContentValues values = new ContentValues();
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

            TextView title = (TextView) item.findViewById(R.id.message_title);
            title.setText(getItem(position).getTitle());

            TextView materia = (TextView) item.findViewById(R.id.subject);
            materia.setText(getItem(position).getSubject());

            item.setOnClickListener(mCorkyListener);

            return item;
        }
    }
}
