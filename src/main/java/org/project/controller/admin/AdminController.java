package org.project.controller.admin;

import org.project.base.ServiceMultiResult;
import org.project.base.ServiceResult;
import org.project.entity.FixingForm;
import org.project.service.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping("/admin/list")
    public String listFixing(Model model) {
        ServiceMultiResult<FixingForm> serviceMultiResult =  adminService.findAllByFixing();
        model.addAttribute("fixings",serviceMultiResult.getResult());
        return "admin/fixing-list";
    }

    @RequestMapping("/admin/finshed-list")
    public String listFixingFinsh(Model model) {
        ServiceMultiResult<FixingForm> serviceMultiResult =  adminService. findExpiredByFixing();
        model.addAttribute("fixings",serviceMultiResult.getResult());
        return "admin/fixing-list::fixings-list";
    }

    @RequestMapping("/admin/review-list")
    public String listFixingReview(Model model) {
        ServiceMultiResult<FixingForm> serviceMultiResult =  adminService.findRevieByFixing();
        model.addAttribute("fixings",serviceMultiResult.getResult());
        return "admin/fixing-list::fixings-list";
    }

    @RequestMapping("/admin/process-list")
    public String listFixingProcess(Model model) {
        ServiceMultiResult<FixingForm> serviceMultiResult =  adminService.findProcessingByFixing();
        model.addAttribute("fixings",serviceMultiResult.getResult());
        return "admin/fixing-list::fixings-list";
    }

    @RequestMapping("/admin/all-list")
    public String listFixingAll(Model model) {
        ServiceMultiResult<FixingForm> serviceMultiResult =  adminService.findAllByFixing();
        model.addAttribute("fixings",serviceMultiResult.getResult());
        return "admin/fixing-list::fixings-list";
    }

    @PostMapping("/admin/del-fixing")
    @ResponseBody
    public ServiceResult delFixing(String id) {
        ServiceResult serviceResult = adminService.delFixing(Long.valueOf(id));
        return serviceResult;
    }

    @RequestMapping(value = "/admin/update-fixing",method = RequestMethod.POST)
    @ResponseBody
    public ServiceResult updateFixing(String id,String status) {
        ServiceResult serviceResult = adminService.upDateById(Long.valueOf(id),Integer.valueOf(status));
         return serviceResult;
    }

    @RequestMapping(value = "/admin/order-fixing",method = RequestMethod.POST)
    @ResponseBody
    public ServiceResult orderFixing(String id,String workId) {

        ServiceResult serviceResult = adminService.assignFixing(Long.valueOf(id),workId);

        return serviceResult;
    }

    @RequestMapping(value = "/admin/back-fixing",method = RequestMethod.POST)
    @ResponseBody
    public String backFixing(String id,String msg) {

        ServiceResult serviceResult = adminService.backFixing(Long.valueOf(id),msg);

        return serviceResult.getMessage();
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
