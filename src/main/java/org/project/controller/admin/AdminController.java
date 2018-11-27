package org.project.controller.admin;

import org.project.base.ServiceMultiResult;
import org.project.entity.FixingForm;
import org.project.service.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author weitangzhao
 **/
@Controller
public class AdminController {
    @Autowired
    AdminService adminService;

    @GetMapping("/admin/center")
    public String adminCenterPage(Model model){

        ServiceMultiResult serviceMultiResult =  adminService.findAllByFixing();

        model.addAttribute("FixingFrom",serviceMultiResult.getResult());

        return "admin/center";
    }

    @GetMapping("/admin/house/list")
    public String list() {

        return "admin/house-list";
    }

    @ResponseBody
    @GetMapping("admin/form")
    public  ServiceMultiResult<FixingForm> houses(){
        ServiceMultiResult<FixingForm> multiResult = adminService.findAllByFixing();
        return multiResult;
    }

    @GetMapping("/admin/welcome")
    public String welcomePage(){
        return "admin/welcome";
    }

    @GetMapping("/admin/login")
    public String login(){
        return "admin/login";
    }


}
