package JieZhong.controller;

import JieZhong.base.ResponseModel;
import JieZhong.base.Statu;
import JieZhong.entity.ServiceService;
import JieZhong.service.impl.ServiceServiceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin(origins="*",methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("/serviceService")
public class ServiceServiceController {
    @Autowired
    private ServiceServiceServiceImpl serviceServiceService;


    @RequestMapping("serviceservice")
    public ResponseEntity<ResponseModel<List<ServiceService>>> queryList(@RequestBody ServiceService serviceService){
        ResponseModel responseModel = new ResponseModel();
        int list = serviceServiceService.queryList(serviceService.getService_id());
        responseModel.setData(list);
        if (serviceService==null){
            responseModel.setStatus(Statu.ERROR);
            responseModel.setMessage("查询失败！！");
        }else {
            responseModel.setStatus(Statu.SUCCESS);
            responseModel.setMessage("查询成功！！");
        }
        return ResponseEntity.ok(responseModel);
    }



    @PostMapping
    @ResponseBody
    public ResponseEntity<ResponseModel<ServiceService>> insert(@RequestBody @Validated ServiceService serviceService) throws  Exception{
        ResponseModel<ServiceService> responseModel  = new ResponseModel<>();
        responseModel.setStatus(Statu.SUCCESS);
        responseModel.setMessage("添加成功");
        return ResponseEntity.ok(responseModel);
    }

}
