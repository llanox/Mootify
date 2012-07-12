package co.edu.udea.campusmovil.notificador.ui;

import java.util.List;

import co.edu.udea.campusmovil.notificador.model.ListItem;
import android.content.SharedPreferences;

public class PreferencesHandler 
{
	private Integer number_messages;
	private String user_name;
	private String password;
	private SharedPreferences preferences;
	private List<ListItem> elements;
	private List<ListItem> elements_with_preferences;
	
	public PreferencesHandler(SharedPreferences preferences, List<ListItem> elements)
	{
		this.preferences = preferences;
		this.elements = elements;  		
		this.elements_with_preferences = elements.subList(0, Integer.parseInt(preferences.getString("number_messages", "10")));		
	}
	
	
	public String getUserName()
	{
		return user_name;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public List<ListItem> getList()
	{
		return elements_with_preferences;
	}
}
