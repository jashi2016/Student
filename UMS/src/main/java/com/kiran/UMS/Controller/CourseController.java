package com.kiran.UMS.Controller;

import com.kiran.UMS.Entity.Address;
import com.kiran.UMS.Entity.Course;
import com.kiran.UMS.Entity.Student;
import com.kiran.UMS.Exception.CustomException;
import com.kiran.UMS.Repository.StudentRepository;
import com.kiran.UMS.Service.UMSInt;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    UMSInt umsInt;

    //Creating Course
    @PostMapping("/create")
    public Course save(@RequestBody String details){

        //Converting string to JSON
        JSONObject jsonObject = new JSONObject(details);

        //Adding course data
        Course course = new Course();
        course.setId(jsonObject.getString("id"));
        course.setTitle(jsonObject.getString("title"));
        course.setDescription(jsonObject.getString("description"));
        course.setDuration(jsonObject.getString("duration"));

        //Adding student data
        List<Student> students = new ArrayList<>();
        JSONArray jsonArray = jsonObject.getJSONArray("students");
        for (int i=0;i<jsonArray.length();i++){
            //Adding each element of JSON array into ArrayList
            try {
                students.add(umsInt.getStudentById((String) jsonArray.get(i)));
            }
            catch (Exception e){
                throw new CustomException("No Student found with that id.");
            }
        }
        course.setStudentList(students);
        return umsInt.addCourse(course);
    }

    //Read Student Data
    @GetMapping("/read/{id}")
    public Course getCourseById(@PathVariable String id){
        return umsInt.getCourseById(id);
    }


    //Update Student Data
    @PutMapping("/update/{id}")
    public Course updateCourse(@PathVariable String id,@RequestBody String details){
        //Converting string to JSON
        JSONObject jsonObject = new JSONObject(details);

        //Adding course data
        Course course = new Course();
        course.setId(jsonObject.getString("id"));
        course.setTitle(jsonObject.getString("title"));
        course.setDescription(jsonObject.getString("description"));
        course.setDuration(jsonObject.getString("duration"));

        //Adding student data
        List<Student> students = new ArrayList<>();
        JSONArray jsonArray = jsonObject.getJSONArray("students");
        for (int i=0;i<jsonArray.length();i++){
            //Adding each element of JSON array into ArrayList
            students.add(umsInt.getStudentById((String) jsonArray.get(i)));
        }
        course.setStudentList(students);
        return umsInt.updateCourse(id,course);
    }

    //Delete Student Data
    @DeleteMapping("/delete/{id}")
    public String deleteCourse(@PathVariable String id){
        return umsInt.deleteCourse(id);
    }
}
