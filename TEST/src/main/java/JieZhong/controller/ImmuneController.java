package JieZhong.controller;

import JieZhong.base.ResponseModel;
import JieZhong.base.Statu;
import JieZhong.entity.Immune;
import JieZhong.service.impl.ImmunServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/immune")
public class ImmuneController {

    @Autowired
    private ImmunServiceImpl immunService;

    @RequestMapping("/list")
    public ResponseEntity<ResponseModel<List<Immune>>> getList() throws Exception {
        ResponseModel responseModel = new ResponseModel();
        responseModel.setData(immunService.getList());
        responseModel.setStatus(Statu.SUCCESS);
        responseModel.setMessage("查询成功！！");
        return ResponseEntity.ok(responseModel);
    }

    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<ResponseModel<Immune>> insert(@RequestBody @Validated Immune immune) throws Exception {
        ResponseModel<Immune> responseModel = new ResponseModel<>();
        responseModel.setData(immunService.insert(immune, "hospital_afternoon", "请勿添加重复的医院！"));
        responseModel.setStatus(Statu.SUCCESS);
        responseModel.setMessage("添加成功！！");
        return ResponseEntity.ok(responseModel);
    }

    @PostMapping("/edit")
    @ResponseBody
    public ResponseEntity<ResponseModel<Integer>> update(@RequestBody @Validated Immune immune) {
        Immune byId = immunService.getById(immune.getImmuneid());
//        byId.setHospitalRegion("运城");
//        byId.setHospitalName("死去把你");
        ResponseModel<Integer> responseModel = new ResponseModel<>();
        responseModel.setData(immunService.update(byId, "hospital_afternoon", "请勿添加重复的记录！"));
        responseModel.setStatus(Statu.SUCCESS);
        return ResponseEntity.ok(responseModel);
    }

    @RequestMapping("/del")
    @ResponseBody
    public ResponseEntity<ResponseModel<Integer>> deleteById(@RequestBody Immune immune) {
        ResponseModel<Integer> responseModel = new ResponseModel<>();
        Integer integer = immunService.deleteById(immune.getImmuneid());
        responseModel.setData(integer);
        if (integer > 0) {
            responseModel.setStatus(Statu.SUCCESS);
            responseModel.setMessage("删除成功！！");
        } else {
            responseModel.setStatus(Statu.SUCCESS);
            responseModel.setMessage("删除失败！！");
        }
        return ResponseEntity.ok(responseModel);
    }

    //查
//    @RequestMapping("/listALL")
//    private String List() {
//        List<Immune> immunes=immunService.selectListAll();
//        if (immunes!=null){
//            return "ok";
//        }
//        return "error";
//    }

    @RequestMapping("/listALL")
    public ResponseEntity<ResponseModel<List<Immune>>> List(@RequestBody Immune immune) throws Exception {
        ResponseModel responseModel = new ResponseModel();
        responseModel.setData(immunService.selectListAll(immune.getTag()));
        responseModel.setStatus(Statu.SUCCESS);
        responseModel.setMessage("查询成功！！");
        return ResponseEntity.ok(responseModel);
    }



}
