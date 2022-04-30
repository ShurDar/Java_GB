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
        System.out.println("���: " + fullName);
        System.out.println("���������: " + position);
        System.out.println("email: " + email);
        System.out.println("���.: " + telephone);
        System.out.println("�����: " + salary);
        System.out.println("�������: " + age);
    }

    public int getAge(){
        return age;
    }

}
