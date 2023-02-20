package com.example.springinit.model;

public class Employee {
    private static Long INDEX = 0L;
    private Long id;
    private String name;
    private Integer age;
    private Double salary;
    private String address;
    private String imagePath;

    public Employee() {
    }

    public Employee(String name, Integer age, Double salary, String address) {
        this.id = ++INDEX;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.address = address;
    }

    public Employee(String name, Integer age, Double salary, String address, String imagePath) {
        this.id = ++INDEX;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.address = address;
        this.imagePath = imagePath;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
