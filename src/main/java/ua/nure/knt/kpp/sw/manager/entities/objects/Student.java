package ua.nure.knt.kpp.sw.manager.entities.objects;

import java.util.Objects;

public class Student extends Person {
	private String group;
	private int numberOfWorks;

	public Student(Long id, String name, String surname, String group, String phoneNumber, String email, int numberOfWorks){
        super(id, name, surname, phoneNumber, email);
        this.group = group;
        this.numberOfWorks = numberOfWorks;
	}

	public Student(String name, String surname, String group, String phoneNumber, String email, int numberOfWorks) {

	}

	public String getGroup() { return group; }
	public void setGroup(String group) { this.group = group; }
	public int getNumberOfWorks() { return numberOfWorks; }
	public void setNumberOfWorks(int numberOfWorks) { this.numberOfWorks = numberOfWorks; }

	public Student() {
	
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numberOfWorks;
		result = prime * result + ((super.getEmail() == null)? 0 : super.getEmail().hashCode());
		result = prime * result + ((super.getPhoneNumber() == null) ? 0 : super.getPhoneNumber().hashCode());
		result = prime * result + ((super.getName() == null) ? 0 : super.getName().hashCode());
		result = prime * result + ((super.getSurname() == null) ? 0 : super.getSurname().hashCode());
		result = prime * result + ((group == null) ? 0 : group.hashCode());

		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (!Objects.equals(getName(), other.getName() ))
			return false;
		if(!Objects.equals(group, other.group))
			return false;
		if (!Objects.equals(getSurname(), other.getSurname()))
			return false;
		if (!Objects.equals(getPhoneNumber(), other.getPhoneNumber()))
			return false;
        if (!Objects.equals(getEmail(), other.getEmail()))
			return false;
		else return numberOfWorks == other.numberOfWorks;
    }

	@Override
	public String toString() {
        return super.toString() + ", group: " + group + ", number of works: " + numberOfWorks;
    }
}
