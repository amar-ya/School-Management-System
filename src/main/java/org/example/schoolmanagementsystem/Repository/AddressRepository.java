package org.example.schoolmanagementsystem.Repository;

import org.example.schoolmanagementsystem.Model.Address;
import org.example.schoolmanagementsystem.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>
{
    Address findAddressByid(Integer id);

    @Query("select t from Teacher t where t.id =:id")
    Teacher findTeacherById(Integer id);
}
