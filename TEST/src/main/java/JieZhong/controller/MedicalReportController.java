package JieZhong.controller;

import JieZhong.base.ResponseModel;
import JieZhong.base.Statu;
import JieZhong.entity.MedicalReport;
import JieZhong.service.impl.HospitalAfternoonServiceImpl;
import JieZhong.service.impl.MedicalReportServiceImpl;
import JieZhong.util.CommUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/medicalReport")
public class MedicalReportController {

    @Autowired
    private MedicalReportServiceImpl medicalReportService;


    @Autowired
    private HospitalAfternoonServiceImpl hospitalAfternoonService;




    //体检报告查询
    @RequestMapping("/list")
    public ResponseEntity<ResponseModel<List<MedicalReport>>> list(@RequestBody Map map){
        ResponseModel<List<MedicalReport>> responseModel =new ResponseModel<>();
        List<MedicalReport> list = medicalReportService.getList();
        responseModel.setData(list);
        if(list==null){
            responseModel.setStatus(Statu.NUllSUCCESS);
            responseModel.setMessage("查询成功！！");
        }else {
            responseModel.setStatus(Statu.SUCCESS);
            responseModel.setMessage("查询成功！！");
        }
        return ResponseEntity.ok(responseModel);
    }



    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<ResponseModel<MedicalReport>> insert(@RequestBody Map map){
        ResponseModel<MedicalReport> responseModel = new ResponseModel<>();
        MedicalReport medicalReport =new MedicalReport();
        String userName = map.get("userName").toString();
        String sex = map.get("sex").toString();

        String idcard = map.get("idcard").toString();
        String setmealName = map.get("setmealName").toString();
        String hospitalName = map.get("hospitalName").toString();
        String reportDetail = map.get("reportDetail").toString();
        int id = hospitalAfternoonService.getId(hospitalName);

        //编号  身份证号 体检报告号 报告详细 创建时间
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmm");//设置日期格式
        String timeStr = df.format(new Date());
        String name = CommUtils.toJianPin(userName);//用户名称的简写

        SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");//设置日期格式
        String currentTime = time.format(new Date());//报告创建时间

        medicalReport.setHospitalid(id);
        medicalReport.setIdcard(idcard);
        medicalReport.setReportDetail(reportDetail);
        medicalReport.setReportNumber(timeStr+name);
        medicalReport.setCreatTime(currentTime);

        responseModel.setData(medicalReportService.insert(medicalReport, "MedicalReport", "请勿添加重复的服务！"));
        responseModel.setStatus(Statu.SUCCESS);
        responseModel.setMessage("添加成功！！");
        return ResponseEntity.ok(responseModel);
    }







}
