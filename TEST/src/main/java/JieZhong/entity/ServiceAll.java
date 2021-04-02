package JieZhong.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

@Data
public class ServiceAll implements Serializable {

    @JsonInclude(JsonInclude.Include.NON_DEFAULT )
    private int  id ;               //编号

    @JsonInclude(JsonInclude.Include.NON_DEFAULT )
    private int hospitalid;       //医院id

    @JsonInclude(JsonInclude.Include.NON_NULL )
    private String headName ;    //头名称

    @JsonInclude(JsonInclude.Include.NON_NULL )
    private String sonName;    //子名称

    @JsonInclude(JsonInclude.Include.NON_NULL )
    private String centerName ;    //疫苗接种
    @JsonInclude(JsonInclude.Include.NON_NULL )
    private String headTime ;      //放号时间



}
