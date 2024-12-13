package ua.nure.knt.kpp.sw.manager.entities.objects;

public abstract class ScientificWork implements Comparable<ScientificWork>{
    private Long id;
    private String topic;
    private String type;
    private String author;

    public ScientificWork(Long id, String topic, String type, String author) {
        this.id = id;
        this.topic = topic;
        this.type = type;
        this.author = author;
    }

    protected ScientificWork() {
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTopic() { return topic; }
    public void setTopic(String topic) { this.topic = topic; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String toString() {
        return "ID: " + id + ", topic: " + topic + ", type: " + type + ", author: " + author;
    }
    public int compareTo(ScientificWork other) {
        return (int) (this.getId() - other.getId());
    }
}
