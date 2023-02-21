package com.example.springinit.model;

import org.springframework.web.multipart.MultipartFile;

public class Employee {
    private static Long INDEX = 0L;
    private Long id;
    private String name;
    private Integer age;
    private Double salary;
    private String address;
    private String imagePath;
    private MultipartFile image;

//    private City city;

    public Employee() {
    }

    public Employee(String name, Integer age, Double salary, String address) {
        this.id = ++INDEX;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.address = address;
    }

    public Employee(String name, Integer age, Double salary, String address, String imagePath, MultipartFile image) {
        this.id = ++INDEX;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.address = address;
        this.imagePath = imagePath;
        this.image = image;
    }

//    public Employee(Long id, String name, Integer age, Double salary, String address, String imagePath, MultipartFile image, City city) {
//        this.id = id;
//        this.name = name;
//        this.age = age;
//        this.salary = salary;
//        this.address = address;
//        this.imagePath = imagePath;
//        this.image = image;
//        this.city = city;
//    }

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

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

//    public City getCity() {
//        return city;
//    }
//
//    public void setCity(City city) {
//        this.city = city;
//    }
}
