package com.mybatis.controller;

import com.mybatis.dao.EmployeeMapper;
import com.mybatis.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeData {

    private final EmployeeMapper employeeMapper;

    @Autowired
    public EmployeeData(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }

    @RequestMapping("/test/{id}")
    public Employee getEmployeeById(@PathVariable("id") Integer id) {
        Employee employee = employeeMapper.selectEmpById(id);
        return employee;
    }
}
