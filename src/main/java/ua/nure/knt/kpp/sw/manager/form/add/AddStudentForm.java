package ua.nure.knt.kpp.sw.manager.form.add;

public class AddStudentForm {

	private String name;
	private String surname;
	private Long group;
	private String phoneNumber;
	private String email;
	private int numberOfWorks;

	public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }
    public Long getGroup() { return group; }
    public void setGroup(Long group) { this.group = group; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public int getNumberOfWorks() { return numberOfWorks; }
    public void setNumberOfWorks(int numberOfWorks) { this.numberOfWorks = numberOfWorks; }

    public AddStudentForm(String name, String surname, Long group, String phoneNumber, String email, int numberOfWorks) {
	    this.name = name;
		this.surname = surname;
		this.group = group;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.numberOfWorks = numberOfWorks;
	}

	public AddStudentForm() {

	}
}
