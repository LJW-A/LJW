package JieZhong.dao;

import JieZhong.entity.Immune;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ImmuneMapper {

    @Select("select immuneid, iname, fullname,costsort,domestic,imeffect,taboo,uneffect,mnattention,tag,sort from immune")
    List<Immune> getList();


    @Select("select immuneid, iname, fullname,costsort,domestic,imeffect,taboo,uneffect,mnattention,tag,sort" +
            " FROM immune  where  immuneid = #{immuneid} ")
    Immune getById(@Param("immuneid") int immuneid);



    //增加
    @Insert({"insert into immune (iname, fullname,costsort,domestic,imeffect,taboo,uneffect,mnattention,tag,sort) " +
            "VALUES (#{iname},#{fullname},#{costsort},#{domestic},#{imeffect},#{taboo},#{uneffect},#{mnattention},#{tag},#{sort})"})
    int insert(Immune immune);


    @Update("UPDATE immune SET iname = #{immune.iname},fullname = #{immune.fullname},costsort = #{immune.fullname},domestic = #{immune.domestic}" +
            "imeffect=#{immune.imeffect},taboo = #{immune.taboo},uneffect = #{immune.uneffect},mnattention = #{immune.mnattention},tag = #{immune.tag}，sort = #{immune.sort} " +
            " where immuneid= #{immune.immuneid}")
    int update(@Param("immune") Immune immune);


    //修改
    @Update("delete from immune where immuneid= #{immuneid} ")
    int deleteById(@Param("immuneid") int id);

    //查
    @Select("select t1.immuneid,t1.iname, t3.hospital_name,t1.fullname,t1.costsort,t1.domestic,t1.imeffect,t1.taboo,t1.uneffect,t1.mnattention,t2.number \n" +
            "                        from  immune t1\n" +
            "\n" +
            "                       LEFT JOIN hospital_inventory t2\n" +
            "                       ON\n" +
            "                       t1.immuneid=t2.vaccineid\n" +
            "                      \n" +
            "                       LEFT JOIN hospital_afternoon t3\n" +
            "                       ON\n" +
            "                       t2.vaccineid =t3.id and t1.tag=#{tag}")
    List<Immune> listAll(int tag);

    //判断
    /*@Select("<script>select im.iname,im.fullname,im.costsort,im.domestic,im.imeffert,im.taboo," +
            "im.uneffect,im.mnattent,hi.number from immune <if test='tag = 0'> " +
            "<if test='tag = 1'</script>")
    List<Immune> listAll(int tag);*/






}
