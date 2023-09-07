package org.example.Domen;


public class Student extends Person implements Comparable<Student> {

    private final int id;
    private static int generalId = 1;

    public Student(String name, int age) {
        super(name, age);
        this.id = generalId;
        generalId++;
    }

    public int getId() {
        return id;
    }


    @Override
    public String toString() {
        return "Студент [Имя: " + super.getName() + ", возраст: " + super.getAge() + ", id: " + id + "]" ;
    }

    @Override
    public int compareTo(Student o) {

        // System.out.println(super.getName() + " - " + o.getName());
        if (super.getAge() == o.getAge())
        {
            if (id == o.id) return 0;
            if (id > o.id) return 1;
            else return -1;
        }

        if (super.getAge() > o.getAge())
            return 1;
        else
            return -1;
    }

}

