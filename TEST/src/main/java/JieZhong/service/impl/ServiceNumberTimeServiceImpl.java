package JieZhong.service.impl;

import JieZhong.dao.ServiceNumberTimeMapper;
import JieZhong.entity.ServiceNumberTime;
import JieZhong.service.IServiceNumberTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceNumberTimeServiceImpl implements IServiceNumberTimeService {


    @Autowired(required = false)
    private ServiceNumberTimeMapper serviceNumberTimeMapper;


    @Override
    public ServiceNumberTime insert(ServiceNumberTime serviceNumberTime, String... errors) {
        int insert = serviceNumberTimeMapper.insert(serviceNumberTime);
        if(insert>0){
            return serviceNumberTime;
        }
        return null;
    }

    @Override
    public int update(ServiceNumberTime serviceNumberTime, String... errors) {
        return serviceNumberTimeMapper.update(serviceNumberTime);
    }

    @Override
    public int deleteById(int id) {
        return serviceNumberTimeMapper.deleteById(id);
    }

    @Override
    public ServiceNumberTime getById(int id) {
        return serviceNumberTimeMapper.getById(id);
    }

    @Override
    public List<ServiceNumberTime> queryList(int hospital_id) {
        return serviceNumberTimeMapper.queryList(hospital_id);
    }

    @Override
    public  List<ServiceNumberTime> queryCount(int hospital_id) {
        return serviceNumberTimeMapper.queryCount(hospital_id);
    }
}
