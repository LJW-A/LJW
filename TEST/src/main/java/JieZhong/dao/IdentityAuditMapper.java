package JieZhong.dao;

import JieZhong.entity.IdentityAudit;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface IdentityAuditMapper {


    @Select("select id,childid, userid,imgurla,imgurlb,audit_time,tag from identity_audit")
    List<IdentityAudit> getList();




    @Select("select id,childid, userid,imgurla,imgurlb,audit_time,tag" +
            " FROM identity_audit  where  id = #{id} ")
    IdentityAudit getById(@Param("id") int id);



    @Insert({"insert into identity_audit (childid, userid,imgurla,imgurlb,audit_time,tag,datebirtha) " +
            "VALUES (#{childid},#{userid},#{imgurla},#{imgurlb},#{audit_time},#{tag},#{datebirtha})"})
    int insert(IdentityAudit identityAudit);


    @Update("UPDATE identity_audit SET imgurla = #{identityAudit.imgurla},imgurlb = #{identityAudit.imgurlb} " +
            ",hospital_remake = #{identityAudit.audit_time},hospital_remake = #{identityAudit.tag}  where id= #{identityAudit.id}")
    int update(@Param("identityAudit") IdentityAudit identityAudit);


    @Update("delete from identity_audit where id= #{id} ")
    int deleteById(@Param("id") int id);
}
