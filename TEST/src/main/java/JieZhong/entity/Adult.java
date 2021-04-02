package JieZhong.entity;

import java.io.Serializable;
import java.util.Date;

public class Adult implements Serializable {

    private  int adultid;               /**成人编号*/
    private  int director_id;            /**医院id*/
    private String adultname;   		/**名字*/
    private String datebirth;           /**出生日期*/
    private  int sex ;                  /**性别*/
    private String idcard ;              /**身份证号*/
    private  String  phone ;          	/**电话*/
    private int  register_time;           /**预约时间*/
    private int  userid;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    /**用户id*/


    public int getAdultid() {
        return adultid;
    }

    public void setAdultid(int adultid) {
        this.adultid = adultid;
    }

    public int getDirector_id() {
        return director_id;
    }

    public void setDirector_id(int director_id) {
        this.director_id = director_id;
    }

    public String getAdultname() {
        return adultname;
    }

    public void setAdultname(String adultname) {
        this.adultname = adultname;
    }

    public String getDatebirth() {
        return datebirth;
    }

    public void setDatebirth(String datebirth) {
        this.datebirth = datebirth;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getRegister_time() {
        return register_time;
    }

    public void setRegister_time(int register_time) {
        this.register_time = register_time;
    }

    @Override
    public String toString() {
        return "Adult{" +
                "adultid=" + adultid +
                ", director_id=" + director_id +
                ", adultname='" + adultname + '\'' +
                ", datebirth='" + datebirth + '\'' +
                ", sex=" + sex +
                ", idcard='" + idcard + '\'' +
                ", phone='" + phone + '\'' +
                ", register_time='" + register_time + '\'' +
                '}';
    }

    public void setRegister_time(Date date) {
    }
}
