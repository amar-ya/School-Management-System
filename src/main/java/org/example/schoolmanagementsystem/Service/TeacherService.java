package org.example.schoolmanagementsystem.Service;

import lombok.RequiredArgsConstructor;
import org.example.schoolmanagementsystem.Api.ApiException;
import org.example.schoolmanagementsystem.Model.Teacher;
import org.example.schoolmanagementsystem.Repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService
{
    private final TeacherRepository repository;

    public void addTeacher(Teacher teacher){
        repository.save(teacher);
    }

    public List<Teacher> getAllTeachers(){
        List<Teacher> t = repository.findAll();
        if (t.isEmpty()){
            throw new ApiException("no teachers found");
        }
        return t;
    }

    public void updateTeacher(Integer id,Teacher teacher){
        Teacher t = repository.findTeacherById(id);
        if (t == null){
            throw new ApiException("teacher not found");
        }else {
            t.setAddress(teacher.getAddress());
            t.setAge(teacher.getAge());
            t.setEmail(teacher.getEmail());
            t.setName(teacher.getName());
            t.setSalary(teacher.getSalary());
            repository.save(t);
        }
    }

    public void deleteTeacher(Integer id){
        Teacher t = repository.findTeacherById(id);
        if (t == null){
            throw new ApiException("teacher not found");
        }
        repository.delete(t);
    }

    public Teacher findTeacherById(Integer id){
        Teacher t = repository.findTeacherById(id);
        if (t == null){
            throw new ApiException("teacher not found");
        }
        return t;
    }
}
