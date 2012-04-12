package co.edu.udea.campusmovil.model;

/*
 * Una pinche clase Student, nada raro, usada para llenar la ListView con elementos
 * encapsulados en objetos.
 */
public class Student {

    private String fullName;
    private long idNumber;
    private byte age;

    public Student() {
        this(null, 0L, (byte) 0);
    }

    public Student(String fullName, long idNumber, byte age) {
        this.setFullName(fullName);
        this.setIdNumber(idNumber);
        this.setAge(age);
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setIdNumber(long idNumber) {
        this.idNumber = idNumber;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public String getFullName() {

        return (this.fullName);
    }

    public long getIdNumber() {

        return (this.idNumber);
    }

    public byte getAge() {

        return (this.age);
    }
}
