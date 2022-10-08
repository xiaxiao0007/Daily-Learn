package xia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xia.pojo.Student;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentListAction {

    @RequestMapping("/list")
    @ResponseBody // 解析Ajax请求，必须要在springmvc.xml文件中添加注解驱动
    public List<Student> list(){
        List<Student> students = new ArrayList<>();
        Student student01 = new Student("张三", 18);
        Student student02 = new Student("王二", 19);
        students.add(student01);
        students.add(student02);

        return students; // SpringMVC框架负责将集合转为json数组
    }
}
