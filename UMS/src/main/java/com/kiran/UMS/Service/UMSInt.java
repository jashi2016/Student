package com.kiran.UMS.Service;

import com.kiran.UMS.Entity.Book;
import com.kiran.UMS.Entity.Course;
import com.kiran.UMS.Entity.Laptop;
import com.kiran.UMS.Entity.Student;

public interface UMSInt {
    Student add(Student student);

    Student deleteStudent(String id);

    Student updateStudent(String id,Student student1);

    Student getStudentById(String id);

    Laptop addLaptop(Laptop laptop);

    Laptop getLaptopById(String id);

    Laptop upateLaptop(String id,Laptop laptop);

    Laptop deleteLaptop(String id);

    Course addCourse(Course course);

    Course getCourseById(String id);

    Course updateCourse(String id, Course course);

    String deleteCourse(String id);

    Book addBook(Book book);

    Book getBookById(String id);

    Book updateBook(String id, Book book);

    Book deleteBook(String id);
}
