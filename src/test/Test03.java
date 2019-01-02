import com.mybatis.dao.EmployeeAnnotation;
import com.mybatis.dao.EmployeeMapper;
import com.mybatis.model.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;

public class Test03 {

    private SqlSessionFactory factory = null;

    @Test
    public void testOneCache() throws IOException {
        factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatisConfig.xml"));
        SqlSession session = factory.openSession();
        try {
            EmployeeMapper mapper1 = session.getMapper(EmployeeMapper.class);
            Employee employee1 = mapper1.selectEmpByIdAndName1(1, "tom");
            System.out.println(employee1);
            Employee employee2 = mapper1.selectEmpByIdAndName1(1, "tom");
            System.out.println(employee2);
            System.out.println(employee1 == employee2);
        } finally {
            session.close();
        }
    }
    @Test
    public void testSecCache() throws IOException {
        factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatisConfig.xml"));
        SqlSession session1 = factory.openSession();
        SqlSession session2 = factory.openSession();

        EmployeeMapper mapper1 = session1.getMapper(EmployeeMapper.class);
        Employee employee1 = mapper1.selectEmpByIdAndName1(1, "tom");
        System.out.println(employee1);
        session1.close();

        EmployeeMapper mapper2 = session2.getMapper(EmployeeMapper.class);
        Employee employee2 = mapper2.selectEmpByIdAndName1(1, "tom");
        System.out.println(employee2);
        session2.close();

    }
}
