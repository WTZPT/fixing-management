package org.project.repository;

import org.project.entity.FixingForm;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @Author weitangzhao
 **/
 public interface FixingFormRepository extends CrudRepository<FixingForm,Long> {

        @Modifying
        @Transactional
        @Query("update FixingForm as fixingFrom set fixingFrom.status = :status where fixingFrom.id = :id")
        void updateStatus(@Param(value = "id") long id,@Param(value = "status") int status);

        @Modifying
        @Transactional
        @Query("update FixingForm as fixingFrom set fixingFrom.assess = :assess where fixingFrom.id = :id")
        void updateAssess(@Param(value = "id") long id,@Param(value = "assess") String assess);

        @Modifying
        @Transactional
        @Query("update FixingForm as f set f.workId = :wd where f.id = :id")
        void addWorker(@Param(value = "id") long id,@Param(value = "wd")String wd);

        @Modifying
        @Transactional
        @Query("update FixingForm as f set f.remark=:rk where f.id = :id")
        void addRemark(@Param(value = "id") long id,@Param(value = "rk")String remark);

         List<FixingForm> findAllByWorkIdAndStatus(String workId,int status);
    /**
     * 查询转态
     * @param status
     * @return
     */
    List<FixingForm> findAllByStatus(int status);

    List<FixingForm> findAllByStatusBetween(int begind,int end);


    List<FixingForm> findAllByWorkId(String workerId);

    /**
     * 根据ID查询
     */
    FixingForm findById(long id);

    List<FixingForm> findAllByName(String name);


}
