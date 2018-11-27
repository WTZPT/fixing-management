package org.project.repository;


import org.project.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * @Author weitangzhao
 **/
public interface UserRepository extends CrudRepository<User,Long> {


    /**
     * 通过用户名查询用户
     * @param username
     * @return
     */
    User findByName(String username);

}
