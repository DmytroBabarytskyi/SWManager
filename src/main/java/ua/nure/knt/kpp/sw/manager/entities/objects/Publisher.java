package ua.nure.knt.kpp.sw.manager.entities.objects;

public class Publisher {
    private Long id;
    private String name;
    private String quartile;
    private String country;

    public Publisher(Long id, String name, String quartile, String country) {
        this.id = id;
        this.name = name;
        this.quartile = quartile;
        this.country = country;
    }
    public Publisher(){

    }

    public Long getId(){ return id; }
    public void setId(Long id){ this.id = id; }
    public String getName(){ return name; }
    public void setName(String name){ this.name = name; }
    public String getQuartile(){ return quartile; }
    public void setQuartile(String quartile){ this.quartile = quartile; }
    public String getCountry(){ return country; }
    public void setCountry(String country){ this.country = country; }
}
