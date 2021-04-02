package JieZhong.service;

import JieZhong.entity.*;
import JieZhong.util.YdmaResult;

public interface ChildService {


    /*增加 娃娃表*/
    public YdmaResult addchild(Child child);


    /*增加 成人表*/
    public YdmaResult addadult(Adult adult);


    /*免疫指南增加*/
    public YdmaResult addchildIguide(ChildIguide childiguide);
    /*免疫指南删除*/
    public YdmaResult deletechildIguide(Integer iguide_id);
    /*免疫指南修改*/
    public YdmaResult updatechildIguide(ChildIguide childiguide);

    /*免疫指南查询*/
    public YdmaResult selectchildIguide(Integer tag);

    /*非免疫指南查询*/
    public YdmaResult noselectchildIguide(Integer tag);



    /*成人预约接种查询*/
    public YdmaResult selectadult();
    /*成人预约时段查询*/
    public YdmaResult adulttimeframe(/*int hospital_id*/);
    /*立即预约 增加  人员预约表 点击确认时将信息存入表中*/
    public YdmaResult addchsysrolemake(SysRoleMake sysrolemake);
    /*立即预约后展示的所需的信息*/
    public YdmaResult selectsuccessful(SysRoleMake sysrolemake);
    /*我的  里面的 家人管理的宝宝查询 通过宝宝监护人的手机号查询 成人的话调用上面的成人查询*/
    public YdmaResult selectchild(String phone);


    /*我的  里面的 家人管理的宝宝 编辑*/
    public YdmaResult compilechild(String phone);
    /*我的  里面的 家人管理的宝宝 提交*/
    public YdmaResult updatecompilechild(Integer childid);


    /*我的  里面的 家人管理的成人 编辑*/
    public YdmaResult compileadult(String phone);

    /*我的  里面的 家人管理的成人 编辑*/
    public YdmaResult updatecompileadult(Integer adultid);



    /*成人预约时段查询 通过日期进行查询*/
    public YdmaResult adulttimeframeBydateline(String dateline);





    /*更多预约服务 查询*/
    public YdmaResult selectservice(int hospital_id);


    /*我的客服 增加*/
    public YdmaResult addserviceiguide(ServiceIguide serviceiguide);
    /*我的客服 删除*/
    public YdmaResult deleteserviceiguide(int id);
    /*我的客服 修改*/
    public YdmaResult updateserviceiguide(ServiceIguide serviceiguide);
    /*我的客服 查询*/
    public YdmaResult selectserviceiguide(int id);



    public YdmaResult selectchildc();


    /*儿童编辑*/
    public YdmaResult selectchildcBychildid(Integer childid);

    /*儿童删除*/
    public YdmaResult deletrchildcBychildid(Integer childid);


    /*成人编辑*/
    public YdmaResult selectadultByadultid(Integer adultid);

    /*成人删除*/
    public YdmaResult deleteadultByadultid(Integer adultid);

    /*预约体检  登记*/
    public YdmaResult insertmedicalmake(MedicalMake medicalmake);

    /*套餐名称  增加  */
    public YdmaResult insertmedicalsetmeal(MedicalSetmeal medicalsetmeal);

    /*套餐名称  修改  */
    public YdmaResult updatemedicalsetmeal(MedicalSetmeal medicalsetmeal);

    /*套餐名称  删除  */
    public YdmaResult deletemedicalsetmeal(int id);

    /*套餐名称  查询  */
    public YdmaResult seletemedsetmeal();

    /*体检报告*/
    public YdmaResult selectmedicalreport();



    /*通过身份证号 查询的字段  */
    public YdmaResult selectmedicalsetmeal(MedicalMake medicalmake);


    /*用户注册 */
    public YdmaResult adduser(User user);
    /*用户修改 */
    public YdmaResult updateuser(User user);
    /*用户登陆 */
    public YdmaResult selectuser(String username, String pwd);

}
