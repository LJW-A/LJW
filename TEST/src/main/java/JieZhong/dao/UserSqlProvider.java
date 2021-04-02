package JieZhong.dao;


import JieZhong.entity.User;
import org.apache.ibatis.jdbc.SQL;

public class UserSqlProvider {

    public String insertSelective(User user) {
        SQL sql = new SQL();
        sql.INSERT_INTO("users");
        
        if (user.getUsername() != null) {
            sql.VALUES("username","#{username,jdbcType=VARCHAR}");
        }
        
        if (user.getPwd() != null) {
            sql.VALUES("pwd","#{pwd,jdbcType=VARCHAR}");
        }

        if (user.getSalt() != null) {
            sql.VALUES("salt","#{salt,jdbcType=VARCHAR}");
        }

        if (user.getSex() != null) {
            sql.VALUES("sex","#{sex,jdbcType=VARCHAR}");
        }
        
        if (user.getPhone() != null) {
            sql.VALUES("phone","#{phone,jdbcType=VARCHAR}");
        }

       if (user.getCurrenttime() != null) {
            sql.VALUES("currenttime","#{currenttime,jdbcType=VARCHAR}");
        }


        if (user.getUpdate_by() != null) {
            sql.VALUES("update_by","#{update_by,jdbcType=VARCHAR}");
        }


        if (user.getCreate_by() != null) {
            sql.VALUES("create_by","#{create_by,jdbcType=VARCHAR}");
        }

        if (user.getDel_flag() != null) {
            sql.VALUES("del_flag","#{del_flag,jdbcType=CHAR}");
        }

        if (user.getUser_type() != null) {
            sql.VALUES("user_type","#{user_type,jdbcType=CHAR}");
        }



        return sql.toString();
    }



    public String updateByPrimaryKeySelective(User user) {
        SQL sql = new SQL();
        sql.UPDATE("users");
        
        if (user.getUsername() != null) {
            sql.SET("username = #{username,jdbcType=VARCHAR}");
        }
        
        if (user.getPwd() != null) {
            sql.SET("pwd = #{pwd,jdbcType=VARCHAR}");
        }

        if (user.getSalt() != null) {
            sql.SET("salt = #{salt,jdbcType=VARCHAR}");
        }

        if (user.getPhone() != null) {
            sql.SET("phone = #{phone,jdbcType=VARCHAR}");
        }
        
        if (user.getCurrenttime() != null) {
            sql.SET("currenttime = #{currenttime,jdbcType=VARCHAR}");
        }
        
        if (user.getSex() != null) {
            sql.SET("sex = #{sex,jdbcType=VARCHAR}");
        }

        if (user.getCreate_by() != null) {
            sql.SET("create_by = #{create_by,jdbcType=VARCHAR}");
        }

        if (user.getUpdate_by() != null) {
            sql.SET("update_by = #{update_by,jdbcType=VARCHAR}");
        }

        if (user.getDel_flag() != null) {
            sql.SET("del_flag = #{del_flag,jdbcType=CHAR}");
        }

        if (user.getUser_type() != null) {
            sql.SET("user_type = #{user_type,jdbcType=CHAR}");
        }


        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}