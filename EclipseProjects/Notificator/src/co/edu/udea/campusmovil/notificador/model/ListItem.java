package co.edu.udea.campusmovil.notificador.model;

/*
 * Esta clase es la encargada de manejar los datos que 
 * tiene el mensaje: título, materia, fecha y remitente.
 * A través de esta clase y de sus métodos accesores podemos 
 * obtener cada uno de los datos del mensaje.
 */

public class ListItem {

    private String date;
    private String sender;
    private String subject;
    private String title;

    // Consructor.
    public ListItem(String title, String subject, String sender, String date) {
       this.setDate(date);
       this.setSender(sender);
       this.setSubject(subject);
       this.setTitle(title);
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
}
