package JieZhong.dao;

import JieZhong.entity.ServiceAll;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
 public interface ServiceAllMapper {


    @Select({
            "select t1.id,t2.id 'hospitalid',t1.headName,t1.sonName,t1.centerName,t1.headTime from service_all t1 \n" +
                    "\t\tLEFT JOIN \n" +
                    "\t\thospital_afternoon t2\n" +
                    "\t\ton t1.hospitalid =t2.id where t1.hospitalid=#{hospitalid}"
    })
    List<ServiceAll> queryList(Integer hospitalid);


    @Select("select id,hospitalid,headName from service_all where hospitalid=#{hospitalid} GROUP BY headName ")
    List<ServiceAll> getList(@Param("hospitalid") int hospitalid);


    @Select("select id, headName, sonName,centerName,headTime from service_all where hospitalid=#{hospitalid} ")
    List<ServiceAll> getNameList(@Param("hospitalid") int hospitalid);

    @Select("select id, headName, sonName,centerName,headTime" +
            " FROM service_all  where  id = #{id} ")
    ServiceAll getById(@Param("id") int id);


    @Insert({"insert into service_all (hospitalid,headName, sonName,centerName,headTime) " +
            "VALUES (#{hospitalid},#{headName},#{sonName},#{centerName},#{headTime})"})
    int insert(ServiceAll ServiceAll);


    @Update("UPDATE service_all SET hospitalid = #{ServiceAll.hospitalid},headName = #{ServiceAll.headName} " +
            ",sonName = #{ServiceAll.sonName},centerName = #{ServiceAll.centerName},headTime = #{ServiceAll.headTime}  where id= #{ServiceAll.id}")
    int update(@Param("ServiceAll") ServiceAll ServiceAll);


    @Update("delete from service_all where id= #{id} ")
    int deleteById(@Param("id") int id);
}
