package com.example.community.config;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@Controller
@RequestMapping("/testController")
public class testController {

    @RequestMapping("/testhttp")
    private void http(HttpServletRequest request, HttpServletResponse response) {
        //获取请求数据
        System.out.println(request.getMethod());
            //请求路径
        System.out.println(request.getServletPath());
            //消息头
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = headerNames.nextElement();
            String value = request.getHeader(key);
            System.out.println(key + ": " +value);
        }
            //指定数据
        /*http://localhost:8080/community/testController/testhttp?code=111&name=a*/
        System.out.println(request.getParameter("code"));

        //返回响应数据
        response.setContentType("text/html;charset=utf-8");
        try (
                PrintWriter writer = response.getWriter();
                ){
            writer.write("<h1>一级标题</h1>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //名称跟html中对应，就可以直接获取
    @RequestMapping(path = "/student", method = RequestMethod.POST)
    @ResponseBody
    public String saveStudent(String name,int age) {
        System.out.println(name);
        System.out.println(age);
        return "success";
    }

    //响应html数据
    //1.
    @RequestMapping(path = "/teacher", method = RequestMethod.GET)
    public ModelAndView getTeacher() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name","aTeacher");
        modelAndView.addObject("age",20);
        modelAndView.setViewName("/demo/view");
        return modelAndView;
    }

    //2.
    @RequestMapping(path = "/school", method = RequestMethod.GET)
    public String getSchool(Model model) {
        model.addAttribute("name","学校");
        model.addAttribute("age",80);
        return "/demo/view";
    }

    //响应JSON数据(异步请求)
    //JAVA对象  -> JSON字符串  -> JS对象
}
