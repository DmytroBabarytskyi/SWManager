package ua.nure.knt.kpp.sw.manager.form.add;

public class AddGroupForm {
    private String number;
    private long program;
    private long faculty;

    public AddGroupForm(String number, long program, long faculty) {
        this.number = number;
        this.program = program;
        this.program = faculty;
    }
    public AddGroupForm(){

    }

    public String getNumber() { return number; }
    public void setNumber(String number) { this.number = number; }
    public long getProgram() { return program; }
    public void setProgram(long program) { this.program = program; }
    public long getFaculty() { return faculty; }
    public void setFaculty(long faculty) { this.faculty = faculty; }
}
