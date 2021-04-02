package JieZhong.service;

import JieZhong.entity.HospitalAfternoon;

import java.util.List;

public interface IHospitalAfternoonService {

    List<HospitalAfternoon> getList();

    HospitalAfternoon getById(int id);

    HospitalAfternoon insert(HospitalAfternoon hospitalAfternoon, String... errors);

    int update(HospitalAfternoon hospitalAfternoon, String... errors);

    int deleteById(int id);

    int getId(String hospitalName);

    List<HospitalAfternoon> getNameList();
}
