package co.udea.edu.campusmovil.notificador.ui;

import co.udea.edu.campusmovil.notificador.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/*
 * Esta clase contiene la primera actividad que se ejecuta una vez iniciada la
 * aplicación, contiene dos métodos, el "onCreate" que son las acciones que se
 * hacen recién se inicia la actividad. Otro método "login" que lo único que
 * hace es llevarnos a la actividad UiTest.
 */

public class AppNotificadorActivity extends Activity {

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.main);               //Cargamos el layout main.
    }

    //Pasamos de la actividad AppNotificador a la actividad UiTest
    public void login(View view) {
        Intent intent = new Intent(AppNotificadorActivity.this, UITest.class);
        this.startActivity(intent);
    }
}