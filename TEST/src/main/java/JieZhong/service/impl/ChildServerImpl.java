package JieZhong.service.impl;

import JieZhong.dao.AdultMapper;
import JieZhong.dao.ChildIguideMapper;
import JieZhong.dao.ChildMapper;
import JieZhong.entity.*;
import JieZhong.service.ChildService;
import JieZhong.util.YdmaConstant;
import JieZhong.util.YdmaResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

@Service
public class ChildServerImpl implements ChildService {

    /*儿童预约*/
    @Autowired
    private ChildMapper childmapper;

    /*成人预约*/
    @Autowired
    private AdultMapper adultmapper;

    /*疫苗指南*/
    @Autowired
    private ChildIguideMapper childiguidemapper;


    /*儿童表的增加*/
    @Override
    public YdmaResult addchild(Child child){
        YdmaResult result=new YdmaResult();
        int i = childmapper.insertChild(child);
        if(i!=0){
            result.setCode(YdmaConstant.SUCCESS);
            result.setMsg(YdmaConstant.SUCCESS_QUERY_MSG2);
            result.setData(i);
        }
        return result;
    }







    /*成人表的增加*/
    @Override
    public YdmaResult addadult(Adult adult) {
        YdmaResult result=new YdmaResult();
        int  result1 = adultmapper.insertAdult(adult);
        if(result1!=0){
            adult.setRegister_time(new Date());
            result.setCode(YdmaConstant.SUCCESS);
            result.setMsg(YdmaConstant.SUCCESS_QUERY_MSG2);
            result.setData(result1);
        }
        return result;
    }

    /*疫苗指南的增加*/
    @Override
    public YdmaResult addchildIguide(ChildIguide childiguide) {
        YdmaResult result=new YdmaResult();
        int i = childiguidemapper.addchildIguide(childiguide);
        if(i!=0){
            result.setCode(YdmaConstant.SUCCESS);
            result.setMsg(YdmaConstant.SUCCESS_QUERY_MSG2);
            result.setData(i);
        }
        return result;
    }

    /*疫苗指南的删除*/
    @Override
    public YdmaResult deletechildIguide(Integer iguide_id) {
        YdmaResult result=new YdmaResult();
        int i =childiguidemapper.deletechildIguide(iguide_id);
        if(i!=0){
            result.setCode(YdmaConstant.SUCCESS);
            result.setMsg(YdmaConstant.SUCCESS_QUERY_MSG1);
            result.setData(i);
        }
        return result;
    }

    /*疫苗指南的修改*/
    @Override
    public YdmaResult updatechildIguide(ChildIguide childiguide) {
        YdmaResult result=new YdmaResult();
        int i = childiguidemapper.updatechildIguide(childiguide);
        if(i!=0){
            result.setCode(YdmaConstant.SUCCESS);
            result.setMsg(YdmaConstant.SUCCESS_QUERY_MSG3);
            result.setData(i);
        }
        return result;
    }


    /*疫苗指南的出查询*/
    @Override
    public YdmaResult selectchildIguide(Integer tag) {
        YdmaResult result=new YdmaResult();
        List<ChildIguide> childIguides = childiguidemapper.selectchildIguide(tag);
        if(childIguides!=null){
            result.setCode(YdmaConstant.SUCCESS);
            result.setMsg(YdmaConstant.SUCCESS_QUERY_MSG);
            result.setData(childIguides);
        }
        return result;
    }

    /*非疫苗指南的出查询*/
    @Override
    public YdmaResult noselectchildIguide(Integer tag) {
        YdmaResult result=new YdmaResult();
        List<ChildIguide> childIguides = childiguidemapper.noselectchildIguide(tag);
        if(childIguides!=null){
            result.setCode(YdmaConstant.SUCCESS);
            result.setMsg(YdmaConstant.SUCCESS_QUERY_MSG);
            result.setData(childIguides);
        }
        return result;
    }

