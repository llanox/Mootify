package co.edu.udea.campusmovil.notificador.ui;

import java.util.ArrayList;

import co.edu.udea.campusmovil.notificador.R;
import co.edu.udea.campusmovil.notificador.model.Message;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MessageListActivityAdapter extends BaseAdapter
{
	private ArrayList<Message> messageList;
	private LayoutInflater layoutInflater;
	
	public MessageListActivityAdapter(Context context, ArrayList<Message> Messages)
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
			
			valuesOfMessage.date= (TextView) convertView.findViewById(R.id.fecha);//recibe el la fecha que hay en la lista
			valuesOfMessage.title = (TextView) convertView.findViewById(R.id.asunto);//recibe el titulo del mensaje que hay en la lista
			valuesOfMessage.sender = (TextView) convertView.findViewById(R.id.remitente);//recibe el remitente del mensaje que hay en la lista
			valuesOfMessage.subject = (TextView) convertView.findViewById(R.id.curso);//recibe el titulo del mensaje que hay en la lista
			valuesOfMessage.content = (TextView) convertView.findViewById(R.id.cuerpo_mensaje);//recibe el titulo del mensaje que hay en la lista
						
			convertView.setTag(valuesOfMessage); //Marcamos el objeto con los nuevos datos obtenidos del elemento de la lista
		}
		else
		
			valuesOfMessage = (MessageView) convertView.getTag();
		
			Message messageHelper = (Message) getItem(position);
			
			valuesOfMessage.date.setText(messageHelper.getDate());
			valuesOfMessage.title.setText(messageHelper.getName());
			//valuesOfMessage.sender.setText(messageHelper.getSender());  Duda, cual clase utilizar y que agregar?
			//valuesOfMessage.subject.setText(messageHelper.getSubject()); Duda, cual clase utilizar y que agregar?
			valuesOfMessage.content.setText(messageHelper.getContent());
			
			return convertView;		
	}
	
	class MessageView
	{
		TextView date;
		TextView title;
		TextView sender;
		TextView subject;
		TextView content;
		
	}
	

}
