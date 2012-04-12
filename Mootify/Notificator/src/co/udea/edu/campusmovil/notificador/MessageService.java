package co.udea.edu.campusmovil.notificador;

import java.util.List;

public interface MessageService {

	List<ItemLista> findAllMessage(String idEstudiante, int firstNResults);

}
