package JieZhong.dao;

import JieZhong.entity.ServiceService;
import org.apache.ibatis.annotations.*;

@Mapper
public interface ServiceServiceMapper {
    //增
    @Insert({
            "insert into service_service(service_id,hospital_id,service_name,team_name) " +
                    "values (#{service_id},#{hospital_id},#{service_name},#{team_name})"
    })
    int insertService_service(ServiceService serviceService);

    //修改
    @Update("update set service_id=#{service_id},hospital_id=#{hospital_id}," +
            "service_name=#{service_name} from service_service")
    public int update(ServiceService serviceService);

    //删除
    @Delete("delete from service_service where service_id=#{service_id}")
    public void deleteEmpById(int service_id);

    //查
    @Select("select * from service_service where service_id=#{service_id}")
    public ServiceService findService(int service_id);

}
