package com.kiran.UMS.Service;

import com.kiran.UMS.Entity.Book;
import com.kiran.UMS.Entity.Course;
import com.kiran.UMS.Entity.Laptop;
import com.kiran.UMS.Entity.Student;
import com.kiran.UMS.Exception.CustomException;
import com.kiran.UMS.Repository.BookRepository;
import com.kiran.UMS.Repository.CourseRepository;
import com.kiran.UMS.Repository.LaptopRepository;
import com.kiran.UMS.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UMSIntImpl implements UMSInt{
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    LaptopRepository laptopRepository;

    @Autowired
    CourseRepository courseRepository;
    @Autowired
    BookRepository bookRepository;

    @Override
    public Student add(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(String id) {
        try {
            return studentRepository.findById(id).get();
        }
        catch (Exception e){
            throw new CustomException("No Student found with that id.");
        }
    }

    @Override
    public Student updateStudent(String id,Student student1) {
        studentRepository.deleteById(id);
        Student student = add(student1);
        return student;
    }

    @Override
    public Student deleteStudent(String id) {
        try {
            Student student = studentRepository.findById(id).get();
            studentRepository.deleteById(id);
            return student;
        }
        catch (Exception e){
            throw new CustomException("No Student found with that id.");
        }
    }


    @Override
    public Laptop addLaptop(Laptop laptop) {
        return laptopRepository.save(laptop);
    }

    @Override
    public Laptop getLaptopById(String id) {
        try {
            return laptopRepository.findById(id).get();
        }
        catch (Exception e){
            throw new CustomException("No laptop found with that id.");
        }
    }

    @Override
    public Laptop upateLaptop(String id,Laptop laptop) {
        laptopRepository.deleteById(id);
        Laptop laptop1 = addLaptop(laptop);
        return laptop1;
    }

    @Override
    public Laptop deleteLaptop(String id) {
        try {
            Laptop laptop = laptopRepository.findById(id).get();
            laptopRepository.deleteById(id);
            return laptop;
        }
        catch (Exception e){
            throw new CustomException("No laptop found with that id.");
        }
    }


    @Override
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course getCourseById(String id) {
        try {
            return courseRepository.findById(id).get();
        }
        catch (Exception e){
            throw new CustomException("No course found with that id.");
        }
    }

    @Override
    public Course updateCourse(String id, Course course) {
        courseRepository.deleteById(id);
        Course course1 = addCourse(course);
        return course1;
    }

    @Override
    public String deleteCourse(String id) {
        try {
            courseRepository.deleteById(id);
            return "Deleted";
        }
        catch (Exception e){
            throw new CustomException("No course found with that id.");
        }
    }

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book getBookById(String id) {
        try {
            return bookRepository.findById(id).get();
        }
        catch (Exception e){
            throw new CustomException("No book found with that id.");
        }
    }

    @Override
    public Book updateBook(String id, Book book) {
        bookRepository.deleteById(id);
        Book book1 = addBook(book);
        return book1;
    }

    @Override
    public Book deleteBook(String id) {
        try {
            Book book = bookRepository.findById(id).get();
            bookRepository.deleteById(id);
            return book;
        }
        catch (Exception e){
            throw new CustomException("No book found with that id.");
        }
    }
}

