package co.edu.udea.campusmovil.notificador.helpers;

import java.util.List;

import co.edu.udea.campusmovil.notificador.exceptions.MootifyException;
import co.edu.udea.campusmovil.notificador.model.ListItem;
import co.edu.udea.campusmovil.notificador.services.MessageService;
import co.edu.udea.campusmovil.notificador.services.ServiceLocator;
import co.edu.udea.campusmovil.notificador.services.ServiceNames;

public class MessageHelper {


    public static List<ListItem> findAllMsgs(String idEstudiante, String pass) throws MootifyException {
        List<ListItem> itemLista;

        MessageService messageService = (MessageService) ServiceLocator.getInstance(ServiceNames.MESSAGE_SERVICE_MOCK);

        try {
            itemLista = messageService.findAllMessage(idEstudiante, pass, 0, 20);
            PersistenceHelper.saveOrUpadate(itemLista);
        } catch (MootifyException ex) {
            itemLista = PersistenceHelper.findNElements(ListItem.class);
        }

        return itemLista;
    }
}
