package person.cznno.zero.util;

/**
 * Created by cznno
 * Date: 18-1-8
 */
public class VerifyUtil {

    public static Boolean isNullOrEmpty(Object o) {
        return null == o || "".equals(o.toString());
    }

    public static Boolean isNotNullOrEmpty(Object o) {
        return !isNullOrEmpty(o);
    }
}
