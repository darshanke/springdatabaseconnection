package com.jdbcspring.SpringJDBCExample;





import com.jdbcspring.SpringJDBCExample.model.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.jdbcspring.SpringJDBCExample.service.StudentService;

@SpringBootApplication
public class SpringJdbcExampleApplication {

	public static void main(String[] args) {
		ApplicationContext context =  SpringApplication.run(SpringJdbcExampleApplication.class, args);


		Student s = context.getBean(Student.class);
		s.setName("Darshan");
		s.setRollNo(18);
		s.setMarks(89);

		StudentService service = context.getBean(StudentService.class);
//		StudentService service = new StudentService();
//
		service.addStudent(s);
		System.out.println(service.getStudents());

	}

}
