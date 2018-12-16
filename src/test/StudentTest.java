import com.mybatis.dao.StudentMapper;
import com.mybatis.model.Score;
import com.mybatis.model.Student;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class StudentTest {

    @Test
    public void insertStud() throws IOException {
        SqlSession sqlSession = MybatisTest.createSessionFactory();
        try {
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            List<Score> list = mapper.getStudentSubList(1);
            for (Score score : list) {
                System.out.println(score);
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
            Student student = mapper.getStudentAndScore(1);
            System.out.println(student);
        } finally {
            sqlSession.close();
        }
    }
}
