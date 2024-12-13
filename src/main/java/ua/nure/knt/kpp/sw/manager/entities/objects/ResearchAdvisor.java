package ua.nure.knt.kpp.sw.manager.entities.objects;

public class ResearchAdvisor extends Lecturer {
    int numberOfWorks;
    public ResearchAdvisor(Long id, String name, String surname, String phone_number, String email, String faculty, int numberOfWorks) {
        super(id, name, surname, phone_number, email, faculty);
        this.numberOfWorks = numberOfWorks;
    }
    public ResearchAdvisor(){

    }

    public int getNumberOfWorks() { return numberOfWorks; }
    public void setNumberOfWorks(int numberOfWorks) { this.numberOfWorks = numberOfWorks; }

    @Override
    public String toString() {
        return super.toString() + ", numberOfWorks: " + numberOfWorks;
    }
}
