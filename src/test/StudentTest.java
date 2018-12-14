import com.mybatis.dao.StudentMapper;
import com.mybatis.model.Score;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

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
}
