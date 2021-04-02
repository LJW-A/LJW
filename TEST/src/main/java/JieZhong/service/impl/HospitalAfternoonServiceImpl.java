package JieZhong.service.impl;

import JieZhong.dao.HospitalAfternoonMapper;
import JieZhong.entity.HospitalAfternoon;
import JieZhong.service.IHospitalAfternoonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalAfternoonServiceImpl implements IHospitalAfternoonService {


    @Autowired(required = false)
    private HospitalAfternoonMapper hospitalAfternoonMapper;


    @Override
    public List<HospitalAfternoon> getList() {
        return hospitalAfternoonMapper.getList();
    }


    @Override
    public HospitalAfternoon getById(int id) {
        return hospitalAfternoonMapper.getById(id);
    }


    @Override
    public HospitalAfternoon insert(HospitalAfternoon hospitalAfternoon, String... errors) {
        int insert = hospitalAfternoonMapper.insert(hospitalAfternoon);
        if(insert>0){
            return hospitalAfternoon;
        }
        return null;
    }

    @Override
    public int update(HospitalAfternoon hospitalAfternoon, String... errors) {
        int update = hospitalAfternoonMapper.update(hospitalAfternoon);
        if(update>0){
            return update;
        }
        return 0;
    }


    @Override
    public int deleteById(int id) {
        int deleteById = hospitalAfternoonMapper.deleteById(id);
        if(deleteById>0){
            return deleteById;
        }
        return 0;
    }

    @Override
    public int getId(String hospitalName) {
        return hospitalAfternoonMapper.getId(hospitalName);
    }



    @Override
    public List<HospitalAfternoon> getNameList() {
        return hospitalAfternoonMapper.getNameList();
    }
}
