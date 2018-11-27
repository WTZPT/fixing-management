package org.project.service.admin;

import org.junit.Test;
import org.project.FixingManagementApplicationTests;
import org.project.base.ServiceMultiResult;
import org.project.entity.FixingForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.SpringTransactionAnnotationParser;

import static org.junit.Assert.*;

public class AdminServiceImplTest extends FixingManagementApplicationTests {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdminServiceImplTest.class);

    @Autowired
    AdminService adminService;
    @Test
    public void findAllByFixing() {
        ServiceMultiResult<FixingForm> fixingFormServiceMultiResult = adminService.findAllByFixing();

        LOGGER.info(String.valueOf(fixingFormServiceMultiResult.getResultSize()));

    }

    @Test
    public void findRevieByFixing() {
    }

    @Test
    public void findProcessingByFixing() {
    }

    @Test
    public void findExpiredByFixing() {
    }

    @Test
    public void findByDate() {
    }

    @Test
    public void findById() {
    }

    @Test
    public void upDateById() {
    }

    @Test
    public void assignFixing() {
    }
}