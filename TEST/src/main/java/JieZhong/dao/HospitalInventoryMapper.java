package JieZhong.dao;

import JieZhong.entity.HospitalInventory;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface HospitalInventoryMapper {

    @Select("select t1.hospitalid,t1.number,t1.vaccineid,t1.inventory_time,t1.tag,t2.id,t2.hospital_name,t2.hospital_region,\n" +
            "t3.immuneid,t3.iname,t3.fullname,t3.costsort,t3.domestic,t3.imeffect,t3.taboo,t3.uneffect,t3.mnattention\n" +
            " from hospital_inventory t1 \n" +
            "\t\n" +
            "\tLEFT JOIN hospital_afternoon t2\n" +
            "\tON\n" +
            "t1.hospitalid=t2.id\n" +
            "\n" +
            "\tLEFT JOIN immune t3\n" +
            "\tON\n" +
            "t1.vaccineid =t3.immuneid where t1.tag=#{tag}")
    List<HospitalInventory> getList(Integer tag);


    @Select("select id, hospitalId, vaccineId, ImmuneTime" +
            "FROM hospital_inventory  where  id = #{id} ")
    HospitalInventory getById(@Param("hospitalid") String hospitalid);


//    @Insert("INSERT INTO hospital_inventory (hospitalId, vaccineId, ImmuneTime)" +
//            "VALUES #{medicalrecord.operatedate}, #{medicalrecord.doctor}, #{medicalrecord.operator},#{medicalrecord.office}, #{medicalrecord.tag})")
//    @SelectKey(statement = "select newId()", keyProperty = "hospital.emrid", before = true, resultType = String.class)
//    int insert(@Param("MedicalRecord") HospitalInventory medicalrecord);
//
//    @Update("UPDATE hospital_inventory set emrcontent = #{medicalrecord.emrcontent},emrcontenthistory = #{medicalrecord.emrcontenthistory} ," +
//            "physical = #{medicalrecord.physical},diagresult = #{medicalrecord.diagresult},notice = #{medicalrecord.notice},recipe = #{medicalrecord.recipe}," +
//            "caseinchlef = #{medicalrecord.caseinchlef},xy = #{medicalrecord.xy},xl = #{medicalrecord.xl},tw = #{medicalrecord.tw},hx = #{medicalrecord.hx}," +
//            "mb =  #{medicalrecord.mb},slzt =  #{medicalrecord.slzt},gms = #{medicalrecord.gms},visittime = #{medicalrecord.visittime}," +
//            "proofnotice = #{medicalrecord.proofnotice},operatedate =  #{medicalrecord.operatedate},doctor = #{medicalrecord.doctor},operator = #{medicalrecord.operator}," +
//            "office = #{medicalrecord.office},tag = (tag+1) where opdid=  #{medicalrecord.opdid}  and  emrid= #{medicalrecord.emrid} and tag=#{operator.tag}")
//    int update(@Param("MedicalRecord") HospitalInventory medicalrecord);
//
//    @Update("update t_medicalrecord set del=1,tag=(tag+1)  where emrid=#{emrid} and tag=#{tag}")
//    int deleteById(@Param("emrid") String id);
}