package org.example.schoolmanagementsystem.Controller;

import lombok.RequiredArgsConstructor;
import org.example.schoolmanagementsystem.Api.ApiResponse;
import org.example.schoolmanagementsystem.Model.Course;
import org.example.schoolmanagementsystem.Service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
public class CourseController
{
    private final CourseService courseService;

    @GetMapping("/get")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.status(200).body(courseService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addCourse(@RequestBody Course course){
        courseService.addCourse(course);
        return ResponseEntity.status(200).body(new ApiResponse("Course added successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable Integer id, @RequestBody Course course){
        courseService.updateCourse(id, course);
        return ResponseEntity.status(200).body(new ApiResponse("Course updated successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable Integer id){
        courseService.deleteCourse(id);
        return ResponseEntity.status(200).body(new ApiResponse("Course deleted successfully"));
    }

    @PutMapping("/assign/teacher-course/{course_id}/{teacher_id}")
    public ResponseEntity<?> assignTeacherCourse(@PathVariable Integer course_id, @PathVariable Integer teacher_id){
        courseService.assignTeacherForCourse(course_id, teacher_id);
        return ResponseEntity.status(200).body(new ApiResponse("Course assigned successfully"));
    }

    @GetMapping("/get/teacher-name/course_id/{id}")
    public ResponseEntity<?> getTeacherNameCourseId(@PathVariable Integer id){
        return ResponseEntity.status(200).body(courseService.getTeacherNameForCourse(id));
    }
}
