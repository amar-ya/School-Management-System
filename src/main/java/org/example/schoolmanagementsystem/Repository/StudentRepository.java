package org.example.schoolmanagementsystem.Repository;

import org.example.schoolmanagementsystem.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>
{
    @Query("select s from Student s where s.id =:id")
    Student findStudentById(Integer id);

    @Query("select s from Student s join s.courses c where c.id = :id")
    List<Student> findStudentsByCourseId(Integer id);
}
