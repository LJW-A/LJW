package JieZhong.dao;

import JieZhong.entity.Adult;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdultMapper {

    @Insert({
            "insert into adult (director_id,userid,adultname,datebirth,sex,idcard,phone,register_time)",
            "values (#{director_id},#{userid},#{adultname},#{datebirth},#{sex},#{idcard},#{phone},#{register_time})"

    })
    int  insertAdult(Adult adult);

}
