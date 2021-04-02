package JieZhong.dao;

import JieZhong.entity.Child;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface ChildMapper {

    @Insert({
            "insert into child (director_id,userid,childname,datebirth,sex,relation,datebirtha,guardianname,phone)",
            "values (#{director_id},#{userid},#{childname},#{datebirth},#{sex},#{relation},#{datebirtha},#{guardianname},#{phone})"
    })
    int insertChild(Child child);



    /*见日期增加到数据库*//*
    @Insert({
            "update child set datebirtha=#{datebirtha}"
    })
    int  addChilddatebirthaservice(Child child);*/
}
