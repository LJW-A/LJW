package JieZhong.service;

import JieZhong.entity.ServiceNumberTime;

import java.util.List;

public interface IServiceNumberTimeService {

    //增
    ServiceNumberTime insert(ServiceNumberTime serviceNumberTime, String... errors);

    //修改
    int update(ServiceNumberTime serviceNumberTime, String... errors);

    //删除
    int deleteById(int id);

    ServiceNumberTime getById(int id);


    List<ServiceNumberTime> queryList(int hospital_id);

    List<ServiceNumberTime> queryCount(int hospital_id);
}
