package co.edu.udea.campusmovil.notificador.model;

public class Forum {

    public static String[] COLS = new String[] {"id", "idcourse", "type", "name"};
    public static String DATABASE_TABLE = "forums";

    public static String TABLE_CREATE = "create table " + Forum.DATABASE_TABLE + " ("
        + Forum.COLS[0] + " integer primary key autoincrement, "
        + Forum.COLS[1] + " text not null,"
        + Forum.COLS[2] + " text not null, "
        + Forum.COLS[3] + " text not null);";

    private String id;
    private String name;
    private String idCourse;
    private String type;

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCourse() {

        return idCourse;
    }

    public void setIdCourse(String idCourse) {
        this.idCourse = idCourse;
    }
    public String getType() {

        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
