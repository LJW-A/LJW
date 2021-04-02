package JieZhong.entity;

import lombok.Data;

@Data
public class Users {

    private Integer id;
    private String  username;       /**用户名*/
    private String pwd;    /**密码*/
    private int sex;    /**性别*/
    private String phone;    /**号码*/
    private String currenttime;       /**创建时间*/

}
