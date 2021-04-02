package JieZhong.dao;

import JieZhong.entity.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ChildIguideMapper {


    /*免疫指南增加*/
    @Insert({
            "insert into child_Iguide (moon_age,vacuna_name,inoculum_size,bacterin_sort,tag,sort)",
            "values (#{moon_age},#{vacuna_name},#{inoculum_size},#{bacterin_sort},#{tag},#{sort})"
    })
    int addchildIguide(ChildIguide childiguide);


    /*免疫指南删除*/
    @Delete(
            "delete  from child_Iguide where iguide_id = #{iguide_id}"
    )
    int deletechildIguide(Integer Iguide_id);


    /*免疫指南修改*/
    @Update({
            "update child_Iguide set moon_age=#{moon_age},vacuna_name=#{vacuna_name},inoculum_size=#{inoculum_size},bacterin_sort=#{bacterin_sort},tag=#{tag},sort=#{sort}",
            "where iguide_id = #{iguide_id}"
    })
    int updatechildIguide(ChildIguide childiguide);


    /*免疫指南查询*/
    @Select({
            "select * from child_Iguide where tag=#{tag}"
    })
    List<ChildIguide> selectchildIguide(Integer tag);


    /*非免疫指南查询*/
    @Select({
            "select * from child_Iguide where tag=#{tag}"
    })
    List<ChildIguide> noselectchildIguide(Integer tag);


    /*成人预约查询 通过承认的手机号进行查询*/
    @Select({
            "select * from adult"
    })
    List<Adult>  selectadult();

    @Select({
            "select * from adult where adultid=#{adultid}"
    })
    List<Adult> selectadultByadultid(Integer adultid);


    /*成人删除*/
    @Delete(
            "delete  from adult  where adultid=#{adultid}"
    )
    int deleteadultByadultid(Integer adultid);



    /*儿童预约查询 通过承认的手机号进行查询*/
    @Select({
            "select * from child"
    })
    List<Child> selectchildc();


    @Select({
            "select * from child where childid=#{childid}"
    })
    List<Child> selectchildcBychildid(Integer childid);


    /*儿童删除*/
    @Delete(
            "delete  from child where childid=#{childid}"
    )
    int deletrchildcBychildid(Integer childid);






    /*成人预约时段查询  通过医院id*/
    @Select({
            "select dateline,date_time,start_time,end_time,all_number from service_number_time",
            "left join hospital_Afternoon on hospital_Afternoon.id=service_number_time.id"
            /*,"where hospital_id=#{hospital_id}"*/
    })
    List<ServiceNumberTime> adulttimeframe(/*int hospital_id*/);


    /*成人预约时段查询  通过传递日期*/
    @Select({
            "select dateline,date_time,start_time,end_time,all_number from service_number_time",
            "left join hospital_Afternoon on hospital_Afternoon.id=service_number_time.id"
            ,"where dateline=#{dateline}"
    })
    List<ServiceNumberTime> adulttimeframeBydateline(@Param("dateline") String dateline);







    /*立即预约 点击确认后的需要把人员的信息 存入人员信息表里里面*/
    @Insert({
            "insert into sys_role_make (hostapl_id,adultid,userid,make_time,make_date,make_type)",
            "values (#{hostapl_id},#{adultid},#{userid},#{make_time},#{make_date},#{make_type})"
    })
    int addchsysrolemake(SysRoleMake sysrolemake);


    /*立即预约成功后的信息展示*/
    @Select({
            "select adultname,make_time,make_date,hospital_name from",
            "(sys_role_make left join hospital_Afternoon on sys_role_make.hostapl_id=hospital_Afternoon.id)",
            "left join  adult on adult.director_id=hospital_Afternoon.id"
    })
    List<SysRoleMake> selectsuccessful(SysRoleMake sysrolemake);


    /*我的  里面的 家人管理的宝宝查询 通过宝宝监护人的手机号查询*/
    @Select({
            "select childname,datebirth from child",
            "where phone = #{phone}"
    })
    List<Child> selectchild(String phone);


    /*我的  里面的 家人管理宝宝  编辑 */
    @Select({
            "select * from child",
            "where phone = #{phone}"
    })
    List<Child> compilechild(String phone);


    /*我的  里面的 家人管理宝宝  修改 */
    @Update({
            "update child set director_id=#{director_id},userid=#{userid},childname=#{childname},datebirth=#{datebirth},sex=#{sex},relation=#{relation},guardianname=#{guardianname}",
            "where childid = #{childid}"
    })
    int  updatecompilechild(Integer childid);


    /*我的  里面的 家人管理成人  编辑 */
    @Select({
            "select * from adult",
            "where phone = #{phone}"
    })
    List<Adult> compileadult(String phone);


    /*我的  里面的 家人管理成人  修改 */
    @Update({
            "update adult set director_id=#{director_id},userid=#{userid},adultname=#{adultname},datebirth=#{datebirth},sex=#{sex},idcard=#{idcard},register_time=#{register_time}",
            "where adultid = #{adultid}"
    })
    int updatecompileadult(Integer adultid);




    /*我的  更多预约服务*/
    @Select({
            "select service_name,team_name from service_service",
            "where hospital_id = #{hospital_id}"
    })
    List<ServiceService> selectservice(int hospital_id);


    /*我的客服 增加*/
    @Insert({
           "insert into service_Iguide(problem_name,hospital_id,problem_catalog,information,rank)",
            "values(#{problem_name},#{hospital_id},#{problem_catalog},#{information},#{rank})"
    })
    int addserviceiguide(ServiceIguide serviceIguide);

    /*我的客服 删除*/
    @Delete({ "delete  from service_Iguide where id=#{id}"
    })
    int deleteserviceiguide(int id);

    /*我的客服 修改*/
    @Update({
            "update service_Iguide set problem_name=#{problem_name},hospital_id=#{hospital_id},problem_catalog=#{problem_catalog},information=#{information},rank=#{rank}",
            "where id=#{id}"
    })
    int updateserviceiguide(ServiceIguide serviceiguide);

    /*我的客服 查询*/
    @Select({
            "select * from service_Iguide where id=#{id}"
    })
    List<ServiceIguide> selectserviceiguide(int id);




    /*身份提交审核 通过手机号查询出成人编号 上下进行关联*/
    @Select({
            "select adultid from adult where phone=#{phone}"
    })
    @Results(id="adult",value={
            @Result(column="adultid", property="adultid",id=true)
    })
    Adult  selectadultByphone(String phone);


    /*身份提交审核 增加*/
    @Insert({
            "insert into identity_audit(ckildid,userid,imgurl,audit_time,tag)",
            "values(#{ckildid},#{userid},#{imgurl},#{audit_time},#{tag})"
    })
    //@ResultMap("adult")
    int   insertidentityaudit(IdentityAudit identityaudit);



    /*身份提交审核 修改*/
    @Update({
            "update identity_audit set ckildid=#{ckildid},userid=#{userid},imgurl=#{imgurl},audit_time=#{audit_time},tag=#{tag}",
            "where audit_id=#{audit_id}"
    })
    int   updateidentityaudit(IdentityAudit identityaudit);

    /*身份提交审核 删除*/
    @Delete({ "delete  from identity_audit where audit_id=#{audit_id}"
    })
    int daleteidentityaudit(int audit_id);

    /*身份提交审核 查询*/
    @Select({
            "select * from identity_audit where ckildid=#{ckildid}"
    })
    List<IdentityAudit> seleteidentityaudit(int ckildid);



    /*体检预约登记*/
    @Insert({
            "insert into medical_make(hospitalid,userid,userName,sex,age,idcard,setmealName,medicalTime)",
            "values(#{hospitalid},#{userid},#{userName},#{sex},#{age},#{idcard},#{setmealName},#{medicalTime})"
    })
    int insertmedicalmake(MedicalMake medicalmake);



    /*体检套餐 登记*/
    @Insert({
            "insert into medical_setmeal(hospitalid,setmealName)",
            "values(#{hospitalid},#{setmealName})"
    })
    int insertmedicalsetmeal(MedicalSetmeal medicalsetmeal);

    /*体检套餐 修改*/
    @Update({
            "update medical_setmeal set hospitalid=#{hospitalid},setmealName=#{setmealName}",
            "where id=#{id}"
    })
    int updatemedicalsetmeal(MedicalSetmeal medicalsetmeal);

    /*体检套餐 删除*/
    @Delete({
            "delete  from medical_setmeal",
            "where id=#{id}"
    })
    int deletemedicalsetmeal(int id);

    /*体检套餐 查询*/
    @Select({
            "select * from medical_setmeal"
    })
    List<MedicalSetmeal> seletemedsetmeal();


    /*体检报告*/
    @Select({
            "select hospitalid,username,idcard,reportNumber,reportDetail,creatTime from medical_report",
            "left join hospital_Afternoon on medical_report.`hospitalid`=hospital_Afternoon.`id`",
            "left join users on  users.`id`=medical_report.`id`"
    })
    List<MedicalReport> selectmedicalreport();



    /*通过医院编号和状态进行 查询*/
    @Select({
            "select mm.userName,mm.sex,mm.idcard,mm.setmealName from",
            "medical_make as mm left join medical_report as mr on mm.idcard=mr.idcard",
            "where mr.hospitalid=#{hospitalid} and mm.makeType=#{makeType}"
    })
    List<MedicalMake> selectmedicalsetmeal(int hospitalid, int makeType);


    /*用户注册*/
    @InsertProvider(type=UserSqlProvider.class, method="insertSelective")
    int adduser(User user);


    /*用户修改*/
    @UpdateProvider(type=UserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateuser(User user);




    /*用户登陆*/
    @Select({
            "select username,pwd,sex,phone,currenttime from users",
            "where username=#{username}"
    })
    //@ResultMap("userMap")
    User selectuser(String username);





    /*@Select({
            "select",
            "id, username, pwd, sex, phone,currenttime",
            "from users",
            "where id = #{id,jdbcType=INTEGER}"
    })
    @Results(id="userMap",value={
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
            @Result(column="pwd", property="pwd", jdbcType=JdbcType.VARCHAR),
            @Result(column="sex", property="sex", jdbcType=JdbcType.VARCHAR),
            @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
            @Result(column="currenttime", property="currenttime", jdbcType=JdbcType.VARCHAR)
    })
    User selectByPrimaryKey(int id);*/



}

