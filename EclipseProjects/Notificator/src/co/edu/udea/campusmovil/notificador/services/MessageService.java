package co.edu.udea.campusmovil.notificador.services;

import java.util.List;

import co.edu.udea.campusmovil.notificador.exceptions.MootifyException;
import co.edu.udea.campusmovil.notificador.model.ListItem;

public interface MessageService {

	List<ListItem> findAllMessage(String idEstudiante, String password, int firstRecord, int lastRecord) throws MootifyException;

}
