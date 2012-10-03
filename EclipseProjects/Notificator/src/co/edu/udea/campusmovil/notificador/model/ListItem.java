package co.edu.udea.campusmovil.notificador.model;

/*
 * Esta clase es la encargada de manejar los datos que
 * tiene el mensaje: título, materia, fecha y remitente.
 * A traves de esta clase y de sus métodos accesores podemos
 * obtener cada uno de los datos del mensaje.
 */

public class ListItem {

    private String date;
    private String title;
    private String sender;
    private String subject;    
    private String content;

    // Consructor.
    public ListItem(String date,String title,String sender,String subject, String content) {
       this.setDate(date);
       this.setSender(sender);
       this.setSubject(subject);
       this.setTitle(title);
       this.setContent(content);
    }

    public String getDate() {

        return date;
    }

    public String getSender() {

        return sender;
    }

    public String getSubject() {

        return subject;
    }

    public String getTitle() {

        return title;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setTitle(String title) {
        this.title = title;
    }

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
