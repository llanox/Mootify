package co.udea.edu.campusmovil.notificador;
import java.util.ArrayList;
import java.util.List;
import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class ListActivityResult extends ListActivity 
{
	private List<ItemLista> listData = new ArrayList<ItemLista>();
	public void onCreate (Bundle inicio)
	{
		super.onCreate(inicio);		
		updateList();
		setListAdapter(new ListAdapter(this,R.layout.item_lista,0,listData));
	}

	
	public void updateList() 
	{		
		List<ItemLista> result = MessageHelper.findAllMsgs("893980288");		
	}


	

}
