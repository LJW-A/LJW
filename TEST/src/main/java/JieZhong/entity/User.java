package JieZhong.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

//@JsonIgnoreProperties(value= {"currenttime"})
@Entity
@Table(name = "ausers")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int  id;
    @Column(name = "username")
    private String  userName ;               //账号
    @Column(name = "pwd")
    private String pwd ;                    //密码
    private String salt ;                   //加密盐值
    private String sex ;                    //性别
    private String phone ;                  //手机号
    private String currenttime  ;           //创建时间
    private String create_by ;              //创建人
    private String update_by ;              //更新人
    private String del_flag ;               //删除标志（0代表存在 1代表删除
    private String user_type ;              //用户类型（0,超级管理员，1.其它


    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "users_table", //name是表名
            //joinColumns设置的是entity中属性到关系表的映射名称，name是映射表中的字段名
            joinColumns = {@JoinColumn(name = "id")},
            //inverseJoinColumns,name是关系实体Role的id在关系表中的名称
            inverseJoinColumns = {@JoinColumn(name = "roleid")}
    )
    private List<SysRole> sysroles;




    public List<SysRole> getSysRoles() {
        return sysroles;
    }

    public void setSysRoles(List<SysRole> sysRoles) {
        this.sysroles = sysRoles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return userName;
    }

    public void setUsername(String username) {
        this.userName = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCurrenttime() {
        return currenttime;
    }

    public void setCurrenttime(String currenttime) {
        this.currenttime = currenttime;
    }

    public String getCreate_by() {
        return create_by;
    }

    public void setCreate_by(String create_by) {
        this.create_by = create_by;
    }

    public String getUpdate_by() {
        return update_by;
    }

    public void setUpdate_by(String update_by) {
        this.update_by = update_by;
    }

    public String getDel_flag() {
        return del_flag;
    }

    public void setDel_flag(String del_flag) {
        this.del_flag = del_flag;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public void setCurrenttime(Date date) {
    }
}
