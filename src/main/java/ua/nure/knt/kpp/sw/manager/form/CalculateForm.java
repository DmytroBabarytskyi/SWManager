package ua.nure.knt.kpp.sw.manager.form;

public class CalculateForm {
    private long studentID;
    private int numberOfQ1;
    private int numberOfQ2;
    private int numberOfQ3;
    private int numberOfQ4;
    private int numberOfAbstracts;
    private int Q1;
    private int Q2;
    private int Q3;
    private int Q4;
    private int anAbstract;
    private int maxExtraPoints;

    public CalculateForm(long studentID, int numberOfQ1, int numberOfQ2, int numberOfQ3, int numberOfQ4, int numberOfAbstracts,
                         int Q1, int Q2, int Q3, int Q4, int anAbstract, int maxExtraPoints) {
        this.studentID = studentID;
        this.numberOfQ1 = numberOfQ1;
        this.numberOfQ2 = numberOfQ2;
        this.numberOfQ3 = numberOfQ3;
        this.numberOfQ4 = numberOfQ4;
        this.numberOfAbstracts = numberOfAbstracts;
        this.Q1 = Q1;
        this.Q2 = Q2;
        this.Q3 = Q3;
        this.Q4 = Q4;
        this.anAbstract = anAbstract;
        this.maxExtraPoints = maxExtraPoints;
    }

    public CalculateForm(){

    }

    public long getStudentID() { return studentID; }
    public void setStudentID(long studentID) { this.studentID = studentID; }
    public int getNumberOfQ1() { return numberOfQ1; }
    public void setNumberOfQ1(int numberOfQ1) { this.numberOfQ1 = numberOfQ1; }
    public int getNumberOfQ2() { return numberOfQ2; }
    public void setNumberOfQ2(int numberOfQ2) { this.numberOfQ2 = numberOfQ2; }
    public int getNumberOfQ3() { return numberOfQ3; }
    public void setNumberOfQ3(int numberOfQ3) { this.numberOfQ3 = numberOfQ3; }
    public int getNumberOfQ4() { return numberOfQ4; }
    public void setNumberOfQ4(int numberOfQ4) { this.numberOfQ4 = numberOfQ4; }
    public int getNumberOfAbstracts() { return numberOfAbstracts; }
    public void setNumberOfAbstracts(int numberOfAbstracts) { this.numberOfAbstracts = numberOfAbstracts; }
    public int getQ1() { return Q1; }
    public void setQ1(int Q1) { this.Q1 = Q1; }
    public int getQ2() { return Q2; }
    public void setQ2(int Q2) { this.Q2 = Q2; }
    public int getQ3() { return Q3; }
    public void setQ3(int Q3) { this.Q3 = Q3; }
    public int getQ4() { return Q4; }
    public void setQ4(int Q4) { this.Q4 = Q4; }
    public int getAnAbstract() { return anAbstract; }
    public void setAnAbstract(int anAbstract) { this.anAbstract = anAbstract; }
    public int getMaxExtraPoints() { return maxExtraPoints; }
    public void setMaxExtraPoints(int maxExtraPoints) { this.maxExtraPoints = maxExtraPoints; }
}
