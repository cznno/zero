package person.cznno.zero.base.model.response;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * Created by cznno
 * Date: 18-1-3
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({"success", "msg", "page", "rows", "count", "data"})
public class PagedResponse implements Response {

    private Boolean success;
    private String msg;
    private Integer page;
    private Integer rows;
    private Long count;
    //数据内容
    private List<Object> data;

    @Override
    public String getMsg() {
        return msg;
    }

    @Override
    public void setMsg(String msg) {
        this.msg = msg;
    }
}
