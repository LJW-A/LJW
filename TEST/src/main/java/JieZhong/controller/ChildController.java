package JieZhong.controller;

import JieZhong.entity.*;
import JieZhong.service.ChildService;
import JieZhong.util.YdmaResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin(origins="*",methods= {RequestMethod.GET,RequestMethod.POST})
public class ChildController {

    @Autowired
    private ChildService chilkdservice;


   /* @Autowired
    private AddChildDatebirthaService addChilddatebirthaservice;*/


    /*儿童登记*/
    @PostMapping("/addchild")
    @ResponseBody
    public YdmaResult insertchild(@RequestBody Child child){
        return chilkdservice.addchild(child);
    }





    /*儿童登记 将日期放入数据库*//*
    @PostMapping("/AddChildDatebirthaService")
    @ResponseBody
    public YdmaResult  AddChildDatebirthaService(@RequestBody Child child){
        return addChilddatebirthaservice.addChilddatebirthaservice(child.getChildid());
    }*/






    /*成人登记*/
    @PostMapping("/addadult")
    @ResponseBody
    public YdmaResult insertAdult(@RequestBody Adult adult){
        return chilkdservice.addadult(adult);
    }



    /*疫苗指南增加*/
    @PostMapping("/addchildiguide")
    @ResponseBody
    public YdmaResult insertcHildiguide(@RequestBody ChildIguide childiguide){
        return chilkdservice.addchildIguide(childiguide);
    }


    /*疫苗指南删除*/
    @PostMapping("/deletechildIguide")
    @ResponseBody
    public YdmaResult deletechildIguide(@RequestBody ChildIguide childiguide){
        return chilkdservice.deletechildIguide(childiguide.getIguide_id());
    }

    /*疫苗指南修改*/
    @PostMapping("/updatechildIguide")
    @ResponseBody
    public YdmaResult updatechildIguide(@RequestBody ChildIguide childiguide){
        return chilkdservice.updatechildIguide(childiguide);
    }


    /*疫苗指南查询*/
    @PostMapping("/selectchildIguide")
    @ResponseBody
    public YdmaResult selectchildIguide(@RequestBody ChildIguide childiguide){
        return chilkdservice.selectchildIguide(childiguide.getTag());
    }



    /*非疫苗指南查询*/
    @PostMapping("/noselectchildIguide")
    @ResponseBody
    public YdmaResult noselectchildIguide(@RequestBody ChildIguide childiguide){
        return chilkdservice.noselectchildIguide(childiguide.getTag());
    }





    /*成人预约查询*/
    @PostMapping("/selectadult")
    @ResponseBody
    public YdmaResult selectadult(){
        return chilkdservice.selectadult();
    }



    /*成人预约查询*/
    @PostMapping("/selectchildc")
    @ResponseBody
    public YdmaResult selectchildc(){
        return chilkdservice.selectchildc();
    }





    /*成人预约时段查询  通过日期进行查询*/
    @PostMapping("/adulttimeframeBydateline")
    @ResponseBody
    public YdmaResult adulttimeframeBydateline(@RequestBody ServiceNumberTime servicenumbertime){
        return chilkdservice.adulttimeframeBydateline(servicenumbertime.getDateline());
    }




    /*儿童的编辑*/
    @PostMapping("/selectchildcBychildid")
    @ResponseBody
    public YdmaResult selectchildcBychildid(@RequestBody Child child){
        return chilkdservice.selectchildcBychildid(child.getChildid());
    }

    /*儿童的删除*/
    @PostMapping("/deletrchildcBychildid")
    @ResponseBody
    public YdmaResult deletrchildcBychildid(@RequestBody Child child){
        return chilkdservice.deletrchildcBychildid(child.getChildid());
    }




    /*成人的编辑*/
    @PostMapping("/selectadultByadultid")
    @ResponseBody
    public YdmaResult selectadultByadultid(@RequestBody Adult adult){
        return chilkdservice.selectadultByadultid(adult.getAdultid());
    }



    /*成人的删除*/
    @PostMapping("/deleteadultByadultid")
    @ResponseBody
    public YdmaResult deleteadultByadultid(@RequestBody Adult adult){
        return chilkdservice.deleteadultByadultid(adult.getAdultid());
    }






    /*成人预约时段查询*/
    @PostMapping("/adulttimeframe")
    @ResponseBody
    public YdmaResult adulttimeframe(/*@RequestBody ServiceNumberTime servicenumbertime*/){
        return chilkdservice.adulttimeframe(/*servicenumbertime.getHospital_id()*/);
    }


    /*立即预约 点击确认保存的信息*/
    @PostMapping("/addchsysrolemake")
    @ResponseBody
    public YdmaResult addchsysrolemake(@RequestBody SysRoleMake sysrolemake){
        return chilkdservice.addchsysrolemake(sysrolemake);
    }


    /*立即预约成功后展示的信息*/
    @PostMapping("/selectsuccessful")
    @ResponseBody
    public YdmaResult selectsuccessful(SysRoleMake sysrolemake){
        return chilkdservice.selectsuccessful(sysrolemake);
    }


