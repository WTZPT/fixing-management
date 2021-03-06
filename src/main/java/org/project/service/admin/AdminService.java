package org.project.service.admin;

import org.project.base.ServiceMultiResult;
import org.project.base.ServiceResult;
import org.project.entity.FixingForm;

import java.util.List;

/**
 * @Author weitangzhao
 **/
public interface AdminService {
    /**
     * 查询所有维修单
     */
    public ServiceMultiResult<FixingForm> findAllByFixing();

    /**
     * 查询所有待审核维修单
     */
    public ServiceMultiResult<FixingForm> findRevieByFixing();

    /**
     * 查询所有正在维修中的维修单
     */
    public ServiceMultiResult<FixingForm> findProcessingByFixing();

    /**
     * 查询所有历史维修单
     */
    public ServiceMultiResult<FixingForm> findExpiredByFixing();

    /**
     * 按照开始时间，结束时间查询订单
     */
    public ServiceMultiResult<FixingForm> findByDate();

    /**
     * 按照订单Id查询维修单
     */
    public ServiceResult<FixingForm> findById(long id);

    /**
     * 修改维修单状态
     */
    public ServiceResult upDateById(long id,int status);

    /**
     * 退回维修单信息写入
     */
    public ServiceResult backFixing(long id,String msg);

    /**
     * 分配维修单
     */
    public ServiceResult assignFixing(long id,String wordId);

    /**
     * 删除订单
     */
    public ServiceResult delFixing(long id);
}
