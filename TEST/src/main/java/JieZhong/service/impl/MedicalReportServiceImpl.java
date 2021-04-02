package JieZhong.service.impl;

import JieZhong.dao.MedicalReportMapper;
import JieZhong.entity.MedicalReport;
import JieZhong.service.IMedicalReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalReportServiceImpl implements IMedicalReportService {

    @Autowired(required = false)
    private MedicalReportMapper medicalReportMapper;


    @Override
    public List<MedicalReport> getList() {
        return medicalReportMapper.getList();
    }

    @Override
    public MedicalReport getById(int id) {
        return medicalReportMapper.getById(id);
    }

    @Override
    public MedicalReport insert(MedicalReport medicalReport, String... errror) {
        int insert = medicalReportMapper.insert(medicalReport);
        if(insert>0){
            return medicalReport;
        }
        return null;
    }

    @Override
    public int update(MedicalReport medicalReport, String... errror) {
        return medicalReportMapper.update(medicalReport);
    }

    @Override
    public int deleteById(int id) {
        return medicalReportMapper.deleteById(id);
    }
}
