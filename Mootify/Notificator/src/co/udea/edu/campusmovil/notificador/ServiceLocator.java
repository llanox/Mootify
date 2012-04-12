package co.udea.edu.campusmovil.notificador;

public class ServiceLocator {

	public static Object getInstance(String messageService) {
		
		if(ServiceNames.MESSAGE_SERVICE_MOCK.equalsIgnoreCase(messageService))
			return new ServiceMessageMock();
		
		if(ServiceNames.MESSAGE_SERVICE.equalsIgnoreCase(messageService))
			return new ServiceMessageImpl();
		
		
		return null;
	}

}
