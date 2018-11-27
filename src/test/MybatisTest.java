import com.mybatis.dao.EmployeeAnnotation;
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
            EmployeeAnnotation employeeMapper = session.getMapper(EmployeeAnnotation.class);
            Employee employee = employeeMapper.selectEmpById(2);
            System.out.println(employee);
        } finally {
            session.close();
        }
    }

    @Test
    public void test01() throws IOException {
        // sqlSessionFactory.openSession();该方法不会自动提交数据，需要手动提交
        SqlSession session = createSessionFactory();
        try {
            EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
            Employee employee = new Employee(null, "mcjin", "0", "abcemail");
            mapper.addEmp(employee);
            session.commit();
            System.out.println(employee.getId());
        } finally {
            session.close();
        }
    }
}
