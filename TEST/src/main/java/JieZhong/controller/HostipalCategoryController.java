package JieZhong.controller;


import JieZhong.base.ResponseModel;
import JieZhong.base.Statu;
import JieZhong.entity.HospitalAfternoon;
import JieZhong.entity.HospitalCategory;
import JieZhong.service.impl.HospitalAfternoonServiceImpl;
import JieZhong.service.impl.HospitalCategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/hostipalCategory")
@CrossOrigin(origins="*",methods= {RequestMethod.GET,RequestMethod.POST})
public class HostipalCategoryController {
    
    
    @Autowired
    private HospitalCategoryServiceImpl hospitalCategoryService;

    @Autowired
    private HospitalAfternoonServiceImpl hospitalAfternoonService;


    @RequestMapping("/list")
    @ResponseBody
    public ResponseEntity<ResponseModel<List<HospitalCategory>>> getList(@RequestBody HospitalAfternoon hospitalAfternoon) throws Exception {
        ResponseModel responseModel =new ResponseModel();

        int id = hospitalAfternoonService.getId(hospitalAfternoon.getHospital_name());
        //类别
        List<HospitalCategory> nameList = hospitalCategoryService.getList(id);
        responseModel.setData(nameList);
        if(nameList.size()==0){
            responseModel.setStatus(Statu.NUllSUCCESS);
            responseModel.setMessage("该医院类别为空！！");
            return ResponseEntity.ok(responseModel);
        }
        responseModel.setStatus(Statu.SUCCESS);
        responseModel.setMessage("查询成功！！");
        return ResponseEntity.ok(responseModel);
    }

    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<ResponseModel<HospitalCategory>> insert(@RequestBody @Validated HospitalCategory HospitalCategory) throws Exception {
        ResponseModel<JieZhong.entity.HospitalCategory> responseModel = new ResponseModel<>();
        responseModel.setData(hospitalCategoryService.insert(HospitalCategory, "hospital_afternoon", "请勿添加重复的医院！"));
        responseModel.setStatus(Statu.SUCCESS);
        responseModel.setMessage("添加成功！！");
        return ResponseEntity.ok(responseModel);
    }



    @PostMapping("/edit")
    @ResponseBody
    public ResponseEntity<ResponseModel<Integer>> update(@RequestBody @Validated HospitalCategory HospitalCategory){
        JieZhong.entity.HospitalCategory byId = hospitalCategoryService.getById(HospitalCategory.getCategory_id());
        ResponseModel<Integer> responseModel = new ResponseModel<>();
        responseModel.setData(hospitalCategoryService.update(byId, "hospital_afternoon", "请勿添加重复的记录！"));
        responseModel.setStatus(Statu.SUCCESS);
        return ResponseEntity.ok(responseModel);
    }

    @RequestMapping("/del")
    @ResponseBody
    public ResponseEntity<ResponseModel<Integer>> deleteById(@RequestBody HospitalCategory HospitalCategory){
        ResponseModel<Integer> responseModel = new ResponseModel<>();
        Integer integer = hospitalCategoryService.deleteById(HospitalCategory.getCategory_id());
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
