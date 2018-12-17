import com.mybatis.dao.EmployeeAnnotation;
import com.mybatis.dao.EmployeeMapper;
import com.mybatis.model.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MybatisTest {

    public static SqlSession createSessionFactory() throws IOException {
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

    /*
    * 参数封装成pojo对象，传对象到mapper配置文件
    * */
    @Test
    public void test02() throws IOException {
        SqlSession session = createSessionFactory();
        try {
            EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
            Employee employee1 = new Employee(1, "tom", null, null);
            Employee employee = mapper.selectEmpByIdAndName(employee1);
            System.out.println(employee);
        } finally {
            session.close();
        }
    }

    /*
    * 参数封装成map对象，传对象到mapper配置文件
    * */
    @Test
    public void test03() throws IOException {
        SqlSession session = createSessionFactory();
        try {
            EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
            Employee employee = mapper.selectEmpByIdAndName1(1, "tom");
            System.out.println(employee);
        } finally {
            session.close();
        }
    }
    /*
    * 返回一个List集合，resultType仍然是employee类，即为List集合中的元素
    * */
    @Test
    public void test04() throws IOException {
        SqlSession session = createSessionFactory();
        try {
            EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
            List<Employee> list = mapper.getEmpList();
            System.out.println(list);
            for (Employee employee : list) {
                System.out.println(employee);
            }
        } finally {
            session.close();
        }
    }
}
