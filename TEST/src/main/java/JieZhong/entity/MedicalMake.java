package JieZhong.entity;

import java.io.Serializable;

public class MedicalMake implements Serializable {

    private  int id;                            /**体检编号*/
    private  int hospitalid ;                   /**医院编号*/
    private String userName ;                   /**用户姓名*/
    private  int sex ;                          /**性别*/
    private  int age ;                          /**年龄*/
    private String idcard ;                     /**身份证号*/
    private String setmealName;                 /**套餐名称*/
    private String medicalTime;                 /**体检日期*/
    private  int makeType;                      /**预约状态 0(未完成) 1(已完成)*/

    private  int userid;


    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHospitalid() {
        return hospitalid;
    }

    public void setHospitalid(int hospitalid) {
        this.hospitalid = hospitalid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getSetmealName() {
        return setmealName;
    }

    public void setSetmealName(String setmealName) {
        this.setmealName = setmealName;
    }

    public String getMedicalTime() {
        return medicalTime;
    }

    public void setMedicalTime(String medicalTime) {
        this.medicalTime = medicalTime;
    }

    public int getMakeType() {
        return makeType;
    }

    public void setMakeType(int makeType) {
        this.makeType = makeType;
    }

    @Override
    public String toString() {
        return "MedicalMake{" +
                "id=" + id +
                ", hospitalid=" + hospitalid +
                ", userName='" + userName + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", idcard='" + idcard + '\'' +
                ", setmealName='" + setmealName + '\'' +
                ", medicalTime='" + medicalTime + '\'' +
                ", makeType=" + makeType +
                '}';
    }
}
