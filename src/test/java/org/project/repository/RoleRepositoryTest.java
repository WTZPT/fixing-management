package org.project.repository;

import org.junit.Test;
import org.project.FixingManagementApplicationTests;
import org.project.entity.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class RoleRepositoryTest extends FixingManagementApplicationTests {
    private static  final Logger LOGGER = LoggerFactory.getLogger(RoleRepositoryTest.class);
    @Autowired
    RoleRepository roleRepository;

    @Test
    public void findByUserId() {
        List<Role> roles = roleRepository.findRolesByUserId(1L);

        LOGGER.info(roles.size()+"");

    }
}