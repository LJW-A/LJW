package JieZhong.dao;

import JieZhong.entity.HospitalCategory;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface HospitalCategoryMapper {
//    select hospital_id,category_name,category_remake from Hospital_category
    @Select(" select t2.hospital_name,t1.hospital_id,t1.category_name,t1.category_remake  from hospital_category t1 LEFT JOIN hospital_afternoon t2 on t1.hospital_id=t2.id where t1.hospital_id=#{hospitalId}")
    List<HospitalCategory> getList(@Param("hospitalId") int hospitalId);


    @Select("select hospital_id,category_name,category_remake from Hospital_category ")
    List<HospitalCategory> getNameList();

    @Select("select id, hospital_id，category_name,category_remake" +
            " FROM Hospital_category  where  category_id = #{id} ")
    HospitalCategory getById(@Param("id") int id);

    @Select("select IFNULL(sum(id),0)" +
            " FROM Hospital_category  where  category_name = #{categoryName} ")
    int getId(@Param("categoryName") String categoryName);


    @Insert({"insert into Hospital_category ( hospital_id，category_name,category_remake) " +
            "VALUES (#{hospital_id},#{category_name},#{category_remake})"})
    int insert(HospitalCategory hospitalCategory);


    @Update("UPDATE Hospital_category SET hospital_id = #{HospitalCategory.hospital_id},category_name = #{HospitalCategory.category_name} " +
            ",category_remake = #{HospitalCategory.category_remake}  where category_id= #{HospitalCategory.id}")
    int update(@Param("hospitalCategory") HospitalCategory hospitalCategory);


    @Update("delete from Hospital_category where category_id= #{id} ")
    int deleteById(@Param("id") int id);
}
