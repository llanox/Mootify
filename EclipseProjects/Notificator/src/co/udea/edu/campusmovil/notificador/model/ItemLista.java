package co.udea.edu.campusmovil.notificador.model;

import android.app.Activity;
import android.os.Bundle;
/*
 * Esta clase es la encargada de manejar los datos que 
 * tiene el mensaje: t�tulo, materia, fecha y remitente.
 * A trav�s de esta clase y de sus m�todos accesores podemos 
 * obtener cada uno de los datos del mensaje.
 * 
 * */



public class ItemLista 
{
	private String titulo;
	private String materia;
	private String fecha;
	private String remitente;
	
	public ItemLista(String h,String i, String j,String k)//constructor
	{
	   titulo = h;
	   materia = i;
	   fecha = j;
	   remitente = k;
	}
	

	public String getTitulo()
	{
		return titulo;
	}	
	
	public String getFecha()
	{
		return fecha;
	}
	
	public String getMateria()
	{
		return materia;
	}
	
	public String getRemitente()
	{
		return remitente;
	}
}