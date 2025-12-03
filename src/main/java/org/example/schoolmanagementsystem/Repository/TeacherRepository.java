package org.example.schoolmanagementsystem.Repository;

import org.example.schoolmanagementsystem.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long>
{
    Teacher findTeacherById(Integer id);
}
