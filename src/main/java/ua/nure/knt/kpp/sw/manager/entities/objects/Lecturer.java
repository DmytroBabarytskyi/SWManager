package ua.nure.knt.kpp.sw.manager.entities.objects;

public class Lecturer extends Person {
    private String faculty;

    public Lecturer(Long id, String name, String surname, String phone_number, String email, String faculty) {
        super(id, name, surname, phone_number, email);
        this.faculty = faculty;
    }

    public Lecturer() {
    }

    public String getFaculty() {
        return faculty;
    }
    public void setFaculty(String faculty) { this.faculty = faculty; }

    @Override
    public String toString() {
        return super.toString() + ", faculty: " + faculty;
    }
}
