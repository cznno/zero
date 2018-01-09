package person.cznno.zero.base.exception;

import person.cznno.zero.base.enums.CrudStatusEnum;

/**
 * Created by cznno
 * Date: 18-1-9
 */
public class CrudException extends CheckException {

    public CrudException() {
    }

    public CrudException(String message) {
        super(message);
    }

    public CrudException(Throwable cause) {
        super(cause);
    }

    public CrudException(String message, Throwable cause) {
        super(message, cause);
    }

    public CrudException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public CrudException(CrudStatusEnum statusEnum) {
        super(statusEnum.getMsg());
    }

    public CrudException(CrudStatusEnum statusEnum, Throwable cause) {
        super(statusEnum.getMsg(), cause);
    }
}
