package JieZhong.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class IdentityAudit implements Serializable {



    private int  id ;                  /**审核编号*/
    private int childid ;                   /**儿童编号*/
    private int userid;                      /**用户id*/
    private String imgurla;                /**图片地址*/
    private String imgurlb;                /**图片地址*/
    private String audit_time;           /**审核时间*/
    private int tag;                   /**(0)审核通过 (1)审核未通过*/
    private String datebirtha;          /**预约时间*/
    private String phone;


}
