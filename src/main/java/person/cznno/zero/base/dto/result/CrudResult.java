package person.cznno.zero.base.dto.result;

import lombok.Getter;
import lombok.Setter;
import person.cznno.zero.base.enums.CrudStatusEnum;

/**
 * Created by cznno
 * Date: 18-1-9
 */
@Getter
@Setter
public class CrudResult<T> {
    private CrudStatusEnum statusEnum;
    private T result;
}
