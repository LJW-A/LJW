package JieZhong.service.impl;

import JieZhong.entity.ServiceAll;
import JieZhong.service.IServiceAllService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IServiceAllImpl implements IServiceAllService {


    @Autowired
    private JieZhong.dao.ServiceAllMapper ServiceAllMapper;


    @Override
    public List<ServiceAll> queryList(Integer hospitalid) {
        return ServiceAllMapper.queryList(hospitalid);
    }

    @Override
    public List<ServiceAll> getList(int hospitalid) {
        return ServiceAllMapper.getList(hospitalid);
    }

    @Override
    public List<ServiceAll> getNameList(int hospitalid) {
        return ServiceAllMapper.getNameList(hospitalid);
    }

    @Override
    public ServiceAll getById(int id) {
        return ServiceAllMapper.getById(id);
    }

    @Override
    public ServiceAll insert(ServiceAll ServiceAll, String... errors) {
        int insert = ServiceAllMapper.insert(ServiceAll);
        if(insert>0){
            return ServiceAll;
        }
        return null;
    }

    @Override
    public int update(ServiceAll ServiceAll, String... errors) {
        return ServiceAllMapper.update(ServiceAll);
    }

    @Override
    public int deleteById(int id) {
        return ServiceAllMapper.deleteById(id);
    }
}