    /* 成人预约查询*/
    @Override
    public YdmaResult selectadult() {
        YdmaResult result=new YdmaResult();
        List<Adult> selectadult = childiguidemapper.selectadult();
        if(selectadult!=null){
            result.setCode(YdmaConstant.SUCCESS);
            result.setMsg(YdmaConstant.SUCCESS_QUERY_MSG);
            result.setData(selectadult);
        }
        return result;
    }


    /* 儿童预约查询*/
    @Override
    public YdmaResult selectchildc() {
        YdmaResult result=new YdmaResult();
        List<Child> selectchildc = childiguidemapper.selectchildc();
        if(selectchildc!=null){
            result.setCode(YdmaConstant.SUCCESS);
            result.setMsg(YdmaConstant.SUCCESS_QUERY_MSG);
            result.setData(selectchildc);
        }
        return result;
    }


    /* 儿童预约编辑*/
    @Override
    public YdmaResult selectchildcBychildid(Integer childid) {
        YdmaResult result=new YdmaResult();
        List<Child> children = childiguidemapper.selectchildcBychildid(childid);
        if(children!=null){
            result.setCode(YdmaConstant.SUCCESS);
            result.setMsg(YdmaConstant.SUCCESS_QUERY_MSG);
            result.setData(children);
        }
        return result;
    }

    /* 儿童预约删除*/
    @Override
    public YdmaResult deletrchildcBychildid(Integer childid) {
        YdmaResult result=new YdmaResult();
        int i = childiguidemapper.deletrchildcBychildid(childid);
        if(i!=0){
            result.setCode(YdmaConstant.SUCCESS);
            result.setMsg(YdmaConstant.SUCCESS_QUERY_MSG);
            result.setData(i);
        }
        return result;
    }


    /* 成人编辑*/
    @Override
    public YdmaResult selectadultByadultid(Integer adultid) {
        YdmaResult result=new YdmaResult();
        List<Adult> adults = childiguidemapper.selectadultByadultid(adultid);
        if(adults!=null){
            result.setCode(YdmaConstant.SUCCESS);
            result.setMsg(YdmaConstant.SUCCESS_QUERY_MSG);
            result.setData(adults);
        }
        return result;
    }


    /* 成人删除*/
    @Override
    public YdmaResult deleteadultByadultid(Integer adultid) {
        YdmaResult result=new YdmaResult();
        int i = childiguidemapper.deleteadultByadultid(adultid);
        if(i!=0){
            result.setCode(YdmaConstant.SUCCESS);
            result.setMsg(YdmaConstant.SUCCESS_QUERY_MSG);
            result.setData(i);
        }
        return null;
    }


    /*体检报告*/
    @Override
    public YdmaResult selectmedicalreport() {
        YdmaResult result=new YdmaResult();
        List<MedicalReport> selectmedicalreport = childiguidemapper.selectmedicalreport();
        if(selectmedicalreport!=null){
            result.setCode(YdmaConstant.SUCCESS);
            result.setMsg(YdmaConstant.SUCCESS_QUERY_MSG);
            result.setData(selectmedicalreport);
        }
        return result;
    }



    /* 成人预约时段查询 通过日期进行查询*/
    @Override
    public YdmaResult adulttimeframeBydateline(String dateline) {
        YdmaResult result=new YdmaResult();
        List<ServiceNumberTime> serviceNumberTimes = childiguidemapper.adulttimeframeBydateline(dateline);

        if(serviceNumberTimes!=null){
            result.setCode(YdmaConstant.SUCCESS);
            result.setMsg(YdmaConstant.SUCCESS_QUERY_MSG);
            result.setData(serviceNumberTimes);
        }
        return result;
    }

    /* 成人预约时段查询*/
    @Override
    public YdmaResult adulttimeframe(/*int hospital_id*/) {
        YdmaResult result=new YdmaResult();
        List<ServiceNumberTime> adulttimeframe = childiguidemapper.adulttimeframe(/*hospital_id*/);
        if(adulttimeframe!=null){
            result.setCode(YdmaConstant.SUCCESS);
            result.setMsg(YdmaConstant.SUCCESS_QUERY_MSG);
            result.setData(adulttimeframe);
        }
        return result;
}


