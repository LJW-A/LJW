package JieZhong.entity;

import java.io.Serializable;

public class MedicalSetmeal implements Serializable {

    private  int id;                            /**套餐编号*/
    private  int hospitalid;                    /**医院编号*/
    private  String  setmealName;               /**套餐名称*/


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

    public String getSetmealName() {
        return setmealName;
    }

    public void setSetmealName(String setmealName) {
        this.setmealName = setmealName;
    }

    @Override
    public String toString() {
        return "MedicalSetmeal{" +
                "id=" + id +
                ", hospitalid=" + hospitalid +
                ", setmealName='" + setmealName + '\'' +
                '}';
    }
}
