import com.test.ssm.exam.util.ExamConstants;
import org.springframework.util.DigestUtils;


public class Md5UtilTest {
    public static void main(String[] args) {
        System.out.println(DigestUtils.md5DigestAsHex(("123456"+ ExamConstants.PASSWORD_SALT).getBytes()));
    }
}