    /*立即预约:点击确认后需要保存的信息*/
    @Override
    public YdmaResult addchsysrolemake(SysRoleMake sysrolemake) {
        YdmaResult result=new YdmaResult();
        int addchsysrolemake = childiguidemapper.addchsysrolemake(sysrolemake);
        if(addchsysrolemake!=0){
            result.setCode(YdmaConstant.SUCCESS);
            result.setMsg(YdmaConstant.SUCCESS_QUERY_MSG);
            result.setData(addchsysrolemake);
        }
        return result;
    }


    /*立即预约:预约成功的信息展示的信息 点击确定需要的*/
    @Override
    public YdmaResult selectsuccessful(SysRoleMake sysrolemake){
        YdmaResult result=new YdmaResult();
        List<SysRoleMake> selectsuccessful = childiguidemapper.selectsuccessful(sysrolemake);
        if(selectsuccessful!=null){
            result.setCode(YdmaConstant.SUCCESS);
            result.setMsg(YdmaConstant.SUCCESS_QUERY_MSG);
            result.setData(selectsuccessful);
        }
        return result;
    }


    /*我的  里面的 家人管理的宝宝查询 通过宝宝监护人的手机号查询*/
    @Override
    public YdmaResult selectchild(String phone) {
        YdmaResult result=new YdmaResult();
        List<Child> selectchild = childiguidemapper.selectchild(phone);
        if(selectchild!=null){
            result.setCode(YdmaConstant.SUCCESS);
            result.setMsg(YdmaConstant.SUCCESS_QUERY_MSG);
            result.setData(selectchild);
        }
        return result;
    }


    /*我的  里面的 家人管理的宝宝 编辑*/
    @Override
    public YdmaResult compilechild(String phone) {
        YdmaResult result=new YdmaResult();
        List<Child> compilechild = childiguidemapper.compilechild(phone);
        if(compilechild!=null){
            result.setCode(YdmaConstant.SUCCESS);
            result.setMsg(YdmaConstant.SUCCESS_QUERY_MSG);
            result.setData(compilechild);
        }
        return result;
    }

    /*我的  里面的 家人管理的宝宝 提交*/
    @Override
    public YdmaResult updatecompilechild(Integer childid) {
        YdmaResult result=new YdmaResult();
        int  updatecompilechild = childiguidemapper.updatecompilechild(childid);
        if(updatecompilechild!=0){
            result.setCode(YdmaConstant.SUCCESS);
            result.setMsg(YdmaConstant.SUCCESS_QUERY_MSG3);
            result.setData(updatecompilechild);
        }
        return result;
    }

    /*我的  里面的 家人管理的成人 编辑*/
    @Override
    public YdmaResult compileadult(String phone) {
        YdmaResult result=new YdmaResult();
        List<Adult> compileadult = childiguidemapper.compileadult(phone);
        if(compileadult!=null){
            result.setCode(YdmaConstant.SUCCESS);
            result.setMsg(YdmaConstant.SUCCESS_QUERY_MSG);
            result.setData(compileadult);
        }
        return result;
    }

    /*我的  里面的 家人管理的成人 提交*/
    @Override
    public YdmaResult updatecompileadult(Integer adultid) {
        YdmaResult result=new YdmaResult();
        int updatecompileadult = childiguidemapper.updatecompileadult(adultid);
        if(updatecompileadult!=0){
            result.setCode(YdmaConstant.SUCCESS);
            result.setMsg(YdmaConstant.SUCCESS_QUERY_MSG3);
            result.setData(updatecompileadult);
        }
        return result;
    }



    /*我的 更多预约服务 查询*/
    @Override
    public YdmaResult selectservice(int hospital_id) {
        YdmaResult result=new YdmaResult();
        List<ServiceService> selectservice = childiguidemapper.selectservice(hospital_id);
        if(selectservice!=null){
            result.setCode(YdmaConstant.SUCCESS);
            result.setMsg(YdmaConstant.SUCCESS_QUERY_MSG);
            result.setData(selectservice);
        }
        return result;
    }

