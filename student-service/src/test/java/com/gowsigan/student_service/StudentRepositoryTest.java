package com.gowsigan.student_service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.BDDAssertions.then;

@DataJpaTest
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    void testGetStudentByName_returnsStudentDetails() {
        //given
        Student savedStudent = testEntityManager.persistFlushFind(new Student(null,"John"));
        //when
        Student student = studentRepository.getStudentByName("John");
        //then
        then(student.getId()).isNotNull();
        then(student.getName()).isEqualTo(savedStudent.getName());
    }
}
