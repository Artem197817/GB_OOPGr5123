package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.example.Controller.AccountController;
import org.example.Domen.Student;
import org.example.Domen.StudentGroup;
import org.example.Domen.StudentStream;
import org.example.Domen.Teacher;
import org.example.Services.PersonPrintSortedToNameServices;
import org.example.Services.StudentService;
import org.example.Services.TeacherServices;

public class App {
    public static void main(String[] args) throws Exception {
        Student s1 = new Student("Артём", 25);
        Student s2 = new Student("Илья", 21);
        Student s3 = new Student("Сергей", 22);
        Student s4 = new Student("Онна",  26);
        Student s5 = new Student("Настя",  24);
        Student s6 = new Student("Катя",  23);
        Student s7 = new Student("Cartoon Head", 27);

        StudentService studentService = new StudentService();
        studentService.create("Артем", 25);
        studentService.create("Онна", 26);
        studentService.create("Сергей", 22);
        studentService.create("Катя", 23);

        TeacherServices teacherServices = new TeacherServices();
        teacherServices.create("Филипп",45);
        teacherServices.create("Мария",36);
        teacherServices.create("Екатерина",57);
        teacherServices.create("Варвара",42);

        PersonPrintSortedToNameServices printSortedToNameServices = new PersonPrintSortedToNameServices();

        List<Student> listStud5123 = new ArrayList<Student>();
        listStud5123.add(s2);
        listStud5123.add(s3);
        List<Student> listStud5125 = new ArrayList<Student>();
        listStud5125.add(s4);
        listStud5125.add(s5);
        listStud5125.add(s6);
        listStud5125.add(s7);
        List<Student> listStud5127 = new ArrayList<Student>();
        listStud5127.add(s1);

        System.out.println();
        System.out.println("*           * Список групп *           *");
        System.out.println();

        StudentGroup group5123 = new StudentGroup(listStud5123, 5123);
        System.out.println(group5123);

        StudentGroup group5125 = new StudentGroup(listStud5125, 5125);
        System.out.println(group5125);

        StudentGroup group5127 = new StudentGroup(listStud5127, 5127);
        System.out.println(group5127);

        System.out.println();
        System.out.println("~~~~~~~~~~~~~~~ Список потока ~~~~~~~~~~~~~~~~~~~");
        System.out.println();

        List<StudentGroup> listGroup1 = new ArrayList<>();
        listGroup1.add(group5123);
        listGroup1.add(group5125);
        listGroup1.add(group5127);

        StudentStream stream1 = new StudentStream(listGroup1, 1);
        System.out.println(stream1);

        System.out.println();
        System.out.println("-------------- Список потока по группам ------------------");
        System.out.println();

        for (StudentGroup students : stream1.getStream()) {
            System.out.println(students);
        }


        System.out.println();
        System.out.println("=============== Список студентов по группам ==================");
        System.out.println();


        printStudents(group5123);
        printStudents(group5125);
        printStudents(group5127);

        System.out.println();
        System.out.println("*************** Сортировка в группе по возрасту *****************");
        System.out.println();

       group5125.getGroup().stream()
                .sorted()
                .forEach(System.out::println);

        System.out.println();
        System.out.println("*      * Сортировка в потоке по количеству студентов в группе *     *");
        System.out.println();

        stream1.getStream().stream()
                .sorted()
                .forEach(System.out::println);


        System.out.println();
        System.out.println("*      * Сортировка в потоке по идентификатору группы *      *");
        System.out.println();

        listGroup1.stream()
                .sorted(Comparator.comparingInt(StudentGroup::getIdGroup))
                .forEach(System.out::println);

        System.out.println();
        System.out.println("Средний возраст учителей = " + AccountController.averageAge(teacherServices.getAll()));
        System.out.println();

        System.out.println();
        System.out.println(" +++++++++++++ Список учителей по алфавиту+++++++++++");
        System.out.println();
        printSortedToNameServices.print(teacherServices.getAll());

        System.out.println();
        System.out.println(" +++++++++++++ Список студентов по алфавиту+++++++++++");
        System.out.println();
        printSortedToNameServices.print(studentService.getAll());
    }




    /**
     * @apiNote Метод выводит на печать номер группы и студентов группы, каждого с новой строки
     * @param group список студентов
     * @see org.example.Domen.StudentGroup
     */
    private static void printStudents(StudentGroup group) {
        System.out.println("Группа № " + group.getIdGroup());
        for(Student std : group)
        {
            System.out.println(std);
        }
    }
}