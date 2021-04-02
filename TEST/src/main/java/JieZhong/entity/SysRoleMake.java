package JieZhong.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

@Data
public class SysRoleMake implements Serializable {

    @JsonInclude(JsonInclude.Include.NON_DEFAULT )
    private int  makeid ;

    @JsonInclude(JsonInclude.Include.NON_DEFAULT )
    private int  hospital_id ;                   /**医院ID*/
    @JsonInclude(JsonInclude.Include.NON_NULL )
    private String   make_date ;                   /**预约时间*/

    @JsonInclude(JsonInclude.Include.NON_NULL )
    private String make_time;

    @JsonInclude(JsonInclude.Include.NON_NULL )
    private String adultname;                   /**成人名称*/

    @JsonInclude(JsonInclude.Include.NON_NULL )
    private String hospital_name;               /**医院名称*/

    @JsonInclude(JsonInclude.Include.NON_NULL )
    private String phone;

    @JsonInclude(JsonInclude.Include.NON_NULL )
    private String relation;


    @JsonInclude(JsonInclude.Include.NON_NULL )
    private int adultid;

    @JsonInclude(JsonInclude.Include.NON_NULL )
    private int logId;

    @JsonInclude(JsonInclude.Include.NON_NULL )
    private String datebirth;

}
