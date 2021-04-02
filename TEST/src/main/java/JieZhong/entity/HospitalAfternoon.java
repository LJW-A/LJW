package JieZhong.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
public class HospitalAfternoon {

    @JsonInclude(JsonInclude.Include.NON_DEFAULT )
    private Integer id;

    //医院链接地址
    @JsonInclude(JsonInclude.Include.NON_NULL )
    private String hospital_region;

    //医院名称
    @JsonInclude(JsonInclude.Include.NON_NULL )
    private String hospital_name;

    //医院信息维护
    @JsonInclude(JsonInclude.Include.NON_NULL )
    private String hospital_remake;



}
