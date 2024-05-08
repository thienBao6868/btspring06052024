package com.ThienBao.btspring06052014.controller;

import com.ThienBao.btspring06052014.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private List<Student> listStudent = new ArrayList<Student>();

    @GetMapping("")
    public ResponseEntity<?> getStudent(){
        return new ResponseEntity<>(this.listStudent, HttpStatus.OK);
    };
    //method add student use @RequestParam
    @PostMapping("")
    public ResponseEntity<?> addStudentWithRequestParam( @RequestParam String name, @RequestParam int age){
        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        this.listStudent.add(student);
        return new ResponseEntity<>(this.listStudent,HttpStatus.OK);
    };

    // method add student use @PathVariable
    @PostMapping("/{name}/{age}")
    public ResponseEntity<?> addStudentWithPathVariable( @PathVariable String name, @PathVariable int age){
        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        this.listStudent.add(student);
        return new ResponseEntity<>(this.listStudent,HttpStatus.OK);
    };
    // method add student use @RequestBody (Sử dụng put thay thế Post để thêm Student)
    @PutMapping("")
    public ResponseEntity<?> addStudentWithRequestBody(@RequestBody Student student){
        this.listStudent.add(student);
        return new ResponseEntity<>(listStudent, HttpStatus.OK);
    };

}
