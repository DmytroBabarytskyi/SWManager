package ua.nure.knt.kpp.sw.manager.entities.objects;

abstract public class Person implements Comparable<Person> {
    private Long id;
    private String name;
    private String surname;
    private String phone_number;
    private String email;

    public Person(Long id, String name, String surname, String phone_number, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phone_number = phone_number;
        this.email = email;
    }

    protected Person() {
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }
    public String getPhoneNumber() { return phone_number; }
    public void setPhoneNumber(String phone_number) { this.phone_number = phone_number; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return "ID: " + id + ", name: " + name + ", surname: " + surname + ", phone_number: " + phone_number + ", email: " + email;
    }
    public int compareTo(Person other) {
        return surname.compareTo(other.surname);
    }
}
