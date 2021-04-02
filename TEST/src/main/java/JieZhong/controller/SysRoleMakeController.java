package JieZhong.controller;

import JieZhong.base.ResponseModel;
import JieZhong.base.Statu;
import JieZhong.entity.SysRoleMake;
import JieZhong.service.impl.HospitalAfternoonServiceImpl;
import JieZhong.service.impl.SysRoleMakeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/sysRoleMake")
@CrossOrigin(origins="*",methods= {RequestMethod.GET,RequestMethod.POST})
public class SysRoleMakeController {

    
    @Autowired
    private SysRoleMakeServiceImpl sysRoleMakeService;


    @Autowired
    private HospitalAfternoonServiceImpl hospitalAfternoonService;



    //预约
    @RequestMapping("/list")
//    @RequestBody SysRoleMake sysRoleMake
    public ResponseEntity<ResponseModel<List<SysRoleMake>>> childList(@RequestBody SysRoleMake sysRoleMake){
        ResponseModel<List<SysRoleMake>> responseModel =new ResponseModel<>();
        int id = hospitalAfternoonService.getId(sysRoleMake.getHospital_name());
        if(id==0){
            responseModel.setStatus(Statu.NUllSUCCESS);
            responseModel.setMessage("没有该医院信息！！");
            return ResponseEntity.ok(responseModel);
        }
        List<SysRoleMake> list = sysRoleMakeService.QueryList(id);
        responseModel.setData(list);
        if(list.size()==0){
            responseModel.setStatus(Statu.NUllSUCCESS);
            responseModel.setMessage("查询失败！！");
        }else {
            responseModel.setStatus(Statu.SUCCESS);
            responseModel.setMessage("查询成功！！");
        }
        return ResponseEntity.ok(responseModel);
    }




    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<ResponseModel<SysRoleMake>> insert(@RequestBody @Validated SysRoleMake sysRoleMake) throws Exception {
        ResponseModel<SysRoleMake> responseModel = new ResponseModel<>();
        responseModel.setData(sysRoleMakeService.insert(sysRoleMake, "SysRoleMake", "请勿添加重复的医院！"));
        responseModel.setStatus(Statu.SUCCESS);
        responseModel.setMessage("添加成功！！");
        return ResponseEntity.ok(responseModel);
    }



    @PostMapping("/edit")
    @ResponseBody
    public ResponseEntity<ResponseModel<Integer>> update(@RequestBody @Validated SysRoleMake sysRoleMake){
        List<SysRoleMake> byId = sysRoleMakeService.getById(sysRoleMake.getMakeid());

        ResponseModel<Integer> responseModel = new ResponseModel<>();
        responseModel.setData(sysRoleMakeService.update(sysRoleMake, "SysRoleMake", "请勿添加重复的记录！"));
        responseModel.setStatus(Statu.SUCCESS);
        return ResponseEntity.ok(responseModel);
    }


    @RequestMapping("/del")
    @ResponseBody
    public ResponseEntity<ResponseModel<Integer>> deleteById(@RequestBody SysRoleMake sysRoleMake){
        ResponseModel<Integer> responseModel = new ResponseModel<>();
        Integer integer = sysRoleMakeService.deleteById(sysRoleMake.getMakeid());
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
