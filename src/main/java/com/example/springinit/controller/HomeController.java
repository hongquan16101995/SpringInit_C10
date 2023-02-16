package com.example.springinit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller //annotation đánh dấu đây là 1 lớp Controller
@RequestMapping("/home")
//annotation khai báo URL cho lớp Controller tương ứng
//có thể dùng cho cả lớp và phương thức
public class HomeController {

    @GetMapping
    //annotation tạo URL riêng cho tương phương thức
    //quy định về kiểu request gọi đến nó
    //chỉ dùng cho phương thức
    //POST: create; PUT: update; DELETE: delete
    public String index(Model model) {
        model.addAttribute("product", "Cocacola");
        return "view/list";
    }

    @GetMapping("/create")
    public String create() {
        return "view/creat";
    }

    @PostMapping
    public String demo(HttpServletRequest request, Model model) {
        //đối tượng Model: dùng để gắn kèm dữ liệu gửi đi cho view
        //đối tượng Request: dùng để nhận giá trị từ đường dẫn tương ứng của JSP
        String name = request.getParameter("name");
        System.out.println(name);
        model.addAttribute("product", name); //phương thức thêm giá trị cho đối tượng Model
        return "view/list";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    //sử dụng RequestMapping ở mức độ method
    //value: quy định đường dẫn cho phương thức
    //method: quy định kiểu request được chấp nhận
    public String home() {
        return "view/list";
    }

    @GetMapping
    public ModelAndView m1() {
        ModelAndView modelAndView = new ModelAndView("view/list");
        //đối tượng ModelAndView: gắn kèm giá trị dự liệu và view-name
        return modelAndView;
    }
}
