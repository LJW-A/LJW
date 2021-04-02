package JieZhong.service;

import JieZhong.entity.ServiceAll;

import java.util.List;

public interface IServiceAllService {


    List<ServiceAll> queryList(Integer hospitalid);


    List<ServiceAll> getList(int hospitalid);


    List<ServiceAll> getNameList(int hospitalid);

    ServiceAll getById(int id);


    ServiceAll insert(ServiceAll ServiceAll, String... errors);


    int update(ServiceAll ServiceAll, String... errors);


    int deleteById(int id);
}
