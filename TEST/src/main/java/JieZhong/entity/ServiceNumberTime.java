package JieZhong.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;


@Data
public class ServiceNumberTime implements Serializable {

//    Include.ALWAYS 属性都序列化
//    Include.NON_DEFAULT 属性为默认值不序列化
//    Include.NON_EMPTY 属性为 空（""） 或者为 NULL 都不序列化
//    Include.NON_NULL 属性为NULL 不序列化
    //号源ID
    @JsonInclude(JsonInclude.Include.NON_DEFAULT )
    private int id;
    //医院ID
    @JsonInclude(JsonInclude.Include.NON_DEFAULT )
    private int hospital_id;
    //日期
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String dateline;
    //时段
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String date_time;
    //开始时间
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String start_time;
    //结束时间
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String end_time;
    //总号源
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private int all_number;

    //医院名称
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String hospital_name;



}
