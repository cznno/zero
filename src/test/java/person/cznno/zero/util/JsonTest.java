package person.cznno.zero.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import person.cznno.zero.admin.entity.UserEntity;

/**
 * Created by cznno
 * Date: 18-1-3
 */
public class JsonTest {

    @Test
    public void foo() throws JsonProcessingException {
        UserEntity obj=new UserEntity();
        ObjectMapper mapper = new ObjectMapper();
        String str = mapper.writeValueAsString(obj);
        System.out.println(str);
    }
}
