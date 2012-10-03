package co.edu.udea.campusmovil.notificador.ui;

import co.edu.udea.campusmovil.notificador.R;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

public class MessageActivity extends Activity 
{
    Dialog dialogo;
    // Variables para acceder a los extras de la actividad anterior
    String date;
    String title;
    String sender;
    String subject;      
    String content;
   // Variables para acceder a los extras de la actividad anterior 
    
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.view_menssage);
        
        // Este segmento es el encargado de recibir los datos que vienen de la actividad anterior MessageListActivity
         
        Bundle datos = this.getIntent().getExtras();
        
        //accedo a los extras y les asigno el valor a las variables de la clase actual
        date = new String(datos.getString("date"));
        title = new String(datos.getString("title"));
        sender = new String(datos.getString("sender"));        
        subject = new String(datos.getString("subject"));
        content = new String(datos.getString("content"));
        //accedo a los extras y les asigno el valor a las variables de la clase actual
        
        //dibujo en el MessageActivity el valor traido de la actividad MessageListActivity
        TextView titleMessage = (TextView) findViewById(R.id.asunto);
        titleMessage.setText(title);
        
        TextView subjectMessage = (TextView) findViewById(R.id.curso);
        subjectMessage.setText(subject);
        
        TextView senderMessage = (TextView) findViewById(R.id.remitente);
        senderMessage.setText(sender);
        
        TextView dateMessage = (TextView) findViewById(R.id.fecha);
        dateMessage.setText(date);        
        
        TextView contentMessage = (TextView) findViewById(R.id.cuerpo_mensaje);
        contentMessage.setText(content);
        
        //dibujo en el MessageActivity el valor traido de la actividad MessageListActivity
        
        //Este segmento es el encargado de recibir los datos que vienen de la actividad anterior MessageListActivity
        
    }

  //Opción menu de preferencias en la vista del mensaje, accede al recurso creado en la carpeta res > menu
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

    public void onShare(View view) {
        Intent intent=new Intent(android.content.Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);

        String[] msgData = createMsgToShare();
        // Add data to the intent, the receiving app will decide what to do with it.
        intent.putExtra(Intent.EXTRA_SUBJECT,msgData[0] );
        intent.putExtra(Intent.EXTRA_TEXT, msgData[1]);

        this.startActivity(intent);
    }

    private String[] createMsgToShare() {
        String[] data = new String[2];

        String subject=((TextView)this.findViewById(R.id.asunto)).getText().toString();
        String rem = ((TextView)this.findViewById(R.id.remitente)).getText().toString();
        String content =((TextView)this.findViewById(R.id.cuerpo_mensaje)).getText().toString();
        String fecha =((TextView)this.findViewById(R.id.fecha)).getText().toString();
        String udeArroba = "Ude@-M: ";

        StringBuffer sb = new StringBuffer();
        sb.append(udeArroba);
        sb.append("\"");
        sb.append(subject);
        sb.append("\"");

        data[0]= sb.toString();
        sb.delete(0, sb.length()-1);

        sb.append("\n");
        sb.append("\n");
        sb.append(rem);
        sb.append("\n");
        sb.append(content);
        sb.append("\n");
        sb.append(fecha);

        data[1] = sb.toString();

        return data;
    }

    public void onSave(View view) {
        Toast.makeText(this,"Saving Content ..." , Toast.LENGTH_SHORT).show();
    }

    public void onDelete(View view) {
        Toast.makeText(this,"Deleting Content ..." , Toast.LENGTH_SHORT).show();
    }
}
