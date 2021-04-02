package JieZhong.dao;

import JieZhong.entity.SysRoleMake;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface SysRoleMakeMapper {


    //成人可使用预约
    @Select("select t5.makeid,t5.hospitalid,t5.adultid,t5.make_date,t5.userid, t5.make_time,t5.hospital_name,t5.adultname,t5.datebirth from \n" +
            "(select t3.makeid,t3.hospitalid,t3.adultid,t3.make_date,t3.userid, t3.make_time,t3.hospital_name,t4.adultname,t4.datebirth,t4.director_id  from\n" +
            "(select t1.id 'makeid', t2.id 'hospitalid' ,t1.userid,t1.adultid,t1.make_date, t1.make_time,t2.hospital_name from sys_role_make t1\n" +
            "\t\tLEFT JOIN\n" +
            "\t\thospital_afternoon t2\n" +
            "\t\tON\n" +
            "\t\tt1.hostapl_id=t2.id) t3\n" +
            "\t\tLEFT JOIN\n" +
            "\t\tadult t4\n" +
            "\t\tON\n" +
            "\t\tt3.hospitalid=t4.director_id) t5 LEFT JOIN users t6 on t5.userid=t6.id where t5.hospitalid=#{hospitalid}")
    //传 医院id 用户id
    List<SysRoleMake> QueryList(@Param("hospitalid") int id);



    @Select("select  id, hostapl_id,make_date,make_type" +
            " FROM sys_role_make  where  id = #{id} ")
    List<SysRoleMake>  getById(@Param("id") int id);

    @Insert({"insert into sys_role_make (hostapl_id,make_date,make_type) " +
            "VALUES (#{hostapl_id},#{make_date},#{make_type})"})
    int insert(SysRoleMake sysRoleMake);


    @Update("UPDATE sys_role_make SET hostapl_id = #{sysRoleMake.hostapl_id},make_date = #{sysRoleMake.make_date} ,make_type = #{sysRoleMake.make_type}" +
            " where id= #{sysRoleMake.id}")
    int update(@Param("sysRoleMake") SysRoleMake sysRoleMake);


    @Update("delete from sys_role_make  where id= #{id} ")
    int deleteById(@Param("id") int id);
}
