package JieZhong.dao;


import JieZhong.entity.ServiceTable;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ServiceTableMapper {


    //查
    @Select("select id,hospital_id,information,work_time,remark from service_table")
    List<ServiceTable> getList();
    //增
    @Insert({
            "insert into service_table(hospital_id,information,work_time,remark)",
            "values (#{hospital_id},#{information},#{work_time},#{remark})"
    }) int insert(ServiceTable serviceTable);

    //修改
    @Update("update  service_table set service_table hospital_id=#{serviceTable.hospital_id}," +
            "information=#{serviceTable.information},work_time=#{serviceTable.work_time},remark=#{serviceTable.remark}")
     int update(@Param("serviceTable") ServiceTable serviceTable);

    //删除
    @Delete("delete from service_table where id=#{id}")
     int deleteById(int id);

    //查
    @Select("select * from service_table where id=#{id}")
    ServiceTable getById(int id);
}
