package co.edu.udea.campusmovil;

import android.content.Intent;
import greendroid.app.GDApplication;

public class GreendroidDemo extends GDApplication {

    /*
     * Esta clase había que definirla para convertir nuestra aplicación en una
     * Aplicación basada en Greendroid y así poder usar las componentes o Widgets
     * provistos por dicha librería.
     */

    /*@Override
    public Class<GreendroidDemo> getHomeActivityClass() {

        return GreendroidDemo.class;
    }*/

    @Override
    public Intent getMainApplicationIntent() {
        return new Intent(Intent.ACTION_DEFAULT);
    }
}
