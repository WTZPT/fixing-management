package org.project.controller.student;

import org.project.base.ServiceResult;
import org.project.entity.FixingForm;
import org.project.repository.FixingFormRepository;
import org.project.service.student.StudentService;
import org.project.web.form.StuForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

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

    @GetMapping("/student/history-list")
    public String historyList(Model model) {

        return "student/history-list";
    }
    @RequestMapping(value = "/student/submit",method = RequestMethod.POST)
    public String sumbitPrcess(StuForm stuForm,Model model) {

       // LOGGER.info(stuForm.getAccountName());
        ServiceResult serviceResult = studentService.submitForm(stuForm);

        model.addAttribute("msg",serviceResult.getMessage());

        if(serviceResult.isSuccess())
        {
//            request.setAttribute("msg","success");
            return "success";
        }
        else
        {
//            request.setAttribute("msg","failed");
            return "failed";
        }
    }

}
