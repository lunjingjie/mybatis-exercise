package com.mybatis.dao;

import com.mybatis.model.Employee;
import org.apache.ibatis.annotations.Select;

public interface EmployeeAnnotation {

    @Select("select * from tbl_employee where id = #{id}")
    Employee selectEmpById(Integer id);
}
