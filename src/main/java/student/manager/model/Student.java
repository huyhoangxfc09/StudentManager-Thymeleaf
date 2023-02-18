package student.manager.model;

public class Student {
    private int id;
    private String name;
    private int age;
    private String address;
    private Classroom classroom;

    public Student(String name, int age, String address, Classroom classroom) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.classroom = classroom;
    }

    public Student(int id, String name, int age, String address, Classroom classroom) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.classroom = classroom;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }
}
