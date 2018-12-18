package org.project.controller.fixing;

import org.project.base.ServiceMultiResult;
import org.project.base.ServiceResult;
import org.project.entity.FixingForm;
import org.project.service.worker.WorkerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author weitangzhao
 **/
@Controller
public class WorkerController {
    private static final Logger LOGGER = LoggerFactory.getLogger(WorkerController.class);


    @Autowired
    WorkerService workerService;


    @GetMapping("/worker/login")
    public String login() {
        return "worker/login";
    }
    @GetMapping("/worker/center")
    public String centerPage() {
        return "worker/repair-list";
    }
    @GetMapping("/worker/list")
    public  String historyListPage(Model model){
        return "worker/fixing-list";
    }



    @GetMapping("/worker/detail-list")
    public String detailList(Model model,String worker,int state){
        ServiceResult<String> serviceResult = workerService.findWorkId(worker);
        LOGGER.info(serviceResult.getResult());
        ServiceMultiResult<FixingForm> fixingFormServiceMultiResult = null;
        if(!serviceResult.equals(null)) {
            fixingFormServiceMultiResult = workerService.findAssignByStatus(serviceResult.getResult(),state);
        }
        model.addAttribute("fixings",fixingFormServiceMultiResult.getResult());
        return "worker/repair-list::fixings-list";
    }

    @PostMapping("/worker/accept")
    @ResponseBody
    public ServiceResult accept(String worker,long formId){
        LOGGER.info(worker+"  "+formId);
        ServiceResult<String> serviceResult = workerService.findWorkId(worker);
        if(serviceResult.isSuccess() == false)
            return serviceResult;
        ServiceResult serviceResult1 = workerService.confirmForm(formId,5);

        return serviceResult1;
    }


    @RequestMapping("fixing/form")
    @ResponseBody
    public ServiceMultiResult form(String workId){
        ServiceMultiResult<FixingForm> serviceMultiResult = workerService.findAssign(workId);
        return  serviceMultiResult;
    }


}
