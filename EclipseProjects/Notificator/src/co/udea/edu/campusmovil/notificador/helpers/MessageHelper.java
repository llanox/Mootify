package co.udea.edu.campusmovil.notificador.helpers;

import java.util.List;

import co.udea.edu.campusmovil.notificador.exceptions.MootifyException;
import co.udea.edu.campusmovil.notificador.model.ItemLista;
import co.udea.edu.campusmovil.notificador.services.MessageService;
import co.udea.edu.campusmovil.notificador.services.ServiceLocator;
import co.udea.edu.campusmovil.notificador.services.ServiceNames;

public class MessageHelper {
   
	 
	public static List<ItemLista> findAllMsgs(String idEstudiante, String pass) throws MootifyException {
		List<ItemLista> itemLista ;
		
		MessageService messageService = (MessageService) ServiceLocator.getInstance(ServiceNames.MESSAGE_SERVICE_MOCK);
		
		try{
		itemLista =messageService.findAllMessage(idEstudiante,pass,0,20);
		PersistenceHelper.saveOrUpadate(itemLista);	
		
		}catch(MootifyException ex){
			itemLista = PersistenceHelper.findNElements(ItemLista.class);
		}
	    
		
		return itemLista;
	}
	


}
