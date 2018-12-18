package org.project.service.worker;

import org.project.base.ServiceMultiResult;
import org.project.base.ServiceResult;
import org.project.entity.FixingForm;
import org.project.entity.User;
import org.project.repository.FixingFormRepository;
import org.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author weitangzhao
 **/
@Service
public class WorkerServiceImpl implements WorkerService {

    @Autowired
    FixingFormRepository fixingFormRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public ServiceResult<String> findWorkId(String name) {
        User user = userRepository.findByName(name);

        if(user == null) {
            return new ServiceResult<String>(false,"账号信息异常！");
        }


        return new ServiceResult<String>(true,"正常！",user.getNumberId());

    }

    @Override
    public ServiceMultiResult<FixingForm> findAssignByStatus(String workId, int status) {

        List<FixingForm> fixingFormList = fixingFormRepository.findAllByWorkIdAndStatus(workId,status);

        return new ServiceMultiResult<FixingForm>(fixingFormList.size(),fixingFormList);
    }

    @Override
    public ServiceMultiResult<FixingForm> findAssign(String workId) {

        List<FixingForm> fixingFormList = fixingFormRepository.findAllByWorkId(workId);

        return new ServiceMultiResult<>(fixingFormList.size(),fixingFormList);
    }

    @Override
    public ServiceResult<FixingForm> confirmForm(long formId, int status) {

        try {
            fixingFormRepository.updateStatus(formId,status);
        } catch (Exception e) {
            return new ServiceResult<>(false,"确认维修单失败\n错误信息："+e.getMessage()+"\n单号："+formId);
        }

        return new ServiceResult<>(true,"成功确认维修单\n单号："+formId);
    }


}
