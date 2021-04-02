package JieZhong.entity;

import java.io.Serializable;

public class ChildIguide implements Serializable {

    private int    iguide_id;
    private String moon_age;            /**月龄*/
    private String vacuna_name ;        /**疫苗名称*/
    private String inoculum_size ;      /**接种次数*/
    private String bacterin_sort ;       /**疫苗类型*/
    private int  tag;                    /**标识符*/
    private int  sort ;                  /**排序*/


    public int getIguide_id() {
        return iguide_id;
    }

    public void setIguide_id(int iguide_id) {
        this.iguide_id = iguide_id;
    }

    public String getMoon_age() {
        return moon_age;
    }

    public void setMoon_age(String moon_age) {
        this.moon_age = moon_age;
    }

    public String getVacuna_name() {
        return vacuna_name;
    }

    public void setVacuna_name(String vacuna_name) {
        this.vacuna_name = vacuna_name;
    }

    public String getInoculum_size() {
        return inoculum_size;
    }

    public void setInoculum_size(String inoculum_size) {
        this.inoculum_size = inoculum_size;
    }

    public String getBacterin_sort() {
        return bacterin_sort;
    }

    public void setBacterin_sort(String bacterin_sort) {
        this.bacterin_sort = bacterin_sort;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }
}
