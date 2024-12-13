package ua.nure.knt.kpp.sw.manager.form.add;

public class AddResearchForm {
    private String name;
    private String surname;
    private Long faculty;
    private String phoneNumber;
    private String email;
    private int numberOfWorks;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }
    public Long getFaculty() { return faculty; }
    public void setFaculty(Long faculty) { this.faculty = faculty; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public int getNumberOfWorks() { return numberOfWorks; }
    public void setNumberOfWorks(int numberOfWorks) { this.numberOfWorks = numberOfWorks; }

    public AddResearchForm(String name, String surname, Long faculty, String phoneNumber, String email, int numberOfWorks) {
        this.name = name;
        this.surname = surname;
        this.faculty = faculty;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.numberOfWorks = numberOfWorks;
    }

    public AddResearchForm() {

    }
}
