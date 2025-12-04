package org.example.schoolmanagementsystem.Service;

import lombok.RequiredArgsConstructor;
import org.example.schoolmanagementsystem.Api.ApiException;
import org.example.schoolmanagementsystem.DTO.TeacherDTO;
import org.example.schoolmanagementsystem.Model.Teacher;
import org.example.schoolmanagementsystem.Repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService
{
    private final TeacherRepository TeacherRepository;

    public void addTeacher(TeacherDTO teacher){
        Teacher t = new Teacher();
        t.setEmail(teacher.getEmail());
        t.setSalary(teacher.getSalary());
        t.setAddress(teacher.getAddress());
        t.setAge(teacher.getAge());
        t.setName(teacher.getName());
        TeacherRepository.save(t);
    }

    public List<Teacher> getAllTeachers(){
        List<Teacher> t = TeacherRepository.findAll();
        if (t.isEmpty()){
            throw new ApiException("no teachers found");
        }
        return t;
    }

    public void updateTeacher(Integer id,TeacherDTO teacher){
        Teacher t = TeacherRepository.findTeacherById(id);
        if (t == null){
            throw new ApiException("teacher not found");
        }else {
            t.setAddress(teacher.getAddress());
            t.setAge(teacher.getAge());
            t.setEmail(teacher.getEmail());
            t.setName(teacher.getName());
            t.setSalary(teacher.getSalary());
            TeacherRepository.save(t);
        }
    }

    public void deleteTeacher(Integer id){
        Teacher t = TeacherRepository.findTeacherById(id);
        if (t == null){
            throw new ApiException("teacher not found");
        }
        TeacherRepository.delete(t);
    }

    public Teacher findTeacherById(Integer id){
        Teacher t = TeacherRepository.findTeacherById(id);
        if (t == null){
            throw new ApiException("teacher not found");
        }
        return t;
    }
}
