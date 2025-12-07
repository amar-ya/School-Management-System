package org.example.schoolmanagementsystem.Controller;

import lombok.RequiredArgsConstructor;
import org.example.schoolmanagementsystem.Api.ApiResponse;
import org.example.schoolmanagementsystem.Model.Student;
import org.example.schoolmanagementsystem.Service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController
{
    private final StudentService studentService;

    @GetMapping("/get")
    public ResponseEntity<?> getAllStudent(){
        return ResponseEntity.status(200).body(studentService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addStudent(@RequestBody Student student){
        studentService.addStudent(student);
        return ResponseEntity.status(200).body(new ApiResponse("Student added successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable Integer id,@RequestBody Student student){
        studentService.updateStudent(id, student);
        return ResponseEntity.status(200).body(new ApiResponse("Student updated successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Integer id){
        studentService.deleteStudent(id);
        return ResponseEntity.status(200).body(new ApiResponse("Student deleted successfully"));
    }

    @PutMapping("/change/major/{student_id}")
    public ResponseEntity<?> changeMajorOfStudent(@PathVariable Integer student_id, @RequestParam String major){
        studentService.changeMajor(student_id, major);
        return ResponseEntity.status(200).body(new ApiResponse("Student changed successfully"));
    }


}
