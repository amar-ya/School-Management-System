package org.example.schoolmanagementsystem.Service;

import lombok.RequiredArgsConstructor;
import org.example.schoolmanagementsystem.Api.ApiException;
import org.example.schoolmanagementsystem.DTO.TeacherNameDTO;
import org.example.schoolmanagementsystem.Model.Course;
import org.example.schoolmanagementsystem.Model.Student;
import org.example.schoolmanagementsystem.Model.Teacher;
import org.example.schoolmanagementsystem.Repository.CourseRepository;
import org.example.schoolmanagementsystem.Repository.StudentRepository;
import org.example.schoolmanagementsystem.Repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService
{
    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;
    private final StudentRepository studentRepository;

    public List<Course> getAll(){
        List<Course> list = courseRepository.findAll();
        if (list.isEmpty()){
            throw new ApiException("no courses added yet");
        }
        return list;
    }

    public void addCourse(Course course){
        courseRepository.save(course);
    }

    public void updateCourse(Integer course_id, Course course){
        Course c = courseRepository.findCourseById(course_id);
        if (c == null){
            throw new ApiException("course not found");
        }
        c.setName(course.getName());
        courseRepository.save(c);
    }

    public void deleteCourse(Integer course_id){
        Course c = courseRepository.findCourseById(course_id);
        if (c == null){
            throw new ApiException("course not found");
        }
        courseRepository.delete(c);
    }

    public void assignTeacherForCourse(Integer course_id, Integer teacher_id){
        Teacher t = teacherRepository.findTeacherById(teacher_id);
        Course c = courseRepository.findCourseById(course_id);
        if (t == null || c == null){
            throw new ApiException("couldn't assign teacher - course relation");
        }
        c.setTeacher(t);
        courseRepository.save(c);
    }

    public TeacherNameDTO getTeacherNameForCourse(Integer course_id){
        Course c = courseRepository.findCourseById(course_id);
        if (c == null){
            throw new ApiException("course not found");
        }
        if (c.getTeacher() == null){
            throw new ApiException("course not assigned for teacher");
        }
        TeacherNameDTO name = new TeacherNameDTO(c.getTeacher().getName());
        return name;
    }

    public void addStudentToCourse(Integer course_id, Integer student_id){
        Course c = courseRepository.findCourseById(course_id);
        Student s = studentRepository.findStudentById(student_id);
        if (c == null){
            throw new ApiException("course not found");
        }
        if (s == null){
            throw new ApiException("student not found");
        }
        c.getStudents().add(s);
        s.getCourses().add(c);
        studentRepository.save(s);
        courseRepository.save(c);
    }

    public String teacherOfCourse(Integer course_id){
        Course c = courseRepository.findCourseById(course_id);
        if (c == null){
            throw new ApiException("course not found");
        }
        return teacherRepository.findTeachersNameById(course_id);
    }

    public List<Student> getStudentsOfCourse(Integer course_id){
        Course c = courseRepository.findCourseById(course_id);
        if (c == null){
            throw new ApiException("course not found");
        }
        List<Student> s = studentRepository.findStudentsByCourseId(course_id);
        if (s.isEmpty()){
            throw new ApiException("no students found");
        }
        return s;
    }
}
