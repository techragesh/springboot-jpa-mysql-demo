package com.techjava.springbootjpamysqldemo.service.impl;

import com.techjava.springbootjpamysqldemo.model.Student;
import com.techjava.springbootjpamysqldemo.repository.StudentRepository;
import com.techjava.springbootjpamysqldemo.service.StudentService;
import com.techjava.springbootjpamysqldemo.util.ResourceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long studentId) {
        return studentRepository.findById(studentId)
                .orElseThrow(()->new ResourceException("Student", "Id", studentId));
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long studentId) {
        studentRepository.deleteById(studentId);
    }
}
