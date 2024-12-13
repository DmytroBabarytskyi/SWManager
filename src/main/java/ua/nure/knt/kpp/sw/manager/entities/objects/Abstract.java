package ua.nure.knt.kpp.sw.manager.entities.objects;

public class Abstract extends ScientificWork {
    private String conferenceName;

    public Abstract(Long id, String topic, String author, String conferenceName) {
        super(id, topic, "Abstract", author);
        this.conferenceName = conferenceName;
    }
    public Abstract(){

    }

    public String getConferenceName() { return conferenceName; }
    public void setConferenceName(String conferenceName) { this.conferenceName = conferenceName; }

    @Override
    public String toString() {
        return super.toString() + ", conference name: " + conferenceName;
    }
}
