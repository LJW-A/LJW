package JieZhong.dao;

import JieZhong.entity.MedicalReport;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface MedicalReportMapper {

    @Select("select t1.reportNumber,t1.reportDetail,t1.creatTime,t1.hospitalid,t2.makeType,t2.userName,t2.sex,t2.idcard from medical_report t1\n" +
            "\tLEFT JOIN\n" +
            "\tmedical_make t2\n" +
            " ON\n" +
            "t1.idcard =t2.idcard where t2.makeType=#{makeType} and t1.hospitalid=#{hospitalid}\n")
    List<MedicalReport> getList();


    @Select("select id, hospitalid, idcard,reportNumber,reportDetail,creatTime" +
            " FROM medical_report  where  id = #{id} ")
    MedicalReport getById(@Param("id") int id);


    @Insert({"insert into medical_report (hospitalid, idcard,reportNumber,reportDetail,creatTime) " +
            "VALUES (#{hospitalid},#{idcard},#{reportNumber},#{reportDetail},#{creatTime})"})
    int insert(MedicalReport medicalReport);


    @Update("UPDATE medical_report SET hospitalid = #{medicalReport.hospitalid},idcard = #{medicalReport.idcard} " +
            ",reportNumber = #{medicalReport.reportNumber} ,reportDetail = #{medicalReport.reportDetail},creatTime = #{medicalReport.creatTime} where id= #{medicalReport.id}")
    int update(@Param("medicalReport") MedicalReport medicalReport);



    @Update("delete from medical_report where id= #{id} ")
    int deleteById(@Param("id") int id);
}
