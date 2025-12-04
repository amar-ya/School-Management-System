package org.example.schoolmanagementsystem.Controller;

import lombok.RequiredArgsConstructor;
import org.example.schoolmanagementsystem.Api.ApiResponse;
import org.example.schoolmanagementsystem.DTO.TeacherDTO;
import org.example.schoolmanagementsystem.Model.Teacher;
import org.example.schoolmanagementsystem.Service.TeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/teacher")
public class TeacherController
{
    private final TeacherService service;

    @GetMapping("/get")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.status(200).body(service.getAllTeachers());
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody TeacherDTO teacher){
        service.addTeacher(teacher);
        return ResponseEntity.status(200).body(new ApiResponse("teacher added successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody TeacherDTO teacher){
        service.updateTeacher(id, teacher);
        return ResponseEntity.status(200).body(new ApiResponse("teacher updated successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        service.deleteTeacher(id);
        return ResponseEntity.status(200).body(new ApiResponse("teacher deleted successfully"));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getTeacher(@PathVariable Integer id){
        return ResponseEntity.status(200).body(service.findTeacherById(id));
    }
}
