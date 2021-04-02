package JieZhong.service;

import JieZhong.entity.HospitalCategory;

import java.util.List;

public interface IhospitalCategoryService {

    List<HospitalCategory> getList(int hospitalid);

    HospitalCategory getById(int id);

    HospitalCategory insert(HospitalCategory hospitalCategory, String... errors);

    int update(HospitalCategory hospitalCategory, String... errors);

    int deleteById(int id);

    List<HospitalCategory> getNameList();
}
