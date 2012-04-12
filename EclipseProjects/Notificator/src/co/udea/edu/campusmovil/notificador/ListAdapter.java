package co.udea.edu.campusmovil.notificador;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.ImageButton;

public class ListAdapter extends ArrayAdapter<ItemLista>
{
	static class ViewHolder 
	{
		protected TextView titulo;
		protected TextView materia;
		protected ImageButton Opciones;

	}
	
	private int ItemLayotId;
	public ListAdapter(Context context,int itemLayoutId,int textViewId,List<ItemLista> inform)
	{
		super(context, itemLayoutId,textViewId, inform);
	}
	
	public View getView(int position,View convertView, ViewGroup parent)
	{
		View view = convertView;
		if(view ==null)
		{
			LayoutInflater me = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view = me.inflate(ItemLayotId, null);
			
			final ViewHolder viewHolder = new ViewHolder();
			viewHolder.titulo = (TextView) view.findViewById(R.id.titulo_mensaje);
			viewHolder.materia = (TextView) view.findViewById(R.id.materia);
			viewHolder.Opciones = (ImageButton) view.findViewById(R.id.ident);
			
			view.setTag(viewHolder);
		}
		ViewHolder viewHolder = (ViewHolder) view.getTag();
        TextView ti = viewHolder.titulo;
        TextView ma = viewHolder.materia;
        ImageButton op = viewHolder.Opciones;
        
        return view;
		
	}
	

}
