package JieZhong.entity;


import lombok.Data;

import java.io.Serializable;

@Data
public class HospitalInventory implements Serializable {


    //库存编号
    private Integer id;

    //库存数量
    private Integer number;

    //医院编号
    private Integer hospitalId;

    //疫苗编号
    private Integer vaccineId;

    //库存更新时间
    private String immuneTime;

    //免疫 非免疫标识
    private int tag;
    private String  hospital_region;      /**疫苗编号*/
    private String hospital_name;         /**疫苗名称*/
    private String hospital_remake;          /**医院维护信息*/
    private int immuneid;
    private String iname;           /**名字*/
    private String fullname;          /**全名*/
    private String costsort;           /**费用类别*/
    private String domestic;         /**进出口药品*/
    private String imeffect;          /**疫苗作用*/
    private String taboo;               /**禁忌*/
    private String uneffect;         /**不良反应*/
    private String mnattention;   //注意事项
    private int sort; //排序'
}
