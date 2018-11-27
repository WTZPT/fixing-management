package org.project.controller.student;

import org.project.base.ServiceResult;
import org.project.entity.FixingForm;
import org.project.repository.FixingFormRepository;
import org.project.service.student.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author weitangzhao
 **/
@Controller
public class StudentController {
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);
    @Autowired
    StudentService studentService;
    @GetMapping("/student/login")
    public String logingPage() {
        return "student/login";
    }

    @GetMapping("/student/center")
    public String centerPage(Model model){

        return "student/center";
    }

    @RequestMapping(value = "/student/submit",method = RequestMethod.POST)
    public String sumbitPrcess(FixingForm fixingForm) {

        ServiceResult serviceResult = studentService.submitForm(fixingForm);

        return serviceResult.getMessage();

    }

}
