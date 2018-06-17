package person.cznno.zero.base.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 基本返回消息
 * Created by cznno
 * Date: 17-12-28
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"success", "msg", "data"})
public class BaseResponse<T> implements Response {

    private Boolean success;
    private String msg;
    private T data;
}