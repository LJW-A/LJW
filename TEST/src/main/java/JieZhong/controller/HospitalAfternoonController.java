package JieZhong.controller;

import JieZhong.base.ResponseModel;
import JieZhong.base.Statu;
import JieZhong.entity.HospitalAfternoon;
import JieZhong.service.ChildService;
import JieZhong.service.impl.HospitalAfternoonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/hospitalafternoon")
@CrossOrigin(origins="*",methods= {RequestMethod.GET,RequestMethod.POST})
public class HospitalAfternoonController {

    @Autowired
    private HospitalAfternoonServiceImpl hospitalAfternoonService;

    @Autowired
    private ChildService chilkdservice;


    @RequestMapping("/list")
    public ResponseEntity<ResponseModel<List<HospitalAfternoon>>> getList() throws Exception {
        ResponseModel responseModel =new ResponseModel();

        //每个唯一区
        List<HospitalAfternoon> list = hospitalAfternoonService.getList();
        //所有医院
        List<HospitalAfternoon> nameList = hospitalAfternoonService.getNameList();
        List lis =new ArrayList();

        for(HospitalAfternoon result:list ) {
            List li =new ArrayList();
            Map  map =new HashMap();
            //所有医院
            for(HospitalAfternoon resultnameList:nameList ) {
                if(resultnameList.getHospital_region().equals(result.getHospital_region())){
                    System.out.println(resultnameList.getHospital_name());
                    li.add(resultnameList.getHospital_name());
                    map.put("hospitalId",result.getId());
                    map.put("hospitalRegion",result.getHospital_region());
                    map.put("hospitalName",li);
                    map.put("hospitalRemake",result.getHospital_remake());
                }
            }
            lis.add(map);
        }

        responseModel.setData(lis);
        responseModel.setStatus(Statu.SUCCESS);
        responseModel.setMessage("查询成功！！");
        return ResponseEntity.ok(responseModel);
    }

    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<ResponseModel<HospitalAfternoon>> insert(@RequestBody @Validated HospitalAfternoon hospitalAfternoon) throws Exception {
        ResponseModel<HospitalAfternoon> responseModel = new ResponseModel<>();
        responseModel.setData(hospitalAfternoonService.insert(hospitalAfternoon, "hospital_afternoon", "请勿添加重复的医院！"));
        responseModel.setStatus(Statu.SUCCESS);
        responseModel.setMessage("添加成功！！");
        return ResponseEntity.ok(responseModel);
    }



    @PostMapping("/edit")
    @ResponseBody
    public ResponseEntity<ResponseModel<Integer>> update(@RequestBody @Validated HospitalAfternoon hospitalAfternoon){
        HospitalAfternoon byId = hospitalAfternoonService.getById(hospitalAfternoon.getId());
        byId.setHospital_region("运城");
        byId.setHospital_name("死去把你");
        ResponseModel<Integer> responseModel = new ResponseModel<>();
        responseModel.setData(hospitalAfternoonService.update(byId, "hospital_afternoon", "请勿添加重复的记录！"));
        responseModel.setStatus(Statu.SUCCESS);
        return ResponseEntity.ok(responseModel);
    }

    @RequestMapping("/del")
    @ResponseBody
    public ResponseEntity<ResponseModel<Integer>> deleteById(@RequestBody HospitalAfternoon hospitalAfternoon){
        ResponseModel<Integer> responseModel = new ResponseModel<>();
        Integer integer = hospitalAfternoonService.deleteById(hospitalAfternoon.getId());
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
