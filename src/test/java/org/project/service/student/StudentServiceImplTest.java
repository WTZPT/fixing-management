package org.project.service.student;

import org.junit.Test;
import org.project.FixingManagementApplicationTests;
import org.project.entity.FixingForm;
import org.project.repository.FixingFormRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class StudentServiceImplTest extends FixingManagementApplicationTests {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentServiceImplTest.class);
    @Autowired
    StudentService studentService;

    @Autowired
    FixingFormRepository fixingFormRepository;

    @Test
    public void submitForm() {
        FixingForm fixingForm = new FixingForm("1601030092","13631236488","小明","燕华七栋A202","水表头漏水 请求修理");

//        studentService.submitForm(fixingForm);
    }

    @Test
    public void sumbitAssess() {
        fixingFormRepository.findAll();
    }

    @Test
    public void findByUser() {
    }
}