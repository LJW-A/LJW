package JieZhong.controller;


import JieZhong.base.ResponseModel;
import JieZhong.base.Statu;
import JieZhong.entity.IdentityAudit;
import JieZhong.util.CommUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/identityAudit")
@CrossOrigin(origins="*",methods= {RequestMethod.GET,RequestMethod.POST})
public class IdentityAuditController {
    
    @Autowired
    private JieZhong.service.IdentityAuditService IdentityAuditService;


    @RequestMapping("/list")
    public ResponseEntity<ResponseModel<List<IdentityAudit>>> getList() throws Exception {
        ResponseModel<List<IdentityAudit>> responseModel =new ResponseModel<>();
        List<IdentityAudit> list = IdentityAuditService.getList();
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
    public ResponseEntity<ResponseModel<IdentityAudit>> insert(@RequestBody @Validated IdentityAudit identityAudit, HttpServletRequest request) throws Exception {
        ResponseModel<IdentityAudit> responseModel = new ResponseModel<>();
        Date d = new Date();
        System.out.println(d);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String dateNowStr = sdf.format(d);
        dateNowStr=dateNowStr+".jpg";
        File directory = new File("src/main/resources/upload/"+dateNowStr+"");
        String OneFile = directory.getCanonicalPath();
        //图片A
        String imgurla = identityAudit.getImgurla();
        String imgFirst = imgurla.substring(imgurla.indexOf(",")+1);//去掉base64字符串的开头部分
        boolean first = CommUtils.base64StrToImage(imgFirst, OneFile);
        if(first){
            identityAudit.setImgurla(OneFile);
        }

        Date date = new Date();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMddHHmm");
        String NowStr = sdf1.format(date);
        NowStr=NowStr+".jpg";
        File dir = new File("src/main/resources/upload/"+NowStr+"");
        String TwoFile = dir.getCanonicalPath();
        //图片B
        String imgurlb = identityAudit.getImgurlb();
        String imgTwo = imgurlb.substring(imgurlb.indexOf(",")+1);//去掉base64字符串的开头部分
        boolean two = CommUtils.base64StrToImage(imgTwo, TwoFile);
        if(two){
            identityAudit.setImgurlb(TwoFile);
        }
        IdentityAudit identity = IdentityAuditService.insert(identityAudit, "identityAudit", "请勿添加重复的审核！");
        if(identity==null){
            responseModel.setStatus(Statu.ERROR);
            responseModel.setMessage("添加失败！！");
            return ResponseEntity.ok(responseModel);
        }
        responseModel.setData(identity);
        responseModel.setStatus(Statu.SUCCESS);
        responseModel.setMessage("添加成功！！");
        return ResponseEntity.ok(responseModel);
    }



    @PostMapping("/edit")
    @ResponseBody
    public ResponseEntity<ResponseModel<Integer>> update(@RequestBody @Validated IdentityAudit identityAudit){
        IdentityAudit byId = IdentityAuditService.getById(identityAudit.getId());
        ResponseModel<Integer> responseModel = new ResponseModel<>();
        responseModel.setData(IdentityAuditService.update(byId, "identityAudit", "请勿添加重复的记录！"));
        responseModel.setStatus(Statu.SUCCESS);
        return ResponseEntity.ok(responseModel);
    }

    @RequestMapping("/del")
    @ResponseBody
    public ResponseEntity<ResponseModel<Integer>> deleteById(@RequestBody IdentityAudit identityAudit){
        ResponseModel<Integer> responseModel = new ResponseModel<>();
        Integer integer = IdentityAuditService.deleteById(identityAudit.getId());
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
