package com.example.springinit.service.impl;

import com.example.springinit.model.Employee;
import com.example.springinit.service.ICrudService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
//annotation Service: đánh dấu đây là 1 Bean dạng Service
public class EmployeeServiceImpl implements ICrudService<Employee> {

    @Value("${upload}")
    private String uploadPath;

    private final List<Employee> employees;

    public EmployeeServiceImpl() {
        employees = new ArrayList<>();
        employees.add(new Employee("Long", 20, 10000d, "HN"));
    }

    @Override
    public List<Employee> findAll() {
        return employees;
    }

    @Override
    public Employee findById(Long id) {
        for (Employee e : employees) {
            if (e.getId().equals(id)) {
                return e;
            }
        }
        return null;
    }

    @Override
    public void save(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(employees.get(employees.size() - 1).getId() + 1);
            if (!employee.getImage().isEmpty()) {
                employee.setImagePath(getFileName(employee));
            } else {
                employee.setImagePath("avatar.jpg");
            }
            employees.add(employee);
        } else {
            Employee employeeUpdate = findById(employee.getId());
            if (employeeUpdate != null) {
                employeeUpdate.setName(employee.getName());
                employeeUpdate.setAge(employee.getAge());
                employeeUpdate.setSalary(employee.getSalary());
                employeeUpdate.setAddress(employee.getAddress());
                if (!employee.getImage().isEmpty()) {
                    employeeUpdate.setImagePath(getFileName(employee));
                }
            }
        }
    }

    private String getFileName(Employee employee) {
        MultipartFile image = employee.getImage();
        String fileName = image.getOriginalFilename();
        try {
            FileCopyUtils.copy(image.getBytes(), new File(uploadPath + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return fileName;
    }

    @Override
    public void deleteById(Long id) {
        Employee employee = findById(id);
        if (employee != null) {
            employees.remove(employee);
        }
    }
}
