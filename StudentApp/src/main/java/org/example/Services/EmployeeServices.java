package org.example.Services;

import org.example.Domen.Employee;
import org.example.Domen.PersonComparator;

import java.util.ArrayList;
import java.util.List;

public class EmployeeServices implements iPersonService<Employee>{
    private int count;
    private List<Employee> employees;

    public EmployeeServices() {
        this.employees = new ArrayList<>();
    }

    @Override
    public List<Employee> getAll() {
        return employees;
    }

    @Override
    public void create(String name, int age) {
        Employee epls = new Employee(name, age, "basic");
        count++;
        employees.add(epls);
    }

    public void sortByFIO()
    {
        PersonComparator<Employee> persComp = new PersonComparator<Employee>();
        employees.sort(persComp);
    }

}
