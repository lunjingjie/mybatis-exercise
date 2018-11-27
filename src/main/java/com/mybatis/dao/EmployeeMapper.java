package com.mybatis.dao;

import com.mybatis.model.Employee;

public interface EmployeeMapper {

    Employee selectEmpById(Integer id);

    void addEmp(Employee employee);

    void updateEmp(Employee employee);

    void delEmpById(Integer id);
}
