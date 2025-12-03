package org.example.schoolmanagementsystem.Service;

import lombok.RequiredArgsConstructor;
import org.example.schoolmanagementsystem.Api.ApiException;
import org.example.schoolmanagementsystem.DTO.AddressDTO;
import org.example.schoolmanagementsystem.Model.Address;
import org.example.schoolmanagementsystem.Model.Teacher;
import org.example.schoolmanagementsystem.Repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService
{
    private final AddressRepository repository;

    public List<Address> getAll(){
        List<Address> list = repository.findAll();
        if (list.isEmpty()){
            throw new ApiException("address not found");
        }
        return list;
    }

    public void addAddress(AddressDTO addressDTO){
        Teacher t = repository.findTeacherById(addressDTO.getTeacher_id());
        if (t == null){
            throw new ApiException("teacher not found");
        }
        Address address = new Address();
        address.setTeacher(t);
        address.setStreet(addressDTO.getStreet());
        address.setBuilding_number(addressDTO.getBuilding_number());
        address.setArea(addressDTO.getArea());
        repository.save(address);
    }

    public void updateAddress(AddressDTO addressDTO){
        Teacher t = repository.findTeacherById(addressDTO.getTeacher_id());
        if (t == null){
            throw new ApiException("teacher not found");
        }else {
            if (t.getAddress() == null){
                throw new ApiException("address not found");
            }else {
                Address a = repository.findAddressByid(t.getAddress().getId());
                a.setStreet(addressDTO.getStreet());
                a.setBuilding_number(addressDTO.getBuilding_number());
                a.setArea(addressDTO.getArea());
                repository.save(a);
            }
        }
    }

    public void deleteAddress(Integer id){
        Address a = repository.findAddressByid(id);
        if (a == null){
            throw new ApiException("address not found");
        }
        repository.delete(a);
    }
}
