package JieZhong.controller;


import JieZhong.base.ResponseModel;
import JieZhong.base.Statu;
import JieZhong.entity.ServiceNumberTime;
import JieZhong.service.impl.ServiceNumberTimeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin(origins="*",methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("/serviceNumberTime")
public class ServiceNumberTimeController {

    @Autowired
    private ServiceNumberTimeServiceImpl serviceNumberTimeService;



    //查询医院号源时段
    @RequestMapping("/queryList")
    public ResponseEntity<ResponseModel<List<ServiceNumberTime>>> queryList(@RequestBody ServiceNumberTime serviceNumberTime){
        ResponseModel<List<ServiceNumberTime>> responseModel =new ResponseModel<>();
        List<ServiceNumberTime> list = serviceNumberTimeService.queryList(serviceNumberTime.getHospital_id());
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

    //查询医院两天号源的总条数
    @RequestMapping("/queryCount")
    public ResponseEntity<ResponseModel<List<ServiceNumberTime>>> queryCount(@RequestBody ServiceNumberTime serviceNumberTime){
        ResponseModel responseModel =new ResponseModel();
        List<ServiceNumberTime> snt = serviceNumberTimeService.queryCount(serviceNumberTime.getHospital_id());
        if(snt==null){
            responseModel.setStatus(Statu.ERROR);
            responseModel.setMessage("查询失败！！");
        }else {
            responseModel.setStatus(Statu.SUCCESS);
            responseModel.setMessage("查询成功！！");
        }
        responseModel.setData(snt);
        return ResponseEntity.ok(responseModel);
    }


    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<ResponseModel<ServiceNumberTime>> insert(@RequestBody @Validated ServiceNumberTime serviceNumberTime) throws Exception {
        ResponseModel<ServiceNumberTime> responseModel = new ResponseModel<>();
        responseModel.setData(serviceNumberTimeService.insert(serviceNumberTime, "serviceNumberTime", "请勿添加重复的医院！"));
        responseModel.setStatus(Statu.SUCCESS);
        responseModel.setMessage("添加成功！！");
        return ResponseEntity.ok(responseModel);
    }



    @PostMapping("/edit")
    @ResponseBody
    public ResponseEntity<ResponseModel<Integer>> update(@RequestBody @Validated ServiceNumberTime serviceNumberTime){
        ServiceNumberTime byId = serviceNumberTimeService.getById(serviceNumberTime.getId());

        ResponseModel<Integer> responseModel = new ResponseModel<>();
        responseModel.setData(serviceNumberTimeService.update(byId, "serviceNumberTime", "请勿添加重复的记录！"));
        responseModel.setStatus(Statu.SUCCESS);
        return ResponseEntity.ok(responseModel);
    }

    @RequestMapping("/del")
    @ResponseBody
    public ResponseEntity<ResponseModel<Integer>> deleteById(@RequestBody ServiceNumberTime serviceNumberTime){
        ResponseModel<Integer> responseModel = new ResponseModel<>();
        Integer integer = serviceNumberTimeService.deleteById(serviceNumberTime.getId());
        responseModel.setData(integer);
        if(integer>0){
            responseModel.setStatus(Statu.SUCCESS);
            responseModel.setMessage("删除成功！！");
        }else{
            responseModel.setStatus(Statu.SUCCESS);
            responseModel.setMessage("删除失败！！");
        }
        return ResponseEntity.ok(responseModel);
    }
}
