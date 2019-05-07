package test.Service.impl; 

import service.IStudentsService;
import service.impl.StudentsServiceImpl;
import domain.Students;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.util.List;

/** 
* StudentsServiceImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>Apr 22, 2019</pre> 
* @version 1.0 
*/ 
public class StudentsServiceImplTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: findAllStudents() 
* 
*/ 
@Test
public void testFindAllStudents() throws Exception {
    IStudentsService cs=new StudentsServiceImpl();
    List<Students> list=cs.findAllStudents();
    for (Students stu :
            list) {
        System.out.println(stu);
    }
} 

/** 
* 
* Method: saveStudent(Students stu) 
* 
*/ 
@Test
public void testSaveStudent() throws Exception {
    IStudentsService cs=new StudentsServiceImpl();
    Students stu=new Students();
    stu.setFirstName("雄安王");
    stu.setLastName("小白");
    stu.setGender(2);
    cs.saveStudent(stu);
} 

/** 
* 
* Method: updateStudent(Students stu) 
* 
*/ 
@Test
public void testUpdateStudent() throws Exception {
//TODO: Test goes here... 
} 

/** 
* 
* Method: deleteStudent(int id) 
* 
*/ 
@Test
public void testDeleteStudent() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: findStudentById(int id) 
* 
*/ 
@Test
public void testFindStudentById() throws Exception { 
//TODO: Test goes here... 
} 


} 
