package person.cznno.zero.util;

import person.cznno.zero.admin.entity.UserEntity;

/**
 * Created by cznno
 * Date: 18-1-8
 */
public class VerifyUtil {

    public static Boolean isNullOrEmpty(Object o){
        if(null == o || "".equals(o.toString()))
            return true;
        return false;
    }

    public static void main(String[] args) {
        UserEntity o = new UserEntity();
        String s= "";
        System.out.println(isNullOrEmpty(s));
    }
}
