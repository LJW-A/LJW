package JieZhong.controller;

import JieZhong.base.ResponseModel;
import JieZhong.base.Statu;
import JieZhong.entity.HospitalInventory;
import JieZhong.service.impl.HospitalInventoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@CrossOrigin(origins="*",methods= {RequestMethod.GET,RequestMethod.POST})
public class HospitalInventoryController {

    @Autowired
    private HospitalInventoryServiceImpl hospitalInventoryService;


    @PostMapping("/hospitalInventory/list")
    @ResponseBody
    public ResponseEntity<ResponseModel<List<HospitalInventory>>> getList(HttpServletRequest request, @RequestBody HospitalInventory hospitalinventory) throws Exception {
        ResponseModel responseModel =new ResponseModel();
        responseModel.setStatus(Statu.SUCCESS);
        responseModel.setData(hospitalInventoryService.getList(hospitalinventory.getTag()));

        return ResponseEntity.ok(responseModel);
    }
}
