package JieZhong.dao;

import JieZhong.entity.ServiceNumberTime;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ServiceNumberTimeMapper {
    //增
    @Insert("insert into service_number_time(hospital_id,dateLine,date_time,start_time,end_time,all_number)" +
            "values (#{hospital_id},#{dateLine},#{date_time},#{start_time},#{end_time},#{all_number})")
    int insert(ServiceNumberTime serviceNumberTime);

    //修改
    @Update("update service_number_time set  hospital_id=#{serviceNumberTime.hospital_id},dateLine=#{serviceNumberTime.dateLine}," +
            "date_time=#{serviceNumberTime.date_time},start_time=#{serviceNumberTime.start_time},end_time=#{serviceNumberTime.end_time},all_number=#{serviceNumberTime.all_number}")
     int update(@Param("serviceNumberTime") ServiceNumberTime serviceNumberTime);

    //删除
    @Delete("delete from service_number_time where id=#{id}")
     int deleteById(int id);

    //查
    @Select("select * from service_number_time where id=#{id}")
    ServiceNumberTime getById(int id);


    //查询医院号源时段
    @Select("select * from\n" +
            "(select t1.id, t1.hospital_id, t1.dateline,t1.date_time,t1.start_time,t1.end_time,t2.hospital_name,t1.all_number from service_number_time t1 \n" +
            "\tLEFT JOIN\n" +
            "\thospital_afternoon t2\n" +
            "\n" +
            "on t1. hospital_id =t2.id) t3  where hospital_id=#{hospital_id} and t3.dateline= (select DATE_SUB(curdate(),INTERVAL 0 DAY))  or t3.dateline= (select DATE_SUB(curdate(),INTERVAL -1 DAY))")
    List<ServiceNumberTime>  queryList(int hospital_id);


    //查询医院号源时段的总条数
    @Select("select t3.dateline,sum(t3.all_number) 'all_number' from\n" +
            "(select t1.id, t1.hospital_id, t1.dateline,t1.date_time,t1.start_time,t1.end_time,t2.hospital_name,t1.all_number from service_number_time t1 \n" +
            "\tLEFT JOIN\n" +
            "\thospital_afternoon t2\n" +
            "\n" +
            "on t1. hospital_id =t2.id) t3  where hospital_id=#{hospital_id} and t3.dateline= (select DATE_SUB(curdate(),INTERVAL 0 DAY)) or t3.dateline=(select DATE_SUB(curdate(),INTERVAL -1 DAY))\n" +
            " GROUP BY t3.dateline ")
    List<ServiceNumberTime> queryCount(int hospital_id);
}
