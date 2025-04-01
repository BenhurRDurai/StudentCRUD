package com.example.StudentCRUD.controller;

import com.example.StudentCRUD.model.Student;
import com.example.StudentCRUD.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("students")
    public List<Student> getStudents() { return studentService.getStudents(); }

    @GetMapping("students/{rollNo}")
    public Student getStudentByRollNo(@PathVariable("rollNo") int rollNo){ return studentService.getStudentByRollNo(rollNo); }

    @PostMapping("students")
    public String addStudent(@RequestBody Student student){ studentService.addStudent(student); return "Success"; }

    @PutMapping("students")
    public String updateStudent(@RequestBody Student student){ return studentService.updateStudent(student); }

    @DeleteMapping("students/{rollNo}")
    public String deleteStudent(@PathVariable int rollNo){ return studentService.deleteStudent(rollNo); }

}
