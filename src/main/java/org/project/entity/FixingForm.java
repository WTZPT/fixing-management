package org.project.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author weitangzhao
 **/
@Entity
@Table(name = "form")
public class FixingForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //学生学号
    @Column(name="school_id")
    private String schoolId;

    //学生名
    private String name;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    //联系电话
    private String phone;

    //维修工工号
    @Column(name = "work_id")
    private String workId;

    //维修地址
    private String address;

    //维修描述
   private String des;

   //订单状态 -3：待审核；  -2： 撤销的订单    -1： 需要修改； 0：审核无通过； 1：审核通过； 2：等待师傅接单； 3：催促订单； 4：订单完成； 5：进行中订单；
   private int status = -3;

   //备注信息
   private String remark;

   //评价信息
    private String assess;

   //创建时间
   @Column(name = "create_time")
   private Date createTime;

   //结单时间
   @Column(name = "end_time")
    private Date endTime;

    public FixingForm() {
    }

    public FixingForm(String schoolId, String phone,String name, String address, String des) {
        this.schoolId = schoolId;
        this.phone = phone;
        this.name = name;
        this.address = address;
        this.des = des;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWorkId() {
        return workId;
    }

    public void setWorkId(String workId) {
        this.workId = workId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public int getState() {
        return status;
    }

    public void setState(int state) {
        this.status = state;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getAssess() {
        return assess;
    }

    public void setAssess(String assess) {
        this.assess = assess;
    }
}
