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
	
		
		return lista;
	}

}
