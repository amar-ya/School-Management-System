package org.example.schoolmanagementsystem.Service;

import lombok.RequiredArgsConstructor;
import org.example.schoolmanagementsystem.Api.ApiException;
import org.example.schoolmanagementsystem.Model.Student;
import org.example.schoolmanagementsystem.Repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService
{
    private final StudentRepository studentRepository;

    public List<Student> getAll(){
        return studentRepository.findAll();
    }

    public void addStudent(Student student){
        studentRepository.save(student);
    }

    public void updateStudent(Integer id, Student student){
        Student s = studentRepository.findStudentById(id);
        if (s == null){
            throw new ApiException("Student not found");
        }
        s.setAge(student.getAge());
        s.setName(student.getName());
        s.setMajor(student.getMajor());
        studentRepository.save(s);
    }

    public void deleteStudent(Integer id){
        Student s = studentRepository.findStudentById(id);
        if (s == null){
            throw new ApiException("Student not found");
        }
        studentRepository.delete(s);
    }

    public void changeMajor(Integer id, String major){
        Student s = studentRepository.findStudentById(id);
        if (s == null){
            throw new ApiException("Student not found");
        }
        if (s.getMajor().equals(major)){
            throw new ApiException("your major is "+s.getMajor()+" already");
        }
        s.setCourses(null);
        s.setMajor(major);
        studentRepository.save(s);
    }
}
