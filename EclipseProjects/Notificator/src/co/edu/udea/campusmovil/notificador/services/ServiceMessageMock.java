package co.edu.udea.campusmovil.notificador.services;

import java.util.ArrayList;
import java.util.List;

import co.edu.udea.campusmovil.notificador.model.ListItem;

import android.util.Log;


public class ServiceMessageMock implements MessageService {

    public List<ListItem> findAllMessage(String idEstudiante, String password, int firstRecord, int lastRecord) {
        List<ListItem>  lista =  new ArrayList<ListItem>();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Log.e("ServiceMessageMock","Error al emular la espera al leer servicio",e);
        }

        lista.add(new ListItem("Prueba de contenido 1","Ingles I","12/35/89","Nota 1"));
        lista.add(new ListItem("Prueba de contenido 2","Ingles II","12/35/89","Nota 2"));
        lista.add(new ListItem("Prueba de contenido 3","Ingles III","12/35/89","Nota 3"));
        lista.add(new ListItem("Prueba de contenido 4","Ingles IV","12/35/89","Nota 4"));
        lista.add(new ListItem("Prueba de contenido 5","Ingles V","12/35/89","Nota 5"));
        lista.add(new ListItem("Prueba de contenido 6","Ingles VI","12/35/89","Nota 6"));
        lista.add(new ListItem("Prueba de contenido 7","Espa�ol","12/35/89","Nota 7"));
        lista.add(new ListItem("Prueba de contenido 8","�lgebra y trigonometr�a","12/35/89","Nota 8"));
        lista.add(new ListItem("Prueba de contenido 9","C�lculo I","12/35/89","Nota 9"));
        lista.add(new ListItem("Prueba de contenido 10","C�lculo II","12/35/89","Nota 10"));
        lista.add(new ListItem("Prueba de contenido 11","C�lculo III","12/35/89","Nota 11"));
        lista.add(new ListItem("Prueba de contenido 12","Qu�mica I","12/35/89","Nota 12"));
        lista.add(new ListItem("Prueba de contenido 13","Qu�mica II","12/35/89","Nota 13"));
        lista.add(new ListItem("Prueba de contenido 14","F�sica I","12/35/89","Nota 14"));
        lista.add(new ListItem("Prueba de contenido 15","F�sica II","12/35/89","Nota 15"));
        lista.add(new ListItem("Prueba de contenido 16","F�sica II","12/35/89","Nota 16"));
        lista.add(new ListItem("Prueba de contenido 17","F�sica II","12/35/89","Nota 17"));
        lista.add(new ListItem("Prueba de contenido 18","F�sica II","12/35/89","Nota 18"));
        lista.add(new ListItem("Prueba de contenido 19","F�sica II","12/35/89","Nota 19"));
        lista.add(new ListItem("Prueba de contenido 20","F�sica II","12/35/89","Nota 20"));
        lista.add(new ListItem("Prueba de contenido 21","F�sica II","12/35/89","Nota 21"));
        lista.add(new ListItem("Prueba de contenido 22","F�sica II","12/35/89","Nota 22"));
        lista.add(new ListItem("Prueba de contenido 23","F�sica II","12/35/89","Nota 23"));
        lista.add(new ListItem("Prueba de contenido 24","F�sica II","12/35/89","Nota 24"));
        lista.add(new ListItem("Prueba de contenido 25","F�sica II","12/35/89","Nota 25"));
        lista.add(new ListItem("Prueba de contenido 26","F�sica II","12/35/89","Nota 26"));
        lista.add(new ListItem("Prueba de contenido 27","F�sica II","12/35/89","Nota 27"));
        lista.add(new ListItem("Prueba de contenido 28","F�sica II","12/35/89","Nota 28"));
        lista.add(new ListItem("Prueba de contenido 29","F�sica II","12/35/89","Nota 29"));
        lista.add(new ListItem("Prueba de contenido 30","F�sica II","12/35/89","Nota 30"));
        lista.add(new ListItem("Prueba de contenido 31","F�sica II","12/35/89","Nota 31"));
        lista.add(new ListItem("Prueba de contenido 32","F�sica II","12/35/89","Nota 32"));

        return lista;
    }
}
