package JieZhong.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Immune implements Serializable {

   private Integer immuneid;
   private String  iname;       /**疫苗简称*/
    private String fullname;    /**疫苗全名*/
    private String costsort;    /**费用类别*/
    private String domestic;    /**进出口药品*/
    private String imeffect;    /**疫苗作用*/
    private String taboo;       /**禁忌*/
    private String uneffect;    /**不良反应*/
    private String mnattention; /**注意事项*/
    private Integer  tag;       /**标识符*/
    private Integer  sort;      /**排序*/
    /**医院库存表*/
    private HospitalInventory hospitalInventory;
}