   /* 我的客服 增加*/
    @Override
    public YdmaResult addserviceiguide(ServiceIguide serviceiguide) {
        YdmaResult result=new YdmaResult();
        int  addserviceiguide=childiguidemapper.addserviceiguide(serviceiguide);
        if(addserviceiguide!=0){
            result.setCode(YdmaConstant.SUCCESS);
            result.setMsg(YdmaConstant.SUCCESS_QUERY_MSG2);
            result.setData(addserviceiguide);
        }
        return result;
    }

    /* 我的客服 删除*/
    @Override
    public YdmaResult deleteserviceiguide(int id) {
        YdmaResult result=new YdmaResult();
        int deleteserviceiguide = childiguidemapper.deleteserviceiguide(id);
        if(deleteserviceiguide!=0){
            result.setCode(YdmaConstant.SUCCESS);
            result.setMsg(YdmaConstant.SUCCESS_QUERY_MSG1);
            result.setData(deleteserviceiguide);
        }
        return result;
    }


    /* 我的客服 修改*/
    @Override
    public YdmaResult updateserviceiguide(ServiceIguide  serviceiguide) {
        YdmaResult result=new YdmaResult();
        int updateserviceiguide = childiguidemapper.updateserviceiguide(serviceiguide);
        if(updateserviceiguide!=0){
            result.setCode(YdmaConstant.SUCCESS);
            result.setMsg(YdmaConstant.SUCCESS_QUERY_MSG3);
            result.setData(updateserviceiguide);
        }
        return result;
    }


    /* 我的客服 查询*/
    @Override
    public YdmaResult selectserviceiguide(int id) {
        YdmaResult result=new YdmaResult();
        List<ServiceIguide> selectserviceiguide = childiguidemapper.selectserviceiguide(id);
        if(selectserviceiguide!=null){
            result.setCode(YdmaConstant.SUCCESS);
            result.setMsg(YdmaConstant.SUCCESS_QUERY_MSG);
            result.setData(selectserviceiguide);
        }
        return result;
    }



    /*预约体检登记*/
    @Override
    public YdmaResult insertmedicalmake(MedicalMake medicalmake) {
        YdmaResult result=new YdmaResult();
        int insertmedicalmake = childiguidemapper.insertmedicalmake(medicalmake);
        if(insertmedicalmake!=0){
            result.setCode(YdmaConstant.SUCCESS);
            result.setMsg(YdmaConstant.SUCCESS_QUERY_MSG2);
            result.setData(insertmedicalmake);

        }
        return result;
    }


    /*预约项目名称  增加*/
    @Override
    public YdmaResult insertmedicalsetmeal(MedicalSetmeal medicalsetmeal) {
        YdmaResult result=new YdmaResult();
        int insertmedicalsetmeal = childiguidemapper.insertmedicalsetmeal(medicalsetmeal);
        if(insertmedicalsetmeal!=0){
            result.setCode(YdmaConstant.SUCCESS);
            result.setMsg(YdmaConstant.SUCCESS_QUERY_MSG2);
            result.setData(insertmedicalsetmeal);
        }
        return result;
    }

    /*预约项目名称  修改*/
    @Override
    public YdmaResult updatemedicalsetmeal(MedicalSetmeal medicalsetmeal) {
        YdmaResult result=new YdmaResult();
        int updatemedicalsetmeal = childiguidemapper.updatemedicalsetmeal(medicalsetmeal);
        if(updatemedicalsetmeal!=0){
            result.setCode(YdmaConstant.SUCCESS);
            result.setMsg(YdmaConstant.SUCCESS_QUERY_MSG3);
            result.setData(updatemedicalsetmeal);
        }
        return result;
    }

    /*预约项目名称  删除*/
    @Override
    public YdmaResult deletemedicalsetmeal(int id) {
        YdmaResult result=new YdmaResult();
        int deletemedicalsetmeal = childiguidemapper.deletemedicalsetmeal(id);
        if(deletemedicalsetmeal!=0){
            result.setCode(YdmaConstant.SUCCESS);
            result.setMsg(YdmaConstant.SUCCESS_QUERY_MSG1);
            result.setData(deletemedicalsetmeal);
        }
        return result;
    }

