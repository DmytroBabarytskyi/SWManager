package ua.nure.knt.kpp.sw.manager.comparators;

import ua.nure.knt.kpp.sw.manager.entities.objects.Student;
import java.util.Comparator;

public class IdComparator implements Comparator<Student>{
    @Override
    public int compare(Student stud1, Student stud2) {
        return Long.compare(stud1.getId(), stud2.getId());
    }
}
