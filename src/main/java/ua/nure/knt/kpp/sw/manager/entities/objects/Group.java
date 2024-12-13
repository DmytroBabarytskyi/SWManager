package ua.nure.knt.kpp.sw.manager.entities.objects;

public class Group {
    private Long id;
    private String number;
    private String educationalProgram;
    private String faculty;
    private String specialty;
    private String level;
    public Group(Long id, String number, String educationalProgram, String faculty, String specialty, String level) {
        this.id = id;
        this.number = number;
        this.educationalProgram = educationalProgram;
        this.faculty = faculty;
        this.specialty = specialty;
        this.level = level;
    }
    public Group(){

    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNumber() { return number; }
    public void setNumber(String number) { this.number = number; }
    public String getEducationalProgram() { return educationalProgram; }
    public void setEducationalProgram(String educationalProgram) { this.educationalProgram = educationalProgram; }
    public String getFaculty() { return faculty; }
    public void setFaculty(String faculty) { this.faculty = faculty; }
    public String getSpecialty() { return specialty; }
    public void setSpecialty(String specialty) { this.specialty = specialty; }
    public String getLevel() { return level; }
    public void setLevel(String level) { this.level = level; }
}
