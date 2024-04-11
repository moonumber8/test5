package com.example.demo.dao;

import com.example.demo.model.Emp;

import java.util.List;

public interface EmpDao {
    List getDataEmp();

    int save(Emp emp);
}
