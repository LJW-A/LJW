package JieZhong.entity;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
public class HospitalCategory {

    @JsonInclude(JsonInclude.Include.NON_DEFAULT )
    private int category_id;//医院类别编号

    @JsonInclude(JsonInclude.Include.NON_DEFAULT )
    private int hospital_id;

    @JsonInclude(JsonInclude.Include.NON_NULL )
    private  String category_name;

    @JsonInclude(JsonInclude.Include.NON_NULL )
    private  String category_remake;

}
