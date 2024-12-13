package ua.nure.knt.kpp.sw.manager.comparators;

import ua.nure.knt.kpp.sw.manager.entities.objects.Student;
import java.util.Comparator;

public class NameComparator implements Comparator<Student> {
    @Override
    public int compare(Student student1, Student student2) {
        return (student1.getName().compareTo(student2.getName()));
    }
}
