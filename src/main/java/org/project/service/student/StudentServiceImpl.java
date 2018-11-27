package org.project.service.student;

import org.project.base.ServiceResult;
import org.project.web.dto.IdentityDTO;
import org.project.entity.FixingForm;
import org.project.repository.FixingFormRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author weitangzhao
 **/
@Service
public class StudentServiceImpl implements  StudentService {
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentServiceImpl.class);

    @Autowired
    FixingFormRepository fixingFormRepository;

    @Override
    public ServiceResult submitForm(FixingForm fixingForm) {

        /**
         * 缺少对用户的权限认证
         */


        fixingFormRepository.save(fixingForm);

        return new ServiceResult(true,"提交成功！");
    }

    @Override
    public ServiceResult sumbitAssess(String assess,long id) {

        FixingForm fixingForm = fixingFormRepository.findById(id);

        if(fixingForm == null) {
            return new ServiceResult(false,"库中无该订单！");
        }

        fixingFormRepository.updateAssess(id,assess);

        return new ServiceResult(true,"评价成功！");
    }

    @Override
    public List<FixingForm> findByUser(IdentityDTO identityDTO) {
        return null;
    }
}
