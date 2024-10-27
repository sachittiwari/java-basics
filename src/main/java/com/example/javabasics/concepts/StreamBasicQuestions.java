package com.example.javabasics.concepts;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class StreamBasicQuestions {

    private int size;
    public static void main(String[] args){
        List<Employee> empList = new ArrayList<>();
        empList.add(new Employee(1,Double.valueOf("10000"),"Sachit","M",LocalDate.of(2023,12,01),"Finance",25));
        empList.add(new Employee(2,Double.valueOf("20000"),"Tiwari","F",LocalDate.of(2022,2,20),"HR",26));
        empList.add(new Employee(3,Double.valueOf("50000"),"Sachin","M",LocalDate.of(2024,6,15),"IT",37));
        empList.add(new Employee(4,Double.valueOf("40000"),"Girl","F",LocalDate.of(2024,8,7),"Finance",28));
        empList.add(new Employee(5,Double.valueOf("9000"),"Sweety","F",LocalDate.of(2024,8,7),"Finance",19));
        //to get average salary of an employee
        OptionalDouble as = empList.stream().mapToDouble(Employee::getSalary).average();
        System.out.println("Average Salary: "+as.getAsDouble());

        //to get average salary of Male and Female employee
        OptionalDouble maleAverage = empList.stream().filter(x->x.getGender()=="M").mapToDouble(Employee::getSalary).average();
        OptionalDouble femaleAverage = empList.stream().filter(x->x.getGender()=="F").mapToDouble(Employee::getSalary).average();
        System.out.println("Male Average is "+maleAverage.getAsDouble()+ " female average is "+femaleAverage.getAsDouble());

        //to get list of employees joining the org in a specified year
        List<Employee> emp = empList.stream().filter(x->x.getDateOfJoining().getYear()==2024).collect(Collectors.toList());
        emp.forEach(e->System.out.println("Employee Names that joined in 2024 are: "+e.getName()));

        //to get employee with the highest salary
        Optional<Employee> highest = empList.stream().max(Comparator.comparing(Employee::getSalary));
        System.out.println("Employee with Highest Salary: "+highest.get().getName());

        //to get employee with the second highest salary
        Optional<Employee> secondHighest = empList.stream().filter(x->!x.getName().equals(highest.get().getName())).max(Comparator.comparing(Employee::getSalary));
        System.out.println("Employee with Second Highest Salary is: "+secondHighest.get().getName());

        //count of employees belonging to a specific department
        Long countInDept = empList.stream().filter(x->x.getDepartment().equals("Finance")).count();
        System.out.println("Number of Employees belonging to Finance are "+countInDept.intValue());

        //increment salary of employees in HR dept by 10 percent
        empList.stream().filter(x->x.getDepartment().equals("HR")).forEach(x->x.setSalary(x.getSalary()*1.1));
        empList.forEach(x-> System.out.println("Updated Salary is: "+x.getSalary()));

        //employee with nth Highest Salary
        int n = 1;
        Optional<Employee> nth = empList.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).skip(n-1).findFirst();
        System.out.println("Employee with nth Highest Salary: "+nth.get().getName());

        //count of male and female employees
        Long countMale = empList.stream().filter(x->x.getGender().equals("M")).count();
        Long countfemale = empList.stream().filter(x->x.getGender().equals("F")).count();
        System.out.println("Male Employees count: "+countMale.intValue()+" Female Employees count: "+countfemale.intValue());

        //female employees count in Sales Department
        Long countfemaleHr = empList.stream().filter(x->x.getGender().equals("F")&&x.getDepartment().equals("HR")).count();
        System.out.println("Female Employees in HR Dept count: "+countfemaleHr.intValue());

        //oldest employee in organization
        Optional<Employee> oldestEmployee =empList.stream().sorted(Comparator.comparing(Employee::getAge).reversed()).findFirst();
        System.out.println("Oldest Employee is: "+oldestEmployee.get().getName());

        //youngest employee in organization
        Optional<Employee> youngestEmployee =empList.stream().sorted(Comparator.comparing(Employee::getAge)).findFirst();
        System.out.println("Youngest Employee is: "+youngestEmployee.get().getName());

        //Compress a String using Stream API
        String a = "Saachit";
        String b = IntStream.range(0,a.length())
                .mapToObj(c->a.charAt(c))
                .collect(Collectors.groupingBy(c->c,Collectors.counting()))
                .entrySet()
                .stream()
                .map(c->c.getKey()+""+c.getValue())
                .collect(Collectors.joining());
        System.out.println("Compressed String is"+b);

        //Minimum and Maximum Salary of Employee
        OptionalDouble maxSalary= empList.stream().mapToDouble(Employee::getSalary).max();
        OptionalDouble minSalary= empList.stream().mapToDouble(Employee::getSalary).min();
        System.out.println("Max Salary is: "+maxSalary.getAsDouble()+" Min salary is"+minSalary.getAsDouble());

        //Largest integer in a list
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        OptionalInt opInt = list.stream().parallel().mapToInt(Integer::intValue).min();
        System.out.println("Highest Element is"+ opInt.getAsInt());






    }








}

class Employee{
    private int id;
    private Double salary;
    private String name;

    private String gender;

    private LocalDate dateOfJoining;

    private String department;
    private Integer age;

    public Double getSalary(){
        return salary;
    }

    public Integer getAge(){
        return age;
    }

    public void setSalary(Double salary){
        this.salary = salary;
    }

    public String getName(){
        return name;
    }

    public String getGender(){
        return gender;
    }

    public String getDepartment(){
        return department;
    }

    public LocalDate getDateOfJoining(){
        return dateOfJoining;
    }

    Employee(int id, Double salary, String name, String gender, LocalDate dateOfJoining,String department, Integer age){
        this.id = id;
        this.salary = salary;
        this.name = name;
        this.gender = gender;
        this.dateOfJoining = dateOfJoining;
        this.department = department;
        this.age=age;
    }


}
