package ua.nure.knt.kpp.sw.manager.form.add;

public class AddPublisherForm {
    private String name;
    private long country;
    private long quartile;

    public AddPublisherForm(String name, long country, long quartile){
        this.name = name;
        this.country = country;
        this.quartile = quartile;
    }
    public AddPublisherForm(){

    }

    public String getName(){ return name; }
    public void setName(String name){ this.name = name; }
    public long getCountry(){ return country; }
    public void setCountry(long country){ this.country = country; }
    public long getQuartile(){ return quartile; }
    public void setQuartile(long quartile){ this.quartile = quartile; }
}
