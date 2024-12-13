package ua.nure.knt.kpp.sw.manager.form.add;

import java.sql.Date;

public class AddPublicationForm {
    private String topic;
    private long author;
    private long advisor;
    private String publication_number;
    private long publisher;
    private Date publicationDate;


    public AddPublicationForm(String topic, long author, long advisor, String publication_number, long publisher, Date publicationDate) {
        this.topic = topic;
        this.author = author;
        this.advisor = advisor;
        this.publication_number = publication_number;
        this.publisher = publisher;
        this.publicationDate = publicationDate;
    }

    public AddPublicationForm() {
    }

    public String getTopic() { return topic; }
    public void setTopic(String topic) { this.topic = topic; }
    public long getAuthor() { return author; }
    public void setAuthor(long author) { this.author = author; }
    public long getAdvisor() { return advisor; }
    public void setAdvisor(long advisor) { this.advisor = advisor; }
    public String getPublicationNumber() { return publication_number; }
    public void setPublicationNumber(String publication_number) { this.publication_number = publication_number; }
    public long getPublisher() { return publisher; }
    public void setPublisher(long publisher) { this.publisher = publisher; }
    public Date getPublicationDate() { return publicationDate; }
    public void setPublicationDate(Date publicationDate) { this.publicationDate = publicationDate; }
}
