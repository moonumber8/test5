package com.example.demo.dao;

import com.example.demo.model.Emp;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.PreparedStatementSetter;
//import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class EmpDaoImpl implements EmpDao {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(Emp emp) {
        return jdbcTemplate.update("INSERT INTO Employee (EmpNum, EmpName, Position) VALUES (?, ?, ?)",emp.getEmpNum(), emp.getEmpName(), emp.getPosition());
    }
}
