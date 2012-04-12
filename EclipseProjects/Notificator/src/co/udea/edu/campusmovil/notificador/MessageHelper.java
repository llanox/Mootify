package co.udea.edu.campusmovil.notificador;

import java.util.List;

public class MessageHelper {
   
	 
	public static List<ItemLista> findAllMsgs(String idEstudiante) {
		MessageService messageService = (MessageService) ServiceLocator.getInstance(ServiceNames.MESSAGE_SERVICE_MOCK);
		return messageService.findAllMessage(idEstudiante,20);
	}

}
