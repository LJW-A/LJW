package JieZhong.entity;

import java.io.Serializable;

public class ServiceIguide implements Serializable {


    private int id;                                     /**客服编号*/
    private String  problem_name;                       /**问题名称*/
    private int hospital_id;
    private String  problem_catalog;                    /** 问题目录*/
    private String  information;                         /**详情信息*/
    private int     rank;                                  /**排序*/


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProblem_name() {
        return problem_name;
    }

    public void setProblem_name(String problem_name) {
        this.problem_name = problem_name;
    }

    public int getHospital_id() {
        return hospital_id;
    }

    public void setHospital_id(int hospital_id) {
        this.hospital_id = hospital_id;
    }

    public String getProblem_catalog() {
        return problem_catalog;
    }

    public void setProblem_catalog(String problem_catalog) {
        this.problem_catalog = problem_catalog;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "ServiceIguide{" +
                "id=" + id +
                ", problem_name='" + problem_name + '\'' +
                ", problem_catalog='" + problem_catalog + '\'' +
                ", information='" + information + '\'' +
                ", rank=" + rank +
                '}';
    }
}
