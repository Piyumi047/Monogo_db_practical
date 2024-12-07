package com.example.mongodb_demo.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "employees")
public class Employee {

    @Id
    private String id;
    private String name;
    private int age;
    private String address;
    private String departmentId;

    public String getId() {
        return id;
    }

    public String getName(){
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public Employee() {}

    public Employee(String id, String name, int age, String address, String departmentId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", departmentId='" + departmentId + '\'' +
                '}';
    }
}
