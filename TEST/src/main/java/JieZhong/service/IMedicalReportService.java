package JieZhong.service;

import JieZhong.entity.MedicalReport;

import java.util.List;

public interface IMedicalReportService {

    List<MedicalReport> getList();


    MedicalReport getById(int id);


    MedicalReport insert(MedicalReport medicalReport, String... errror);


    int update(MedicalReport medicalReport, String... errror);



    int deleteById(int id);
}
