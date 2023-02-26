package com.kiran.UMS.Controller;

import com.kiran.UMS.Entity.Address;
import com.kiran.UMS.Entity.Laptop;
import com.kiran.UMS.Entity.Student;
import com.kiran.UMS.Exception.CustomException;
import com.kiran.UMS.Repository.LaptopRepository;
import com.kiran.UMS.Repository.StudentRepository;
import com.kiran.UMS.Service.UMSInt;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/laptop")
public class LaptopController {
    @Autowired
    UMSInt umsInt;
    @Autowired
    private LaptopRepository laptopRepository;

    //Creating Student
    @PostMapping("/create")
    public Laptop save(@RequestBody String details){

        //Converting string to JSON
        JSONObject jsonObject = new JSONObject(details);

        //Adding Student data
        String id = jsonObject.getString("student");
        try {
            Student student = umsInt.getStudentById(id);
            //Adding Laptop data
            Laptop laptop = new Laptop();
            laptop.setId(jsonObject.getString("id"));
            laptop.setName(jsonObject.getString("name"));
            laptop.setBrand(jsonObject.getString("brand"));
            laptop.setPrice(jsonObject.getInt("price"));
            laptop.setStudent(student);
            return umsInt.addLaptop(laptop);
        }
        catch (Exception e){
            throw new CustomException("No Student found with that id.");
        }


    }

    //Read Student Data
    @GetMapping("/read/{id}")
    public Laptop getLaptopById(@PathVariable String id){
        return umsInt.getLaptopById(id);
    }


    //Update Student Data
    @PutMapping("/update/{id}")
    public Laptop updateLaptop(@PathVariable String id,@RequestBody String details){
        //Converting string to JSON
        JSONObject jsonObject = new JSONObject(details);

        //Adding Student data
        String student_id = jsonObject.getString("student");
        try {
            //Adding student data
            Student student = umsInt.getStudentById(student_id);
            Laptop laptop = new Laptop();
            laptop.setId(jsonObject.getString("id"));
            laptop.setName(jsonObject.getString("name"));
            laptop.setBrand(jsonObject.getString("brand"));
            laptop.setPrice(jsonObject.getInt("price"));
            laptop.setStudent(student);
            return umsInt.upateLaptop(id,laptop);
        }
        catch (Exception e){
            throw new CustomException("No Student found with that id.");
        }
    }

    //Delete Student Data
    @DeleteMapping("/delete/{id}")
    public Laptop deleteLaptop(@PathVariable String id){
        return umsInt.deleteLaptop(id);
    }
}
