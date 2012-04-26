package co.udea.edu.campusmovil.notificador.services;

import java.util.ArrayList;
import java.util.List;

import co.udea.edu.campusmovil.notificador.model.ItemLista;

import android.util.Log;


public class ServiceMessageMock implements MessageService {

	public List<ItemLista> findAllMessage(String idEstudiante, String password, int firstRecord, int lastRecord) {
		List<ItemLista>  lista =  new ArrayList<ItemLista>();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		
			Log.e("ServiceMessageMock","Error al emular la espera al leer servicio",e);
			
		}
		
		lista.add(new ItemLista("Prueba de contenido 1","Ingles I","12/35/89","Nota 1"));
		lista.add(new ItemLista("Prueba de contenido 2","Ingles II","12/35/89","Nota 2"));
		lista.add(new ItemLista("Prueba de contenido 3","Ingles III","12/35/89","Nota 3"));
	
		
		return lista;
	}

}
