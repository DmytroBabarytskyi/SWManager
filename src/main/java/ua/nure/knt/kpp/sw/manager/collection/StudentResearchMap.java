package ua.nure.knt.kpp.sw.manager.collection;

import ua.nure.knt.kpp.sw.manager.entities.objects.Student;
import ua.nure.knt.kpp.sw.manager.entities.objects.ScientificWork;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StudentResearchMap {
    private Map<Student, ScientificWork> map;

    public StudentResearchMap() {
        this.map = new HashMap<>();
    }

    // Додати пару студент-наукова робота
    public void add(Student student, ScientificWork researchWork) {
        map.put(student, researchWork);
    }

    // Отримати наукову роботу за студентом
    public ScientificWork get(Student student) {
        return map.get(student);
    }

    // Видалити пару
    public void remove(Student student) {
        map.remove(student);
    }

    // Отримати всіх студентів
    public Set<Student> getAllStudents() {
        return map.keySet();
    }

    // Отримати всі записи у вигляді пар
    public Set<Map.Entry<Student, ScientificWork>> entrySet() {
        return map.entrySet();
    }

    @Override
    public String toString() {
        return map.toString();
    }
}