    /*预约项目名称  查询*/
    @Override
    public YdmaResult seletemedsetmeal() {
        YdmaResult result=new YdmaResult();
        List<MedicalSetmeal> seletemedsetmeal = childiguidemapper.seletemedsetmeal();
        if(seletemedsetmeal!=null){
            result.setCode(YdmaConstant.SUCCESS);
            result.setMsg(YdmaConstant.SUCCESS_QUERY_MSG);
            result.setData(seletemedsetmeal);
        }
        return result;
    }




    /*通过医院id和状态进行查询*/
    @Override
    public YdmaResult selectmedicalsetmeal(MedicalMake medicalmake) {
        YdmaResult result=new YdmaResult();
        List<MedicalMake> selectmedicalsetmeal = childiguidemapper.selectmedicalsetmeal(medicalmake.getHospitalid(), medicalmake.getMakeType());
        if(selectmedicalsetmeal!=null){
            result.setCode(YdmaConstant.SUCCESS);
            result.setMsg(YdmaConstant.SUCCESS_QUERY_MSG);
            result.setData(selectmedicalsetmeal);
        }
        return result;
    }

    /*用户注册*/
    @Override
    public YdmaResult adduser(User user) {
        YdmaResult result=new YdmaResult();
        if(StringUtils.isEmpty(user.getUsername())||StringUtils.isEmpty(user.getPwd())){
            result.setCode(YdmaConstant.PARAM_ERROR);
            result.setMsg(YdmaConstant.PARAM_ERROR_QUERY_MSG);
            return result;
        }
        User selectuser = childiguidemapper.selectuser(user.getUsername());
        if(selectuser!=null){
            result.setCode(YdmaConstant.ERROR1);
            result.setMsg(YdmaConstant.REGIST_ERROR1_MSG);
            return result;
        }
        /*String salt = PasswordUtil.salt();
        String passwordmd5 = PasswordUtil.md5(salt);*/
        String md5Password = DigestUtils.md5DigestAsHex(user.getPwd().getBytes());
        user.setPwd(md5Password);
        user.setCurrenttime(new Date());
        //user.setSalt(salt);
        int adduser = childiguidemapper.adduser(user);
        if(adduser!=0){
            result.setCode(YdmaConstant.SUCCESS);
            result.setMsg(YdmaConstant.SUCCESS_QUERY_MSG2);
            result.setData(adduser);
        }
        return result;
    }

    /*用户修改*/
    @Override
    public YdmaResult updateuser(User user) {
        YdmaResult result=new YdmaResult();
        /*String salt = PasswordUtil.salt();
        String passwordmd5 = PasswordUtil.md5(salt);*/
        String md5Password = DigestUtils.md5DigestAsHex(user.getPwd().getBytes());
        user.setPwd(md5Password);
        user.setCurrenttime(new Date());
        //user.setSalt(salt);
        int updateuser = childiguidemapper.updateuser(user);
        if(updateuser!=0){
            result.setCode(YdmaConstant.SUCCESS);
            result.setMsg(YdmaConstant.SUCCESS_QUERY_MSG3);
            result.setData(updateuser);
        }
        return result;
    }

    /*用户登陆*/
    @Override
    public YdmaResult selectuser(String username,String pwd) {
        YdmaResult result=new YdmaResult();
        User selectuser = childiguidemapper.selectuser(username);
        if(selectuser == null) {
            result.setCode(YdmaConstant.ERROR1);
            result.setMsg(YdmaConstant.LOGIN_ERROR1_MSG);
            return result;
        }
       //String md5 = PasswordUtil.md5(pwd);
        String md5 = DigestUtils.md5DigestAsHex(pwd.getBytes());
        if(md5.equals(selectuser.getPwd())) {
            result.setCode(YdmaConstant.SUCCESS);
            result.setMsg(YdmaConstant.SUCCESS_LOGIN_MSG);
            result.setData(md5);
            return result;
        }
        result.setCode(YdmaConstant.ERROR2);
        result.setMsg(YdmaConstant.LOGIN_ERROR2_MSG);
        return result;
    }
}
