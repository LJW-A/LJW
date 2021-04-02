package JieZhong.entity;

import lombok.Data;

import java.io.Serializable;


@Data
public class ServiceService implements Serializable {
    //预约ID
    private int service_id;
    //医院ID
    private int hospital_id;
    //预约名称
    private String service_name;
    //项目名称
    private String team_name;
}
