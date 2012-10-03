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

        lista.add(new ListItem("12/35/89","Prueba de contenido 1","Carlos Mar�n","Ingles I","Ya pueden ver la Nota del primer parcial en Ude@ � MARES"));
        lista.add(new ListItem("12/35/89","Prueba de contenido 2","Maria Tabares","Ingles II","Recuerden enviar el taller 2 de la unidad uno, solo recibo trabajos hasta este miercoles."));
        lista.add(new ListItem("12/35/89","Prueba de contenido 3","Claudia Tamayo","Ingles III","Hoy clase virtual por wiziq a las 10 am"));
        lista.add(new ListItem("12/35/89","Prueba de contenido 4","Esteban Jaramillo","Ingles IV","Estudien mucho, dentro de poco tendremos la prueba de competencia lectora."));
        lista.add(new ListItem("12/35/89","Prueba de contenido 5","Juan Casta�eda","Ingles V","De hoy en ocho dias es la prueba de listening, estudien mucho!"));
        lista.add(new ListItem("12/35/89","Prueba de contenido 6","Natalia Gil","Ingles VI","Ya estan listas las notas de los talleres 1 y 3, las pueden consultar en Ude@ � MARES"));
        lista.add(new ListItem("12/35/89","Prueba de contenido 7","Diana Garcia","Espa�ol","Recuerden leer el art�culo: La ciencia de aprender para la clase de ma�ana"));
        lista.add(new ListItem("12/35/89","Prueba de contenido 8","Alberto Mesa","�lgebra y trigonometr�a","Para los que necesiten el libro guia de la asignatura, pueden buscarlo en los bajos de la biblioteca en formato digital."));
        lista.add(new ListItem("12/35/89","Prueba de contenido 9","Fanny Hoz","C�lculo I","El video tutorial de la unnidad 3 est� disponible en la seccion apoyo de zona ude@"));
        lista.add(new ListItem("12/35/89","Prueba de contenido 10","Fredy Taborda","C�lculo II","El viernes es el primer parcial, los espero el miercoles en la oficina de profesores para dar un taller grupal."));
        lista.add(new ListItem("12/35/89","Prueba de contenido 11","Mariano","C�lculo III","Prueba final el jueves! taller el martes en el salon."));
        lista.add(new ListItem("12/35/89","Prueba de contenido 12","Obed Mar�n","Qu�mica I","Practica de laboratorio hoy a las 2 pm."));
        lista.add(new ListItem("12/35/89","Prueba de contenido 13","Mariano","Qu�mica II","Nota 13"));
        lista.add(new ListItem("12/35/89","Prueba de contenido 14","Mariano","Qu�mica II","Nota 14"));
        lista.add(new ListItem("12/35/89","Prueba de contenido 15","Mariano","Qu�mica II","Nota 15"));
        lista.add(new ListItem("12/35/89","Prueba de contenido 16","Mariano","Qu�mica II","Nota 16"));
        lista.add(new ListItem("12/35/89","Prueba de contenido 17","Mariano","Qu�mica II","Nota 17"));
        lista.add(new ListItem("12/35/89","Prueba de contenido 18","Mariano","Qu�mica II","Nota 18"));
        lista.add(new ListItem("12/35/89","Prueba de contenido 19","Mariano","Qu�mica II","Nota 19"));
        lista.add(new ListItem("12/35/89","Prueba de contenido 20","Mariano","Qu�mica II","Nota 20"));
        lista.add(new ListItem("12/35/89","Prueba de contenido 21","Mariano","Qu�mica II","Nota 21"));
        lista.add(new ListItem("12/35/89","Prueba de contenido 22","Mariano","Qu�mica II","Nota 22"));
        lista.add(new ListItem("12/35/89","Prueba de contenido 23","Mariano","Qu�mica II","Nota 23"));
        lista.add(new ListItem("12/35/89","Prueba de contenido 24","Mariano","Qu�mica II","Nota 24"));
        lista.add(new ListItem("12/35/89","Prueba de contenido 25","Mariano","Qu�mica II","Nota 25"));
        lista.add(new ListItem("12/35/89","Prueba de contenido 26","Mariano","Qu�mica II","Nota 26"));
        lista.add(new ListItem("12/35/89","Prueba de contenido 27","Mariano","Qu�mica II","Nota 27"));
        lista.add(new ListItem("12/35/89","Prueba de contenido 28","Mariano","Qu�mica II","Nota 28"));
        lista.add(new ListItem("12/35/89","Prueba de contenido 29","Mariano","Qu�mica II","Nota 29"));
        lista.add(new ListItem("12/35/89","Prueba de contenido 30","Mariano","Qu�mica II","Nota 30"));
        lista.add(new ListItem("12/35/89","Prueba de contenido 31","Mariano","Qu�mica II","Nota 31"));
        lista.add(new ListItem("12/35/89","Prueba de contenido 32","Mariano","Qu�mica II","Nota 32"));

        return lista;
    }
}
