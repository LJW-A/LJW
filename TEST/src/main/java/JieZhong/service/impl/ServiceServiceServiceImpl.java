package JieZhong.service.impl;

import JieZhong.dao.ServiceServiceMapper;
import JieZhong.entity.ServiceService;
import JieZhong.service.ServiceServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceServiceServiceImpl implements ServiceServiceService {

    @Autowired
    private ServiceServiceMapper serviceServiceMapper;

    @Override
    public int addserviceService(ServiceService serviceService) {
        return serviceServiceMapper.insertService_service(serviceService);
    }

    @Override
    public int deleteserviceService(ServiceService serviceService) {
        return 0;
    }

    @Override
    public int updateserviceService(ServiceService serviceService) {
        return 0;
    }

    @Override
    public int findserviceService(ServiceService serviceService) {
        return 0;
    }


    public int queryList(int service_id) {
        return 0;
    }
}
