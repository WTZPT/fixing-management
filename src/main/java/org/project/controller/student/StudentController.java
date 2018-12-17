package org.project.controller.student;

import org.project.base.ServiceResult;
import org.project.service.student.StudentService;
import org.project.web.form.StuForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String sumbitPrcess(StuForm stuForm,Model model) {

       // LOGGER.info(stuForm.getAccountName());
        ServiceResult serviceResult = studentService.submitForm(stuForm);

        model.addAttribute("msg",serviceResult.getMessage());

        if(serviceResult.isSuccess())
            return "student/success";
        else
            return "student/fail";
    }

}
