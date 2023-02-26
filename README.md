# Student

List of Apis and their description

UMSInt
This interface all the abstract methods for this application



UMSIntImpl
It is the service layer which provides implemenataion and business logic for all methods in the UMSInt interface.

*<id> represents id of the respective entity of the controller

Controllers:

1.StudentController

api: localhost:8080/student/create
function: Student add(Student student);
purpose: adds student to database
-> Provide student as a requestbody

api: localhost:8080/student/read/{<id>}
function: Student getStudentById(String id);
purpose: get student from database
-> Provide id as a path variable

api: localhost:8080/student/update/{<id>
function: Student updateStudent(String id,Student student1);
purpose: updates student to database
-> Provide id as a path variable and student as a requestbody

function: Student deleteStudent(String id);
api: localhost:8080/student/delete/{<id>}
purpose: delets student from database
-> Provide id as a path variable



2.LaptopController

api: localhost:8080/laptop/create
function: Laptop addLaptop(Laptop laptop);
purpose: adds laptop to database
-> Provide laptop as a requestbody

api: localhost:8080/laptop/read/{<id>}
function: Laptop getLaptopById(String id);
purpose: get laptop from database
-> Provide id as a path variable

api: localhost:8080/laptop/update/{<id>
function: Laptop upateLaptop(String id,Laptop laptop);
purpose: updates laptop to database
-> Provide id as a path variable and laptop as a requestbody

api: localhost:8080/laptop/delete/{<id>}
function: Laptop deleteLaptop(String id);
purpose: delets laptop from database
-> Provide id as a path variable


3.CourseController

api: localhost:8080/course/create
purpose: adds course to database
function: Course addCourse(Course course);
purpose: adds course to database
-> Provide course as a requestbody

api: localhost:8080/course/read/{<id>}
function: Course getCourseById(String id);
purpose: get course from database
-> Provide id as a path variable

api: localhost:8080/course/update/{<id>
function: Course updateCourse(String id, Course course);
purpose: updates course to database
-> Provide id as a path variable and course as a requestbody

api: localhost:8080/course/delete/{<id>}
function: String deleteCourse(String id);
purpose: delete course to database
-> Provide id as a path variable


4.BookController

api: localhost:8080/book/create
function: Book addBook(Book book);
purpose: adds book to database
-> Provide course as a requestbody

api: localhost:8080/book/read/{<id>}
function: Book getBookById(String id);
purpose: get book from database
-> Provide id as a path variable

api: localhost:8080/book/update/{<id>
function: Book updateBook(String id, Book book);
purpose: updates book to database
-> Provide id as a path variable and course as a requestbody

api: localhost:8080/book/delete/{<id>}
function: Book deleteBook(String id);
purpose: delets book from database
-> Provide id as a path variable



CustomException
This class will be responsible for catching the runtime exceptions and display the message using the controlleradvice class and handles the exception and returns them as a response body




Data Structures used are List from java.util library.



Flow:

1. Once the api is hit with respective data. 
2. Controller will contact service class and executes respective methods.
3. From service method, it contacts respective repository and performs necessary action and returns the result to the controller
4. If any exception occurs, then custom messages will be displayed to report that exception.
