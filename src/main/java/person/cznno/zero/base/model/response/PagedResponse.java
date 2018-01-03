package person.cznno.zero.base.model.response;

import lombok.*;

import java.util.List;

/**
 * Created by cznno
 * Date: 18-1-3
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PagedResponse<T> implements Response<T> {

    private Boolean success;
    private String msg;
    private Integer pageNum;
    private Integer pageSize;
    private Long count;
    //数据内容
    private List<T> result;

    @Override
    public String getMsg() {
        return msg;
    }

    @Override
    public void setMsg(String msg) {
        this.msg = msg;
    }

}
