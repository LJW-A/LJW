package JieZhong.service;

import JieZhong.entity.ServiceTable;

import java.util.List;

public interface IServiceTableService {

     //查
     List<ServiceTable> getList();

     //增
     ServiceTable insert(ServiceTable serviceTable, String... errors);

     //修改
     int update(ServiceTable serviceTable, String... errors);

     //删除
     int deleteById(int id);

     //查
     ServiceTable getById(int id);

}
