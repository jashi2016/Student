package com.kiran.UMS.Controller;

import com.kiran.UMS.Entity.Address;
import com.kiran.UMS.Entity.Book;
import com.kiran.UMS.Entity.Student;
import com.kiran.UMS.Exception.CustomException;
import com.kiran.UMS.Service.UMSInt;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    UMSInt umsInt;


    //Creating Student
    @PostMapping("/create")
    public Book save(@RequestBody String details){

        //Converting string to JSON
        JSONObject jsonObject = new JSONObject(details);

        Book book = new Book();
        book.setId(jsonObject.getString("id"));
        book.setTitle(jsonObject.getString("title"));
        book.setAuthor(jsonObject.getString("author"));
        book.setDescription(jsonObject.getString("description"));
        book.setPrice(jsonObject.getString("price"));


        //Adding student data
        String student_id = jsonObject.getString("student");
        try{
            Student student1 = umsInt.getStudentById(student_id);
            book.setStudent(student1);
            return umsInt.addBook(book);
        }
        catch (Exception e){
            throw new CustomException("No Student found with that id.");
        }
    }

    //Read Student Data
    @GetMapping("/read/{id}")
    public Book getBookById(@PathVariable String id){
        return umsInt.getBookById(id);
    }


    //Update Student Data
    @PutMapping("/update/{id}")
    public Book updateBook(@PathVariable String id,@RequestBody String details){
        //Converting string to JSON
        JSONObject jsonObject = new JSONObject(details);

        Book book = new Book();
        book.setId(jsonObject.getString("id"));
        book.setTitle(jsonObject.getString("title"));
        book.setAuthor(jsonObject.getString("author"));
        book.setDescription(jsonObject.getString("description"));
        book.setPrice(jsonObject.getString("price"));


        //Adding student data
        try {
            String student_id = jsonObject.getString("student");
            Student student1 = umsInt.getStudentById(student_id);
            book.setStudent(student1);
            return umsInt.updateBook(id, book);
        }
        catch (Exception e){
            throw new CustomException("No Student found with that id.");
        }
    }

    //Delete Student Data
    @DeleteMapping("/delete/{id}")
    public Book deleteBook(@PathVariable String id){
        return umsInt.deleteBook(id);
    }
}
