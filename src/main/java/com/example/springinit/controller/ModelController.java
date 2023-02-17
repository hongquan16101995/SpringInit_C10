package com.example.springinit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ModelController {

    @GetMapping("/m1/{text}")
    public String m1(Model model, @PathVariable String text) {
        //Model: là 1 interface dùng để đính kèm dữ liệu gửi đi từ server
        //sử dụng phương thức addAttribute để đính dữ liệu
        System.out.println("Text = " + text);
        model.addAttribute("m1", "Hello");
        return "view/creat";
    }

    @GetMapping("/m2/{id}/{name}")
    public String m2(ModelMap modelMap,
                     @PathVariable("id") String id,
                     @PathVariable String name) {
        //Model: là 1 class dùng để đính kèm dữ liệu gửi đi từ server
        //được kế thừa từ lớp LinkedHashMap, có thêm các phương thức của Map
        //sử dụng phương thức addAttribute để đính dữ liệu
        //annotation PathVariable: dùng để lấy giá trị từ biến được gắn trên đường dẫn
        System.out.println("Text1 = " + id);
        System.out.println("Text2 = " + name);
        modelMap.addAttribute("m2", "Hi");
        return "view/creat";
    }

    @GetMapping("/m3")
    public ModelAndView m3(@RequestParam("name") String name) {
        //ModelAndView: là 1 class dùng để đính kèm dữ liệu và view gửi đi từ server
        //sử dụng phương thức addObject để đính dữ liệu
        //annotation RequestParam: dùng để lấy giá trị của tham số request,
        //nằm trong body nếu là POST, nằm trên đường dẫn nếu là GET
        System.out.println("Name = " + name);
        ModelAndView modelAndView = new ModelAndView("view/creat");
        modelAndView.addObject("m3", "Bye");
        return modelAndView;
    }

    @GetMapping("/display1/**")
    //display-student or display-product
    public String m4() {
        //URL: Uniform Resource Locator, định danh đường dẫn cho tài nguyên ở trên mạng
        //URI: Uniform Resource Identifier, xác định cách mà chấp nhận đường dẫn của server
        return "view/creat";
    }

    @GetMapping("/display2/*")
    //display-student or display-product
    public String m5() {
        //URL: Uniform Resource Locator, định danh đường dẫn cho tài nguyên ở trên mạng
        //URI: Uniform Resource Identifier, xác định cách mà chấp nhận đường dẫn của server
        return "view/creat";
    }
}
