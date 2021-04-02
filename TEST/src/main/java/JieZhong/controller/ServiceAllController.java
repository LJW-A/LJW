package JieZhong.controller;


import JieZhong.base.ResponseModel;
import JieZhong.base.Statu;
import JieZhong.entity.HospitalAfternoon;
import JieZhong.entity.ServiceAll;
import JieZhong.service.IServiceAllService;
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
@RequestMapping("/serviceAll")
@CrossOrigin(origins="*",methods= {RequestMethod.GET,RequestMethod.POST})
public class ServiceAllController {


    @Autowired
    private IServiceAllService serviceAllService;

    @Autowired
    private HospitalAfternoonServiceImpl hospitalAfternoonService;


    @RequestMapping("/list")
    @ResponseBody
    public ResponseEntity<ResponseModel<List<ServiceAll>>> getList(@RequestBody HospitalAfternoon hospitalAfternoon) throws Exception {
        ResponseModel responseModel =new ResponseModel();
        if(("").equals(hospitalAfternoon.getHospital_name())){
            responseModel.setStatus(Statu.NUllSUCCESS);
            responseModel.setMessage("医院编号不能为空！！！");
            return ResponseEntity.ok(responseModel);
        }
        int id = hospitalAfternoonService.getId(hospitalAfternoon.getHospital_name());
        //唯一的疫苗类别医院
        List<ServiceAll> list = serviceAllService.getList(id);
        //所有疫苗子名称
        List<ServiceAll> nameList = serviceAllService.getNameList(id);
        List lis =new ArrayList();

        for(ServiceAll result:list ) {
            List li =new ArrayList();
            Map map =new HashMap();
            //所有医院
            for(ServiceAll resultnameList:nameList ) {
                if(resultnameList.getHeadName().equals(result.getHeadName())){
                    System.out.println(resultnameList.getHeadName());
                    li.add(resultnameList.getSonName());
                    li.add(resultnameList.getCenterName());
                    li.add(resultnameList.getHeadTime());
                    map.put("hospitalId",result.getHospitalid());
                    map.put("headName",result.getHeadName());
                    map.put("sonName",li);
                }
            }
            lis.add(map);
        }

        responseModel.setData(lis);
        responseModel.setStatus(Statu.SUCCESS);
        responseModel.setMessage("查询成功！！");
        return ResponseEntity.ok(responseModel);
    }


    @RequestMapping("/queryList")
    @ResponseBody
    public ResponseEntity<ResponseModel<List<ServiceAll>>> queryList(@RequestBody HospitalAfternoon hospitalAfternoon) throws Exception {
        ResponseModel<List<ServiceAll>> responseModel =new ResponseModel<>();
        if(("").equals(hospitalAfternoon.getHospital_name())){
            responseModel.setStatus(Statu.NUllSUCCESS);
            responseModel.setMessage("医院编号不能为空！！！");
            return ResponseEntity.ok(responseModel);
        }
        int id = hospitalAfternoonService.getId(hospitalAfternoon.getHospital_name());

        List<ServiceAll> list = serviceAllService.queryList(id);
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
    public ResponseEntity<ResponseModel<ServiceAll>> insert(@RequestBody @Validated ServiceAll serviceAll) throws Exception {
        ResponseModel<ServiceAll> responseModel = new ResponseModel<>();
        responseModel.setData(serviceAllService.insert(serviceAll, "serviceAll", "请勿添加重复的类别！"));
        responseModel.setStatus(Statu.SUCCESS);
        responseModel.setMessage("添加成功！！");
        return ResponseEntity.ok(responseModel);
    }



    @PostMapping("/edit")
    @ResponseBody
    public ResponseEntity<ResponseModel<Integer>> update(@RequestBody @Validated ServiceAll serviceAll){
        ServiceAll byId = serviceAllService.getById(serviceAll.getId());
        ResponseModel<Integer> responseModel = new ResponseModel<>();
        responseModel.setData(serviceAllService.update(byId, "serviceAll", "请勿添加重复的记录！"));
        responseModel.setStatus(Statu.SUCCESS);
        return ResponseEntity.ok(responseModel);
    }

    @RequestMapping("/del")
    @ResponseBody
    public ResponseEntity<ResponseModel<Integer>> deleteById(@RequestBody ServiceAll serviceAll){
        ResponseModel<Integer> responseModel = new ResponseModel<>();
        Integer integer = serviceAllService.deleteById(serviceAll.getId());
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
