package JieZhong.service.impl;

import JieZhong.dao.ServiceTableMapper;
import JieZhong.entity.ServiceTable;
import JieZhong.service.IServiceTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTableServiceImpl implements IServiceTableService {

    @Autowired
    private ServiceTableMapper serviceTableMapper;


    @Override
    public List<ServiceTable> getList() {
        return serviceTableMapper.getList();
    }

    @Override
    public ServiceTable insert(ServiceTable serviceTable,String... errors) {
        int insert = serviceTableMapper.insert(serviceTable);
        if(insert>0){
            return serviceTable;
        }else {
            return null;
        }

    }

    @Override
    public int update(ServiceTable serviceTable,String... errors) {
        return serviceTableMapper.update(serviceTable);
    }

    @Override
    public int deleteById(int id) {
        return serviceTableMapper.deleteById(id);
    }

    @Override
    public ServiceTable getById(int id) {
        return serviceTableMapper.getById(id);
    }
}

