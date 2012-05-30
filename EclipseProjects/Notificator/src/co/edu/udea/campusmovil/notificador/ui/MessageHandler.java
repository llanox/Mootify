package co.edu.udea.campusmovil.notificador.ui;

import co.edu.udea.campusmovil.notificador.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MessageHandler extends Activity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.view_menssage);
    }

    public void onShare(View view) {
        Toast.makeText(this,"Sharing Content ..." , Toast.LENGTH_SHORT).show();
    }

    public void onSave(View view) {
        Toast.makeText(this,"Saving Content ..." , Toast.LENGTH_SHORT).show();
    }

    public void onDelete(View view) {
        Toast.makeText(this,"Deleting Content ..." , Toast.LENGTH_SHORT).show();
    }
}
