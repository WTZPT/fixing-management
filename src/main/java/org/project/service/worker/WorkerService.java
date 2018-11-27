package org.project.service.worker;

import org.project.base.ServiceMultiResult;
import org.project.base.ServiceResult;
import org.project.entity.FixingForm;

/**
 * @Author weitangzhao
 **/
public interface WorkerService {

    /**
     * 根据状态查询订单
     */
    public ServiceMultiResult<FixingForm> findAssignByStatus(String workId,int status);

    /**
     * 查询被分配单
     */
    public ServiceMultiResult<FixingForm> findAssign(String workId);

    /**
     * 确认维修单
     */
    public ServiceResult<FixingForm> confirmForm(long  formId, int status);

}
