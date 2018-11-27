package org.project.repository;

import org.junit.Assert;
import org.junit.Test;
import org.project.FixingManagementApplicationTests;
import org.project.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class UserRepositoryTest extends FixingManagementApplicationTests {
    @Autowired
    private UserRepository userRepository;
    @Test
     public void testFindone() {
        User user = userRepository.findOne(1L);

        Assert.assertEquals("student1",user.getName());
    }
}