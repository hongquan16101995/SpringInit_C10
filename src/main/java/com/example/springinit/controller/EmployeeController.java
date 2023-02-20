package com.example.springinit.controller;

import com.example.springinit.model.Employee;
import com.example.springinit.service.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    //annotation đánh dấu việc tiêm 1 bean thông qua DI vào 1 bean khác để sử dụng
    private ICrudService<Employee> iCrudService;

    @GetMapping
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView("employees/list");
        modelAndView.addObject("employees", iCrudService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createForm(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("employees/form");
        modelAndView.addObject("employee", new Employee());
        modelAndView.addObject("employees", iCrudService.findAll());
        return modelAndView;
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Employee employee,
                         RedirectAttributes redirect) {
        iCrudService.save(employee);
        redirect.addFlashAttribute("message", "Create successfully!");
        return "redirect:/employees";
        //sử dụng String Redirect để có thể chuyển hướng request mới, tránh duplicate dữ liệu
    }

    @GetMapping("/update/{id}")
    public ModelAndView updateForm(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("employees/form");
        modelAndView.addObject("employee", iCrudService.findById(id));
        return modelAndView;
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute Employee employee,
                         @PathVariable Long id,
                         RedirectAttributes redirect) {
        employee.setId(id);
        iCrudService.save(employee);
        redirect.addFlashAttribute("message", "Update successfully!");
        return "redirect:/employees";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id,
                         RedirectAttributes redirect) {
        iCrudService.deleteById(id);
        redirect.addFlashAttribute("message", "Delete successfully!");
        return "redirect:/employees";
    }
}
