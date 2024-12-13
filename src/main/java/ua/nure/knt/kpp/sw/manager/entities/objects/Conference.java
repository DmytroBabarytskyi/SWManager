package ua.nure.knt.kpp.sw.manager.entities.objects;

import java.sql.Date;

public class Conference {
    private Long id;
    private String name;
    private String type;
    private String state;
    private Date startDate;
    private Date endDate;

    public Conference(Long id, String name, String type, String state, Date startDate, Date endDate) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.state = state;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    public Conference(String name, String type, String state, Date startDate, Date endDate) {
        this.name = name;
        this.type = type;
        this.state = state;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    public Conference(){

    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public String getState() { return state; }
    public void setState(String state) { this.state = state; }
    public Date getStartDate() { return startDate; }
    public void setStartDate(Date startDate) { this.startDate = startDate; }
    public Date getEndDate() { return endDate; }
    public void setEndDate(Date endDate) { this.endDate = endDate; }
}