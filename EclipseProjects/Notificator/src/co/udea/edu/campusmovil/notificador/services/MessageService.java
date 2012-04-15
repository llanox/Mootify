package co.udea.edu.campusmovil.notificador.services;

import java.util.List;

import co.udea.edu.campusmovil.notificador.exceptions.MootifyException;
import co.udea.edu.campusmovil.notificador.model.ItemLista;

public interface MessageService {

	List<ItemLista> findAllMessage(String idEstudiante, String password, int firstRecord, int lastRecord) throws MootifyException;

}
