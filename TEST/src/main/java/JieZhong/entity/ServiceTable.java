package JieZhong.entity;

import lombok.Data;

@Data

public class ServiceTable {
    //客服编号
    private int id;
    //医院编号
    private int hospital_id;
    //链接地址
    private String information;
    //工作时间
    private String work_time;
    //备注信息
    private String remark;


}
