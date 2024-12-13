package ua.nure.knt.kpp.sw.manager.entities.primary;

public class PrimaryParameter {
    private Long id;
    private String name;

    public PrimaryParameter(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    public PrimaryParameter(){
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }

    public String toString() {
        return "ID: " + id + ", Name: " + name;
    }
}
