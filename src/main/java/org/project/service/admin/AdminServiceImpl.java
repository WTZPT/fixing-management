package org.project.service.admin;


import org.project.base.ServiceMultiResult;
import org.project.base.ServiceResult;
import org.project.entity.FixingForm;
import org.project.repository.FixingFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author weitangzhao
 **/
@Service
public class AdminServiceImpl implements  AdminService {

    @Autowired
    FixingFormRepository fixingFormRepository;


    @Override
    public ServiceMultiResult<FixingForm> findAllByFixing() {
       Iterable<FixingForm> fixingForms = fixingFormRepository.findAll();
       List<FixingForm> fixingFormList = new ArrayList<>();
       for(Iterator it = fixingForms.iterator(); it.hasNext();) {
                fixingFormList.add((FixingForm) it.next());
       }
         return new ServiceMultiResult<FixingForm>(fixingFormList.size(),fixingFormList);
    }

    @Override
    public ServiceMultiResult<FixingForm> findRevieByFixing() {

        List<FixingForm> fixingFormList = fixingFormRepository.findAllByStatus(-3);

        return new ServiceMultiResult<FixingForm>(fixingFormList.size(),fixingFormList);

    }

    @Override
    public ServiceMultiResult<FixingForm> findProcessingByFixing() {

        List<FixingForm> fixingFormList = fixingFormRepository.findAllByStatusBetween(1,3);

        return new ServiceMultiResult<FixingForm>(fixingFormList.size(),fixingFormList);
    }

    @Override
    public ServiceMultiResult<FixingForm> findExpiredByFixing() {

        List<FixingForm> fixingFormList = fixingFormRepository.findAllByStatus(4);
        return new ServiceMultiResult<FixingForm>(fixingFormList.size(),fixingFormList);
    }

    @Override
    public ServiceMultiResult<FixingForm> findByDate() {

        return null;
    }

    @Override
    public ServiceResult<FixingForm> findById(long id) {

        FixingForm fixingForm = fixingFormRepository.findById(id);

        if (fixingForm == null) {
            return new ServiceResult<>(false,"没有找到该订单！");
        } else {
            return new ServiceResult<>(true,"找到订单！",fixingForm);
        }

    }

    @Override
    public ServiceResult upDateById(long id, int status) {
        FixingForm fixingForm = fixingFormRepository.findById(id);

        if(fixingForm == null) {
            return new ServiceResult(false,"库中无该订单！");
        } else if(fixingForm.getState() == status) {
            return new ServiceResult(false,"订单状态无需更改！");
        }
        fixingFormRepository.updateStatus(id,status);

        return new ServiceResult(true,"订单状态修改成功！");
    }

    @Override
    public ServiceResult assignFixing(long id, String wordId) {
        FixingForm fixingForm = fixingFormRepository.findById(id);

        if(fixingForm == null) {
            return new ServiceResult(false,"库中无该订单！");
        }

        /**
         * 缺少对维修工号检查
         *
         */

        fixingFormRepository.addWorker(id,wordId);

        return new ServiceResult(true,"订单由工号：" + wordId + "负责。");
    }
}
