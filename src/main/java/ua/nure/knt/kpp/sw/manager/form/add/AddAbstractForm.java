package ua.nure.knt.kpp.sw.manager.form.add;


public class AddAbstractForm {
    private String topic;
    private long author;
    private long advisor;
    private long conference;


    public AddAbstractForm(String topic, long author, long advisor, long conference) {
        this.topic = topic;
        this.author = author;
        this.advisor = advisor;
        this.conference = conference;
    }

    public AddAbstractForm() {
    }

    public String getTopic() { return topic; }
    public void setTopic(String topic) { this.topic = topic; }
    public long getAuthor() { return author; }
    public void setAuthor(long author) { this.author = author; }
    public long getAdvisor() { return advisor; }
    public void setAdvisor(long advisor) { this.advisor = advisor; }
    public long getConference() { return conference; }
    public void setConference(long conference) { this.conference = conference; }
}
