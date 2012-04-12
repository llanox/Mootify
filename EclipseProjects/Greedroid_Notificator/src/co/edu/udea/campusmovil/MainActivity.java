package co.edu.udea.campusmovil;

import co.edu.udea.campusmovil.model.Student;
import co.edu.udea.campusmovil.model.StudentListAdapter;

import java.util.ArrayList;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import greendroid.app.GDActivity;
import greendroid.widget.QuickActionWidget;
import greendroid.widget.QuickAction;
import greendroid.widget.QuickActionBar;
import greendroid.widget.QuickActionWidget.OnQuickActionClickListener;

public class MainActivity extends GDActivity {

    /*
     * Esto lo he hecho siguiendo los tutoriales y ejemplos mostrados aquí en las páginas. Además,
     * he importado y usado la librerías de "Greendroid".
     * 
     * http://androideity.com/2011/09/30/primeros-pasos-con-greendroid/
     * http://www.newspinrobotics.com/index.php/blog/using-green-droid-s-quick-action-bar/
     * 
     * Les recomiendo que lean las páginas.
     */

    private ArrayList<Student> myStudent;         // Elementos para inflar el Layout.
    private Button myButton;                      // El botón que tenemos en la interfaz.
    private QuickActionWidget quickActions;       // El Objeto QuickAction para ser mostrado en pantalla.

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*
         * Este método es algo así parecido al que hemos estado acostumbrados: setContentView(...)
         * pero se tiene que definir de este modo para que pueda aparecer la ActionBar y el QuickAtion.
         */
        this.setActionBarContentView(R.layout.main);

        // Método para inflar el Layout y crear el botón de la interfaz.
        initComponents();
        // Método usado para crear el QuickAction con sus textos e iconos.
        initQuickAction();
    }

    private void initComponents() {
        // Llenemos es Array con Objetos Student.java.
        this.myStudent = new ArrayList<Student>();
        this.myStudent.add(new Student("Neiber Padierna", 123456789L, (byte) 20));
        this.myStudent.add(new Student("Gabriel Gutierrez", 987654321L, (byte) 45));
        this.myStudent.add(new Student("Danny Munera", 123987465L, (byte) 28));
        this.myStudent.trimToSize();

        // Creando un adaptador común y corriente. Ojo, mirar que se tiene: "R.layout.customized_list_row".
        StudentListAdapter myAdapter = new StudentListAdapter(this, R.layout.customized_list_row, this.myStudent);

        // La ListView contenida en el recurso "main.xml", la adaptaremos a nuestro modo.
        ListView myListView = (ListView) this.findViewById(R.id.studentListView);
        myListView.setAdapter(myAdapter);

        // El botón que está en el "main.xml" usado para mostrar un QuickAction.
        this.myButton = (Button) this.findViewById(R.id.test_button);
        this.myButton.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                // Método para mostrar el QuickAction.
                quickActions.show(myButton);
            }
        });
    }

    private void initQuickAction() {
        /*
         * Este método lo usaremos para crear el Objeto QuickAction que mostraremos en nuestra Interfaz
         * le pondremos un texto y un icono además, añadiremos un escuchador de eventos para saber cuál
         * fue la opción escogida por el usuario.
         */
        this.quickActions = new QuickActionBar(this);
        // Le asignamos un opción con texto e imagen.
        this.quickActions.addQuickAction(new QuickAction(this, R.drawable.ic_quickaction_music, "Music"));
        this.quickActions.addQuickAction(new QuickAction(this, R.drawable.ic_quickaction_note, "Note"));
        this.quickActions.addQuickAction(new QuickAction(this, R.drawable.ic_quickaction_settings, "Setting"));

        this.quickActions.setOnQuickActionClickListener(new OnQuickActionClickListener() {
            public void onQuickActionClicked(QuickActionWidget widget, int position) {
                // Un simple Toast, para cuando el usuario da clic en una opción del QuickAction.
                Toast.makeText(getBaseContext(), "Item: " + position + " clicked!!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /*
     * Este método es invocado por el listener que yo le he asigando al ImageButton. Es decir, la imágen
     * al lado derecho de cada elemento en el ListView personalizado.
     * 
     * ME GUSTARÍA HABLAR MÁS A FONDO DE ESTA PARTE.
     */
    public void onShowQuickActionMenu(View view) {
        // Mostramos el QuickAction.
        quickActions.show(view);
    }

    /*
     * Como se podría dar clic en el ImageButton o en Layout que lo contiene, entonces, el Layout debería
     * tener un escuchador también.
     * 
     * ME GUSTARÍA HABLAR MÁS A FONDO DE ESTA PARTE.
     */
    public void onLayoutClick(View view) {
        // Tomamos los componentes TextView del Layout y extraemos sus textos.
        TextView fullName = (TextView) view.findViewById(R.id.full_name);
        TextView idNumber = (TextView) view.findViewById(R.id.id_number);
        TextView age = (TextView) view.findViewById(R.id.age);

        // Un simple Toast para ver los datos.
        Toast.makeText(getBaseContext(), "Student:\n\nFull Name: " + fullName.getText() + "\n" + idNumber.getText() + "\n" + age.getText(),
                Toast.LENGTH_LONG).show();
    }
}