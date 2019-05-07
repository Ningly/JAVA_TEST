package test.com.service.impl;

import com.domain.Students;
import com.service.IStudentsService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/** 
* StudentsServiceImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>Apr 25, 2019</pre> 
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
//TODO: Test goes here...
    ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");

    IStudentsService cs= (IStudentsService) ac.getBean("studentsService");
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
//TODO: Test goes here... 
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
