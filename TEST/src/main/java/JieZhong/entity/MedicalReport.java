package JieZhong.entity;

import lombok.Data;

@Data
public class MedicalReport {

    private  int id;

    private  int hospitalid;//医院编号

    private String idcard;//身份证号

    private String reportNumber;//体检报告号

    private String reportDetail;//报告详情

    private String creatTime;//创建时间

    private int userid;  //用户id

    private String username;  //用户名字


}
