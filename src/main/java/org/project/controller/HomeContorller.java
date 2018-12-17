package org.project.controller;

import org.project.base.ServiceMultiResult;
import org.project.controller.student.StudentController;
import org.project.entity.FixingForm;
import org.project.service.admin.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author weitangzhao
 **/
@Controller
public class HomeContorller {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomeContorller.class);

    @Autowired
    AdminService adminService;

    @Autowired
    StudentController studentController;

    @GetMapping(value = {"/", "/index"})
    public String index(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        LOGGER.info(auth.getAuthorities().toString());

        if(auth.getAuthorities().toString().equals("[ROLE_USER]")){
            return "redirect:student/center";
        }


        if(auth.getAuthorities().toString().equals("[ROLE_ADMIN]")) {
            return "redirect:admin/center";
        }

        if(auth.getAuthorities().toString().equals("[ROLE_WORKER]")) {
            return "redirect:worker/center";
        }

        return "index";
    }

    @GetMapping("/404")
    public String notFoundPage() {
        return "404";
    }

    @GetMapping("/403")
    public String accessError() {
        return "403";
    }

    @GetMapping("/500")
    public String internalError() {
        return "500";
    }
}
