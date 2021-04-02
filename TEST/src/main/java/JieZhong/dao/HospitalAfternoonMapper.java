package JieZhong.dao;

import JieZhong.entity.HospitalAfternoon;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface HospitalAfternoonMapper {

    @Select("select id, hospital_region,hospital_remake from hospital_afternoon  GROUP BY hospital_region")
    List<HospitalAfternoon> getList();


    @Select("select id, hospital_region, hospital_name from hospital_afternoon ")
    List<HospitalAfternoon> getNameList();

    @Select("select id, hospital_region, hospital_name,hospital_remake" +
            " FROM hospital_afternoon  where  id = #{id} ")
    HospitalAfternoon getById(@Param("id") int id);

    @Select("select IFNULL(sum(id),0)" +
            " FROM hospital_afternoon  where  hospital_name = #{hospitalName} ")
    int getId(@Param("hospitalName") String hospitalName);


    @Insert({"insert into hospital_afternoon (hospital_region, hospital_name,hospital_remake) " +
            "VALUES (#{hospitalRegion},#{hospitalName},#{hospitalRemake})"})
    int insert(HospitalAfternoon hospitalAfternoon);


    @Update("UPDATE hospital_afternoon SET hospital_region = #{hospitalAfternoon.hospitalRegion},hospital_name = #{hospitalAfternoon.hospitalName} " +
            ",hospital_remake = #{hospitalAfternoon.hospitalRemake}  where id= #{hospitalAfternoon.id}")
    int update(@Param("hospitalAfternoon") HospitalAfternoon hospitalAfternoon);


    @Update("delete from hospital_afternoon where id= #{id} ")
    int deleteById(@Param("id") int id);
}
