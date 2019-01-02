import com.mybatis.dao.StudentMapper;
import com.mybatis.model.Score;
import com.mybatis.model.Student;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.DoubleSupplier;

public class StudentTest {

    @Test
    public void insertStud() throws IOException {
        SqlSession sqlSession = MybatisTest.createSessionFactory();
        try {
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            List<Score> list = mapper.getStudentSubList(1);
            for (Score score : list) {
                System.out.println(score.getSubject() + ":" + score.getScore());
                System.out.println(score.getStudent().getStudentName());
            }
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void getStudAndScore() throws IOException {
        SqlSession sqlSession = MybatisTest.createSessionFactory();
        try {
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            Student student = mapper.getStudentAndScore(2);
            System.out.println(student.getStudentName());

            Student student1 = mapper.getStudentAndScore(2);
            System.out.println(student1.getStudentName());
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void insertStudBatch() throws IOException {
        SqlSession sqlSession = MybatisTest.createSessionFactory();
        try {
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            List<Student> list = new ArrayList<>();
            list.add(new Student("smith", "1"));
            list.add(new Student("tommy", "0"));
            mapper.insertStudBatch(list);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testJava8() {
        Arrays.asList("a", "b", "c").forEach((String e) -> System.out.println(e));
    }
}
