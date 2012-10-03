package co.edu.udea.campusmovil.notificador.ui;

import java.util.ArrayList;

import co.edu.udea.campusmovil.notificador.R;
import co.edu.udea.campusmovil.notificador.model.ListItem;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/*
 * Esta clase es utilizada para poder dibujar en el listview los elementos
 * que representan los mensages que se traen desde el servicio
 * utiliza el objeto de tipo ListItem (esto por el momento mientras se termina el consumo del servicio)
 */
public class MessageListActivityAdapter extends BaseAdapter
{
	private ArrayList<ListItem> messageList;
	private LayoutInflater layoutInflater;
	
	public MessageListActivityAdapter(Context context, ArrayList<ListItem> Messages)
	{
		this.layoutInflater = LayoutInflater.from(context);
		this.messageList = Messages;
	}

	public int getCount() {
		return messageList.size();
	}

	public Object getItem(int position) {
		return messageList.get(position);
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		
        MessageView valuesOfMessage = null;
		
		if(convertView == null)
		{
			convertView = layoutInflater.inflate(R.layout.item_list, null);
			
			valuesOfMessage = new MessageView();
			
			valuesOfMessage.title= (TextView) convertView.findViewById(R.id.message_title);	//asocia un texview con el textview que contiene el titulo 		
			valuesOfMessage.subject = (TextView) convertView.findViewById(R.id.subject); //asocia un texview con el textview que contiene el curso
			
						
			convertView.setTag(valuesOfMessage); //Marcamos el objeto con los nuevos datos obtenidos del elemento de la lista
		}
		else
		
			valuesOfMessage = (MessageView) convertView.getTag();
		
			ListItem messageHelper = (ListItem) getItem(position);//objeto de tipo ItemList para asignar datos y mostrarlos
			
			valuesOfMessage.title.setText(messageHelper.getTitle());
			valuesOfMessage.subject.setText(messageHelper.getSubject());  
			
			
			
			return convertView;		
	}
	
	class MessageView // clase para manejar los datos mas facilmente dentro del adaptador
	{
		TextView date;//para el futuro
		TextView title;
		TextView sender;//para el futuro
		TextView subject;
		TextView content;//para el futuro
		
	}
	

}
