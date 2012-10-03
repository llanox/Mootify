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

        lista.add(new ListItem("12/35/89","Prueba de contenido 1","Carlos Marín","Ingles I","Ya pueden ver la Nota del primer parcial en Ude@ ó MARES"));
        lista.add(new ListItem("12/35/89","Prueba de contenido 2","Maria Tabares","Ingles II","Recuerden enviar el taller 2 de la unidad uno, solo recibo trabajos hasta este miercoles."));
        lista.add(new ListItem("12/35/89","Prueba de contenido 3","Claudia Tamayo","Ingles III","Hoy clase virtual por wiziq a las 10 am"));
        lista.add(new ListItem("12/35/89","Prueba de contenido 4","Esteban Jaramillo","Ingles IV","Estudien mucho, dentro de poco tendremos la prueba de competencia lectora."));
        lista.add(new ListItem("12/35/89","Prueba de contenido 5","Juan Castañeda","Ingles V","De hoy en ocho dias es la prueba de listening, estudien mucho!"));
        lista.add(new ListItem("12/35/89","Prueba de contenido 6","Natalia Gil","Ingles VI","Ya estan listas las notas de los talleres 1 y 3, las pueden consultar en Ude@ ó MARES"));
        lista.add(new ListItem("12/35/89","Prueba de contenido 7","Diana Garcia","Español","Recuerden leer el artículo: La ciencia de aprender para la clase de mañana"));
        lista.add(new ListItem("12/35/89","Prueba de contenido 8","Alberto Mesa","Álgebra y trigonometría","Para los que necesiten el libro guia de la asignatura, pueden buscarlo en los bajos de la biblioteca en formato digital."));
        lista.add(new ListItem("12/35/89","Prueba de contenido 9","Fanny Hoz","Cálculo I","El video tutorial de la unnidad 3 está disponible en la seccion apoyo de zona ude@"));
        lista.add(new ListItem("12/35/89","Prueba de contenido 10","Fredy Taborda","Cálculo II","El viernes es el primer parcial, los espero el miercoles en la oficina de profesores para dar un taller grupal."));
        lista.add(new ListItem("12/35/89","Prueba de contenido 11","Mariano","Cálculo III","Prueba final el jueves! taller el martes en el salon."));
        lista.add(new ListItem("12/35/89","Prueba de contenido 12","Obed Marín","Química I","Practica de laboratorio hoy a las 2 pm."));
        lista.add(new ListItem("12/35/89","Prueba de contenido 13","Mariano","Química II","Nota 13"));
        lista.add(new ListItem("12/35/89","Prueba de contenido 14","Mariano","Química II","Nota 14"));
        lista.add(new ListItem("12/35/89","Prueba de contenido 15","Mariano","Química II","Nota 15"));
        lista.add(new ListItem("12/35/89","Prueba de contenido 16","Mariano","Química II","Nota 16"));
        lista.add(new ListItem("12/35/89","Prueba de contenido 17","Mariano","Química II","Nota 17"));
        lista.add(new ListItem("12/35/89","Prueba de contenido 18","Mariano","Química II","Nota 18"));
        lista.add(new ListItem("12/35/89","Prueba de contenido 19","Mariano","Química II","Nota 19"));
        lista.add(new ListItem("12/35/89","Prueba de contenido 20","Mariano","Química II","Nota 20"));
        lista.add(new ListItem("12/35/89","Prueba de contenido 21","Mariano","Química II","Nota 21"));
        lista.add(new ListItem("12/35/89","Prueba de contenido 22","Mariano","Química II","Nota 22"));
        lista.add(new ListItem("12/35/89","Prueba de contenido 23","Mariano","Química II","Nota 23"));
        lista.add(new ListItem("12/35/89","Prueba de contenido 24","Mariano","Química II","Nota 24"));
        lista.add(new ListItem("12/35/89","Prueba de contenido 25","Mariano","Química II","Nota 25"));
        lista.add(new ListItem("12/35/89","Prueba de contenido 26","Mariano","Química II","Nota 26"));
        lista.add(new ListItem("12/35/89","Prueba de contenido 27","Mariano","Química II","Nota 27"));
        lista.add(new ListItem("12/35/89","Prueba de contenido 28","Mariano","Química II","Nota 28"));
        lista.add(new ListItem("12/35/89","Prueba de contenido 29","Mariano","Química II","Nota 29"));
        lista.add(new ListItem("12/35/89","Prueba de contenido 30","Mariano","Química II","Nota 30"));
        lista.add(new ListItem("12/35/89","Prueba de contenido 31","Mariano","Química II","Nota 31"));
        lista.add(new ListItem("12/35/89","Prueba de contenido 32","Mariano","Química II","Nota 32"));

        return lista;
    }
}
