package person.cznno.zero.util;

import com.github.pagehelper.PageHelper;
import person.cznno.zero.base.model.entity.BaseEntity;

/**
 * Created by cznno
 * Date: 18-1-8
 */
public class PaginationUtil {

    public static BaseEntity fo(BaseEntity entity) throws RuntimeException{
        if (entity.getPage() != null && entity.getRows() != null) {
            PageHelper.startPage(entity.getPage(), entity.getRows());
        }
        throw  new RuntimeException();
    }
}
