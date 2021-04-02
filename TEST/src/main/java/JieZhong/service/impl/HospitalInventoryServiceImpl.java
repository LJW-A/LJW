package JieZhong.service.impl;

import JieZhong.dao.HospitalInventoryMapper;
import JieZhong.entity.HospitalInventory;
import JieZhong.service.IhospitalInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalInventoryServiceImpl implements IhospitalInventoryService {

    @Autowired(required = false)
    private HospitalInventoryMapper hospitalInventoryMapper;



    @Override
    public List<HospitalInventory> getList(Integer tag) {
        return hospitalInventoryMapper.getList(tag);
    }
}
