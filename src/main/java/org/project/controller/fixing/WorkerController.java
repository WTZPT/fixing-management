package org.project.controller.fixing;

import org.project.base.ServiceMultiResult;
import org.project.entity.FixingForm;
import org.project.service.worker.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author weitangzhao
 **/
@Controller
public class WorkerController {

    @Autowired
    WorkerService workerService;

    @GetMapping("/worker/login")
    public String login() {
        return "worker/login";
    }
    @GetMapping("/worker/center")
    public String centerPage(){
        return "worker/center";
    }
    @GetMapping("/worker/list")
    public  String historyListPage(Model model){
        return "worker/fixing-list";
    }
    @RequestMapping("fixing/form")
    @ResponseBody
    public ServiceMultiResult form(String workId){
        ServiceMultiResult<FixingForm> serviceMultiResult = workerService.findAssign(workId);
        return  serviceMultiResult;
    }


}
