package ua.nure.knt.kpp.sw.manager.entities.objects;

import java.sql.Date;

public class Publication extends ScientificWork {
    private String publication_number;
    private String publisher;
    private Date publicationDate;

    public Publication(Long id, String topic, String author, String publication_number, String publisher, Date publicationDate) {
        super(id, topic, "Publication", author);
        this.publication_number = publication_number;
        this.publisher = publisher;
        this.publicationDate = publicationDate;
    }
    public Publication(){

    }

    public String getPublicationNumber() { return publication_number; }
    public void setPublicationNumber(String publication_number) { this.publication_number = publication_number; }
    public String getPublisher() { return publisher; }
    public void setPublisher(String publisher) { this.publisher = publisher; }
    public Date getPublicationDate() { return publicationDate; }
    public void setPublicationDate(Date publicationDate) { this.publicationDate = publicationDate; }

    @Override
    public String toString(){
        return super.toString() + ", journal number: " + publication_number + ", publisher: " + publisher + ", publication date: " + publicationDate;
    }
}