package org.project.service.student;


import org.project.base.ServiceResult;
import org.project.entity.FixingForm;
import org.project.web.dto.IdentityDTO;


import java.util.List;

/**
 * @Author weitangzhao
 **/

public interface StudentService {

    /**
     * 提交维修单
     */
    public ServiceResult submitForm(FixingForm fixingForm);

    /**
     * 提交評價信息
     */
    public ServiceResult sumbitAssess(String assess,long id);

    /**
     * 查询历史订单
     */
    public  List<FixingForm> findByUser(IdentityDTO identityDTO);


}
