package com.jdbcspring.SpringJDBCExample.repo;

import com.jdbcspring.SpringJDBCExample.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Repository
public class StudentRepo {


    private JdbcTemplate jdbc;
    public JdbcTemplate getJdbc() {
        return jdbc;
    }


    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }
    public void save(Student s) {

        System.out.println("saved data");
        String sql = "insert into Student (rollNo, name, marks) values(?, ?, ?)";
        int rows = jdbc.update(sql, s.getRollNo(), s.getName() , s.getMarks());
        System.out.println(rows+ " effected");
    }

    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        String sql = "select * from student";
        RowMapper<Student>  mapper = (ResultSet rs, int rowNum) ->{
                Student s = new Student();
//                System.out.println(rs);
                s.setRollNo(rs.getInt("rollNo"));
                s.setName(rs.getString("name"));
                s.setMarks(rs.getInt("marks"));
                return s;
            };


       return jdbc.query(sql , mapper);
//        return students;
    }
}
