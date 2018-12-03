package org.project.service.student;


import org.project.base.ServiceMultiResult;
import org.project.base.ServiceResult;
import org.project.entity.FixingForm;
import org.project.web.dto.IdentityDTO;
import org.project.web.form.StuForm;


import java.util.List;

/**
 * @Author weitangzhao
 **/

public interface StudentService {

    /**
     * 提交维修单
     */
    public ServiceResult submitForm(StuForm stuForm);

    /**
     * 提交評價信息
     */
    public ServiceResult sumbitAssess(String assess,long id);

    /**
     * 查询历史订单
     */
    public ServiceMultiResult<FixingForm> findByUser(IdentityDTO identityDTO);


}
