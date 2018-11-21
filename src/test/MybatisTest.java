import com.mybatis.dao.EmployeeMapper;
import com.mybatis.model.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MybatisTest {

    public SqlSession createSessionFactory() throws IOException {
        String resource = "mybatisConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        return session;
    }

    @Test
    public void testMybatis() throws IOException {
        SqlSession session = createSessionFactory();
        try {
            Employee employee = session.selectOne(
                    "com.mybatis.employee.selectEmp", 1);
            System.out.println(employee);
        } finally {
            session.close();
        }
    }

    @Test
    public void mybatisMapper() throws IOException {
        SqlSession session = createSessionFactory();
        try {
            EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
            Employee employee = employeeMapper.selectEmpById(1);
            System.out.println(employee);
        } finally {
            session.close();
        }
    }
}
