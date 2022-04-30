package ru.gb.shurupova.HomeWorkFive;

public class Employee {
    private String fullName;
    private String position;
    private String email;
    private String telephone;
    private int salary;
    private int age;

    public Employee(String fullName, String position, String email, String telephone, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.telephone = telephone;
        this.salary = salary;
        this.age = age;
    }

    public void print(){
        System.out.println("ФИО: " + fullName);
        System.out.println("Должность: " + position);
        System.out.println("email: " + email);
        System.out.println("Тел.: " + telephone);
        System.out.println("Оклад: " + salary);
        System.out.println("Возраст: " + age);
    }

    public int getAge(){
        return age;
    }

}
