package org.example.schoolmanagementsystem.Controller;

import lombok.RequiredArgsConstructor;
import org.example.schoolmanagementsystem.Api.ApiResponse;
import org.example.schoolmanagementsystem.DTO.AddressDTO;
import org.example.schoolmanagementsystem.Model.Address;
import org.example.schoolmanagementsystem.Service.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/address")
@RequiredArgsConstructor
public class AddressController
{
    private final AddressService service;

    @GetMapping("/get")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.status(200).body(service.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody AddressDTO address){
        service.addAddress(address);
        return ResponseEntity.status(200).body(new ApiResponse("address added successfully"));
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody AddressDTO address){
        service.updateAddress(address);
        return ResponseEntity.status(200).body(new ApiResponse("address updated successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        service.deleteAddress(id);
        return ResponseEntity.status(200).body(new ApiResponse("address deleted successfully"));
    }
}
