package ua.nure.knt.kpp.sw.manager.form.add;

import java.sql.Date;

public class AddConferenceForm {
    private String name;
    private Date startDate;
    private Date endDate;
    private long type;
    private long state;

    public AddConferenceForm(String name, Date startDate, Date endDate, long type, long state) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.type = type;
        this.state = state;
    }

    public AddConferenceForm() {
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Date getStartDate() { return startDate; }
    public void setStartDate(Date startDate) { this.startDate = startDate; }
    public Date getEndDate() { return endDate; }
    public void setEndDate(Date endDate) { this.endDate = endDate; }
    public long getType() { return type; }
    public void setType(long type) { this.type = type; }
    public long getState() { return state; }
    public void setState(long state) { this.state = state; }
}
