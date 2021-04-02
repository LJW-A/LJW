package JieZhong.controller;

import JieZhong.base.ResponseModel;
import JieZhong.base.Statu;
import JieZhong.entity.ServiceTable;
import JieZhong.service.IServiceTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin(origins="*",methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("/serviceTable")
public class ServiceTableController {

    @Autowired
    private IServiceTableService serviceTableService;


    //专属客服查询
    @RequestMapping("/list")
    public ResponseEntity<ResponseModel<List<ServiceTable>>> list(){
        ResponseModel<List<ServiceTable>> responseModel =new ResponseModel<>();
        List<ServiceTable> list = serviceTableService.getList();
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
    public ResponseEntity<ResponseModel<ServiceTable>> insert(@RequestBody @Validated ServiceTable serviceTable){
        ResponseModel<ServiceTable> responseModel = new ResponseModel<>();
        responseModel.setData(serviceTableService.insert(serviceTable, "serviceTable", "请勿添加重复的服务！"));
        responseModel.setStatus(Statu.SUCCESS);
        responseModel.setMessage("添加成功！！");
        return ResponseEntity.ok(responseModel);
    }



    @PostMapping("/edit")
    @ResponseBody
    public ResponseEntity<ResponseModel<Integer>> update(@RequestBody @Validated ServiceTable ServiceTable){
        ServiceTable byId = serviceTableService.getById(ServiceTable.getId());

        ResponseModel<Integer> responseModel = new ResponseModel<>();
        responseModel.setData(serviceTableService.update(byId, "ServiceTable", "请勿添加重复的客服！"));
        responseModel.setStatus(Statu.SUCCESS);
        return ResponseEntity.ok(responseModel);
    }

    @RequestMapping("/del")
    @ResponseBody
    public ResponseEntity<ResponseModel<Integer>> deleteById(@RequestBody ServiceTable ServiceTable){
        ResponseModel<Integer> responseModel = new ResponseModel<>();
        Integer integer = serviceTableService.deleteById(ServiceTable.getId());
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
