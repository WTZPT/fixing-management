package org.project.controller.fixing;

import org.project.base.ServiceMultiResult;
import org.project.entity.FixingForm;
import org.project.service.worker.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author weitangzhao
 **/
@Controller
public class WorkerController {

    @Autowired
    WorkerService workerService;

    @RequestMapping("/fixing/login")
    public String login() {
        return "fixing/login";
    }

    @RequestMapping("fixing/form")
    @ResponseBody
    public ServiceMultiResult form(String workId){
        ServiceMultiResult<FixingForm> serviceMultiResult = workerService.findAssign(workId);
        return  serviceMultiResult;
    }


}
