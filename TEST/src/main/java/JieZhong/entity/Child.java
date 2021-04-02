package JieZhong.entity;

import java.io.Serializable;


public class Child implements Serializable {

    private int  childid;
    private int director_id;
    private String childname;  	            /**名字*/
    private String datebirth;               /**出生年月*/
    private String sex;                     /**性别*/
    private String relation;                /**关系*/
    private String datebirtha;              /**预约日期*/
    private String guardianname;           /**监护人*/
    private String  phone;
    private int  userid;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getDatebirtha() {
        return datebirtha;
    }

    public void setDatebirtha(String datebirtha) {
        this.datebirtha = datebirtha;
    }

    /**用户id*/


    public int getDirector_id() {
        return director_id;
    }

    public void setDirector_id(int director_id) {
        this.director_id = director_id;
    }

    /**监护人电话*/




    public int getChildid() {
        return childid;
    }

    public void setChildid(int childid) {
        this.childid = childid;
    }

    public String getChildname() {
        return childname;
    }

    public void setChildname(String childname) {
        this.childname = childname;
    }

    public String getDatebirth() {
        return datebirth;
    }

    public void setDatebirth(String datebirth) {
        this.datebirth = datebirth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getGuardianname() {
        return guardianname;
    }

    public void setGuardianname(String guardianname) {
        this.guardianname = guardianname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
