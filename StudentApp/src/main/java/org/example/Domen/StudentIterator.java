package org.example.Domen;

import java.util.Iterator;
import java.util.List;

public class StudentIterator implements Iterator<Student> {
    private int counter;
    private final List<Student> students;
    public StudentIterator(List<Student> students) {
        this.students = students;
        this.counter = 0;
    }

    @Override
    public boolean hasNext() {
        return counter < students.size();
    }
    @Override
    public Student next() {
        if(!hasNext())
        {
            return null;
        }
        return students.get(counter++);
    }

}
