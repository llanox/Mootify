package co.edu.udea.campusmovil.model;

import co.edu.udea.campusmovil.R;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

/*
 * Clase usada para adaptar, crear y llenar cada fila de la ListView con elementos personalizados
 * y definidos en un archivo XML definido aparte.
 */
public class StudentListAdapter extends ArrayAdapter<Student> {

    private int idLayout;
    private ArrayList<Student> studentArray;

    public StudentListAdapter(Activity activity, int idLayout, ArrayList<Student> studentArray) {
        super(activity, idLayout, studentArray);
        this.idLayout = idLayout;
        this.studentArray = studentArray;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        /*
         * Método usado para pintar cada componente de la fila de la ListView con unos datos
         * personalizados dados por los objetos contenidos en el ArrayList de Students.
         */
        View view = convertView;
        final ViewHolder viewHolder;

        if (view == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(this.idLayout, null);

            viewHolder = new ViewHolder();
            viewHolder.imageList = (ImageButton) view.findViewById(R.id.imagebutton_quickaction);
            viewHolder.fullNameTextView = (TextView) view.findViewById(R.id.full_name);
            viewHolder.idNumberTextView = (TextView) view.findViewById(R.id.id_number);
            viewHolder.ageTextView = (TextView) view.findViewById(R.id.age);

            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        /*
         * Asignemos un texto a cada TextView y así se hará para cada uno de los objetos
         * Student dentro del ArrayList usando en el contructor de la clase.
         */
        viewHolder.imageList.setImageResource(R.drawable.ic_menu_more);
        viewHolder.fullNameTextView.setText(this.studentArray.get(position).getFullName());
        viewHolder.idNumberTextView.setText("C.C.: " + this.studentArray.get(position).getIdNumber());
        viewHolder.ageTextView.setText("Edad: " + this.studentArray.get(position).getAge());

        return (view);
    }

    static class ViewHolder {

        private ImageButton imageList;
        private TextView fullNameTextView;
        private TextView idNumberTextView;
        private TextView ageTextView;
    }
}
