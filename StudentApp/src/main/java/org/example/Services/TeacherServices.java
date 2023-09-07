package org.example.Services;

import org.example.Domen.Employee;
import org.example.Domen.Teacher;

import java.util.ArrayList;
import java.util.List;

public class TeacherServices implements iPersonService<Teacher>{
    private int count;
    private List <Teacher> teacherList;

    public TeacherServices() {
        this.teacherList = new ArrayList<>();
    }

    @Override
    public List<Teacher> getAll() {
        return teacherList;
    }

    @Override
    public void create(String name, int age) {
        Teacher teacher = new Teacher(name, age, "basic");
        count++;
        teacherList.add(teacher);
    }

}
