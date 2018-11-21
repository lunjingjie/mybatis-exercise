package com.mybatis.dao;

import com.mybatis.model.Employee;

public interface EmployeeMapper {

    Employee selectEmpById(Integer id);

}
