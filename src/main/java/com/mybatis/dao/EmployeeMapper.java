package com.mybatis.dao;

import com.mybatis.model.Employee;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface EmployeeMapper {

    List<Employee> getEmpList();

    Employee selectEmpByIdAndName1(@Param("id") Integer id, @Param("lastName") String lastName);

    Employee selectEmpById(Integer id);

    Employee selectEmpByIdAndName(Employee employee);

    void addEmp(Employee employee);

    void updateEmp(Employee employee);

    void delEmpById(Integer id);
}
