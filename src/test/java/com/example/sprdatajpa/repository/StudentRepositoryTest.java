package com.example.sprdatajpa.repository;

import com.example.sprdatajpa.entity.Guardian;
import com.example.sprdatajpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@DataJdbcTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .emailId("varis@gmail.com")
                .firstName("Varis")
                .lastName("Klava")
                //.guardianName("Dzintars")
                //.guardianEmail("dzintars@gmail.com")
                //.guardianMobile("37129885563")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){

        Guardian guardian = Guardian.builder()
                .email("dzintars@gmail.com")
                .name("Dzintars")
                .mobile("37126659906")
                .build();

        Student student = Student.builder()
                .firstName("Krids")
                .emailId("kumar@gmail.com")
                .lastName("Abret")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudent(){
        List<Student> studentList =
                studentRepository.findAll();

        System.out.println("studentList = " + studentList);
    }

    @Test
    public void printStudentByFirstName(){
        List<Student> students =
                studentRepository.findByFirstName("Krids");

        System.out.println("students = " + students);
    }

    @Test
    public void printStudentByFirstNameContaining(){
        List<Student> students =
                studentRepository.findByFirstNameContaining("Kr");

        System.out.println("students = " + students);
    }

    @Test
    public void printStudentBasedOnGuardianName(){
        List<Student> students =
                studentRepository.findByGuardianName("Dzintars");
        System.out.println("students = " + students);
    }

    public void printStudentByEmailAddress(){
        Student student = studentRepository.getStudentByEmailAddress(
                "kumar@gmail.com"
                );
        System.out.println("student = " + student);
    }

    @Test
    public void printStudentFirstNameByEmailAddress(){
        String firstName = studentRepository.getStudentFirstNameByEmailAddress(
                "kumar@gmail.com"
        );
        System.out.println("firstName = " + firstName);
    }

    @Test
    public void printGetStudentByEmailAddressNative(){
        Student student =
                studentRepository.getStudentByEmailAddressNative(
                        "kumar@gmail.com"
                        );

        System.out.println("student = " + student);
    }

    @Test
    public void printGetStudentByEmailAddressNativeNamedParam(){
        Student student =
                studentRepository.getStudentByEmailAddressNativeNamedParam(
                        "kumar@gmail.com"
                );

        System.out.println("student = " + student);
    }
}