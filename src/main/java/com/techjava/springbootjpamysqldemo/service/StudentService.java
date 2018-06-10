package com.techjava.springbootjpamysqldemo.service;

import com.techjava.springbootjpamysqldemo.model.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();

    Student getStudentById(Long studentId);

    Student updateStudent(Student student);

    Student addStudent(Student student);

    void deleteStudent(Long studentId);
}