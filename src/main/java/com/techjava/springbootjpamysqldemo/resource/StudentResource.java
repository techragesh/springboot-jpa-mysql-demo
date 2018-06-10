package com.techjava.springbootjpamysqldemo.resource;

import com.techjava.springbootjpamysqldemo.model.Student;
import com.techjava.springbootjpamysqldemo.service.StudentService;
import com.techjava.springbootjpamysqldemo.util.ResourceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentResource {

    @Autowired
    private StudentService studentService;

    @GetMapping("/all")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping("/add")
    public Student addStudent( @Valid @RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @GetMapping("/id/{studentId}")
    public Student getStudentById(@PathVariable Long studentId) {
        return studentService.getStudentById(studentId);
    }

    @PutMapping("/update/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
        Student student1 = getStudentById(id);
        student1.setCity("TexasUS");
        return studentService.updateStudent(student);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }

}
