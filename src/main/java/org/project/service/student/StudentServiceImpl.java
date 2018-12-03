package org.project.service.student;

import org.project.base.ServiceMultiResult;
import org.project.base.ServiceResult;
import org.project.entity.User;
import org.project.repository.UserRepository;
import org.project.web.dto.IdentityDTO;
import org.project.entity.FixingForm;
import org.project.repository.FixingFormRepository;
import org.project.web.form.StuForm;
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
    @Autowired
    UserRepository userRepository;
    @Override
    public ServiceResult submitForm(StuForm stuForm) {



       User user =  userRepository.findByName(stuForm.getAccountName());

       if(user == null)
           return new ServiceResult(false,"用户认证失败，请重新提交申请单！");

        FixingForm fixingForm = new FixingForm();
        fixingForm.setAddress(stuForm.getAddress());
        fixingForm.setDes(stuForm.getDes());
        fixingForm.setPhone(stuForm.getPhone());
        fixingForm.setRemark(stuForm.getRemark());
        fixingForm.setName(stuForm.getName());
        fixingForm.setSchoolId(String.valueOf(user.getId()));

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
    public ServiceMultiResult<FixingForm> findByUser(IdentityDTO identityDTO) {



        return null;
    }
}
