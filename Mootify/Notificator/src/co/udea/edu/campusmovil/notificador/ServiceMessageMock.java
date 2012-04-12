package co.udea.edu.campusmovil.notificador;

import java.util.ArrayList;
import java.util.List;


public class ServiceMessageMock implements MessageService {

	@Override
	public List<ItemLista> findAllMessage(String idEstudiante, int firstNResults) {
		List<ItemLista>  lista =  new ArrayList<ItemLista>();
		
		ItemLista uno = new ItemLista("PRUEBA 1","12/35/89","Ingles I","Ingles para Ingenieros");
		ItemLista dos = new ItemLista("prueba2","13","Ingles II","estado 2");
		ItemLista tres = new ItemLista("prueba3","14","Ingles III","estado 3");
		ItemLista cuatro = new ItemLista("prueba4","15","Ingles IV","estado 4");
		
		lista.add(uno);
		lista.add(dos);
		lista.add(tres);
		lista.add(cuatro);
		
		return lista;
	}

}
