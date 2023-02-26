package com.kiran.UMS.Controller;

import com.kiran.UMS.Entity.Address;
import com.kiran.UMS.Entity.Student;
import com.kiran.UMS.Repository.StudentRepository;
import com.kiran.UMS.Service.UMSInt;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    UMSInt umsInt;
    @Autowired
    private StudentRepository studentRepository;

    //Creating Student
    @PostMapping("/create")
    public Student save(@RequestBody String details){

        //Converting string to JSON
        JSONObject jsonObject = new JSONObject(details);

        //Adding address data
        Address address = new Address();
        address.setCountry(jsonObject.getString("country"));
        address.setDistrict(jsonObject.getString("district"));
        address.setLandmark(jsonObject.getString("landmark"));
        address.setZipcode(jsonObject.getString("zipcode"));
        address.setState(jsonObject.getString("state"));

        //Adding student data
        Student student1 = new Student();
        student1.setName(jsonObject.getString("name"));
        student1.setBranch(jsonObject.getString("branch"));
        student1.setAge(jsonObject.getString("age"));
        student1.setDepartment(jsonObject.getString("department"));
        student1.setPhoneNumber(jsonObject.getString("phoneNumber"));
        student1.setId(jsonObject.getString("id"));
        student1.setAddress(address);
        return umsInt.add(student1);
    }

    //Read Student Data
    @GetMapping("/read/{id}")
    public Student getStudentById(@PathVariable String id){
        return umsInt.getStudentById(id);
    }


    //Update Student Data
    @PutMapping("/update/{id}")
    public Student updateStudent(@PathVariable String id,@RequestBody String student){
        //Converting string to JSON
        JSONObject jsonObject = new JSONObject(student);

        //Adding address data
        Address address = new Address();
        address.setCountry(jsonObject.getString("country"));
        address.setDistrict(jsonObject.getString("district"));
        address.setLandmark(jsonObject.getString("landmark"));
        address.setZipcode(jsonObject.getString("zipcode"));
        address.setState(jsonObject.getString("state"));

        //Adding student data
        Student student1 = new Student();
        student1.setName(jsonObject.getString("name"));
        student1.setBranch(jsonObject.getString("branch"));
        student1.setAge(jsonObject.getString("age"));
        student1.setDepartment(jsonObject.getString("department"));
        student1.setPhoneNumber(jsonObject.getString("phoneNumber"));
        student1.setId(jsonObject.getString("id"));
        student1.setAddress(address);
        return umsInt.updateStudent(id,student1);
    }

    //Delete Student Data
    @DeleteMapping("/delete/{id}")
    public Student deleteStudent(@PathVariable String id){
        return umsInt.deleteStudent(id);
    }
}
