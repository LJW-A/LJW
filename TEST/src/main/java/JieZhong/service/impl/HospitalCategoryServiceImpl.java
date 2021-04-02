package JieZhong.service.impl;

import JieZhong.dao.HospitalCategoryMapper;
import JieZhong.entity.HospitalCategory;
import JieZhong.service.IhospitalCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalCategoryServiceImpl implements IhospitalCategoryService {

    @Autowired(required = false)
    private HospitalCategoryMapper hospitalCategoryMapper;


    @Override
    public List<HospitalCategory> getList(int hospitalid) {
        return hospitalCategoryMapper.getList(hospitalid);
    }

    @Override
    public HospitalCategory getById(int id) {
        return hospitalCategoryMapper.getById(id);
    }

    @Override
    public HospitalCategory insert(HospitalCategory hospitalCategory, String... errors) {
        int insert = hospitalCategoryMapper.insert(hospitalCategory);
        if(insert>0){
            return hospitalCategory;
        }
        return null;
    }

    @Override
    public int update(HospitalCategory hospitalCategory, String... errors) {
        return hospitalCategoryMapper.update(hospitalCategory);
    }

    @Override
    public int deleteById(int id) {
        return hospitalCategoryMapper.deleteById(id);
    }


    @Override
    public List<HospitalCategory> getNameList() {
        return hospitalCategoryMapper.getNameList();
    }
}
