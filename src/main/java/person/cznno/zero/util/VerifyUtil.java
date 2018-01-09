package person.cznno.zero.util;

/**
 * Created by cznno
 * Date: 18-1-8
 */
public class VerifyUtil {

    public static Boolean isNullOrEmpty(Object o) {
        if (null == o || "".equals(o.toString()))
            return true;
        return false;
    }

    public static Boolean isNotNullOrEmpty(Object o) {
        return !isNullOrEmpty(o);
    }
}
