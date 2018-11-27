package org.project.service.worker;

import org.project.base.ServiceMultiResult;
import org.project.base.ServiceResult;
import org.project.entity.FixingForm;
import org.project.repository.FixingFormRepository;
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
            return new ServiceResult<>(false,e.getMessage());
        }

        return new ServiceResult<>(true,"状态已经修改");
    }


}
