package JieZhong.base;

import lombok.Data;

@Data
public class ResponseModel<T> {
    private T data;

    private int status;

    private String message;

    private long recordsTotal = 0;
}
