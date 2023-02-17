package com.example.springinit.controller;

import com.example.springinit.model.Employee;
import com.example.springinit.service.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    //annotation đánh dấu việc tiêm 1 bean thông qua DI vào 1 bean khác để sử dụng
    private ICrudService<Employee> iCrudService;

    @GetMapping
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView("employee/list");
        modelAndView.addObject("employees", iCrudService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee/create";
    }

    @PostMapping
    public ModelAndView createEmployee(@ModelAttribute Employee employee) {
        iCrudService.save(employee);
        ModelAndView modelAndView = new ModelAndView("employee/list");
        modelAndView.addObject("employees", iCrudService.findAll());
        return modelAndView;
    }

    @GetMapping("/update/{id}")
    public String updateForm(Model model,
                             @PathVariable Long id) {
        model.addAttribute("employee", iCrudService.findById(id));
        return "employee/update";
    }

    @PostMapping("/update")
    public ModelAndView updateEmployee(@ModelAttribute Employee employee) {
        iCrudService.save(employee);
        ModelAndView modelAndView = new ModelAndView("employee/list");
        modelAndView.addObject("employees", iCrudService.findAll());
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable Long id) {
        iCrudService.deleteById(id);
        ModelAndView modelAndView = new ModelAndView("employee/list");
        modelAndView.addObject("employees", iCrudService.findAll());
        return modelAndView;
    }

}