    /*我的  里面的 家人管理的宝宝查询 通过宝宝监护人的手机号查询*/
    @PostMapping("/selectchild")
    @ResponseBody
    public YdmaResult selectchild(@RequestBody Child child){
        return chilkdservice.selectchild(child.getPhone());
    }


    /*我的  更多预约服务*/
    @PostMapping("/selectservice")
    @ResponseBody
    public YdmaResult selectservice(@RequestBody ServiceService serviceservice){
        return chilkdservice.selectservice(serviceservice.getHospital_id());
    }



    /*我的客服  增加*/
    @PostMapping("/addserviceiguide")
    @ResponseBody
    public YdmaResult addserviceiguide(@RequestBody ServiceIguide serviceiguide){
        return chilkdservice.addserviceiguide(serviceiguide);
    }

    /*我的客服  删除*/
    @PostMapping("/deleteserviceiguide")
    @ResponseBody
    public YdmaResult deleteserviceiguide(@RequestBody ServiceIguide serviceiguide){
        return chilkdservice.deleteserviceiguide(serviceiguide.getId());
    }

    /*我的客服  修改*/
    @PostMapping("/updateserviceiguide")
    @ResponseBody
    public YdmaResult updateserviceiguide(@RequestBody ServiceIguide serviceiguide){
        return chilkdservice.updateserviceiguide(serviceiguide);
    }

    /*我的客服  查询*/
    @PostMapping("/selectserviceiguide")
    @ResponseBody
    public YdmaResult selectserviceiguide(@RequestBody ServiceIguide serviceiguide){
        return chilkdservice.selectserviceiguide(serviceiguide.getId());
    }



    /*预约体检 登记*/
    @PostMapping("/insertmedicalmake")
    @ResponseBody
    public YdmaResult insertmedicalmake(@RequestBody MedicalMake medicalmake ){
        return  chilkdservice.insertmedicalmake(medicalmake);
    }


    /*预约套餐 登记*/
    @PostMapping("/insertmedicalsetmeal")
    @ResponseBody
    public YdmaResult insertmedicalsetmeal(@RequestBody MedicalSetmeal medicalsetmeal ){
        return  chilkdservice.insertmedicalsetmeal(medicalsetmeal);
    }


    /*体检报告*/
    @PostMapping("/selectmedicalreport")
    @ResponseBody
    public YdmaResult selectmedicalreport(){
        return  chilkdservice.selectmedicalreport();
    }






    /*预约套餐 修改*/
    @PostMapping("/updatemedicalsetmeal")
    @ResponseBody
    public YdmaResult updatemedicalsetmeal(@RequestBody MedicalSetmeal medicalsetmeal ){
        return  chilkdservice.updatemedicalsetmeal(medicalsetmeal);
    }


    /*预约套餐 删除*/
    @PostMapping("/deletemedicalsetmeal")
    @ResponseBody
    public YdmaResult deletemedicalsetmeal(@RequestBody MedicalSetmeal medicalsetmeal ){
        return  chilkdservice.deletemedicalsetmeal(medicalsetmeal.getId());
    }


    /*预约套餐 查询*/
    @PostMapping("/seletemedsetmeal")
    @ResponseBody
    public YdmaResult seletemedsetmeal(/*@RequestBody MedicalSetmeal medicalsetmeal*/ ){
        return  chilkdservice.seletemedsetmeal(/*medicalsetmeal.getId()*/);
    }

    /*通过医院id和状态 查询*/
    @PostMapping("/selectmedicalsetmeal")
    @ResponseBody
    public YdmaResult selectmedicalsetmeal(@RequestBody MedicalMake medicalmake ){
        return  chilkdservice.selectmedicalsetmeal(medicalmake);
    }



    /*宝宝编辑*/
    @PostMapping("/compilechild")
    @ResponseBody
    public YdmaResult compilechild(@RequestBody Child child ){
        return  chilkdservice.compilechild(child.getPhone());
    }

    /*宝宝提交*/
    @PostMapping("/updatecompilechild")
    @ResponseBody
    public YdmaResult updatecompilechild(@RequestBody Child child ){
        return  chilkdservice.updatecompilechild(child.getChildid());
    }

    /*成人编辑*/
    @PostMapping("/compileadult")
    @ResponseBody
    public YdmaResult compileadult(@RequestBody Adult adult){
        return  chilkdservice.compileadult(adult.getPhone());
    }


    /*成人提交*/
    @PostMapping("/updatecompileadult")
    @ResponseBody
    public YdmaResult updatecompileadult(@RequestBody Adult adult){
        return  chilkdservice.updatecompileadult(adult.getAdultid());
    }


    /*用户注册*/
    @PostMapping("/adduser")
    @ResponseBody
    public YdmaResult adduser(@RequestBody User user){
        return  chilkdservice.adduser(user);
    }

    /*用户修改*/
    @PostMapping("/updateuser")
    @ResponseBody
    public YdmaResult updateuser(@RequestBody User user){
        return  chilkdservice.updateuser(user);
    }

    /*用户登陆*/
    @PostMapping("/selectuser")
    @ResponseBody
    public YdmaResult selectuser(@RequestBody User user){
        return  chilkdservice.selectuser(user.getUsername(),user.getPwd());
    }




}
