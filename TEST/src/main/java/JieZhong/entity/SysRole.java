package JieZhong.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "sys_role")
public class SysRole implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roleid")
    private int id ;
    @Column(name = "rolename")
    private String  roleName;                  /** 角色名称*/
    private String role_key;                    /** 角色key*/
    private int role_sort;                      /**  角色排序*/
    private String  data_scope;                 /**数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限*/
    private String status;                       /**角色状态（0正常 1停用）*/
    private String del_flag;                     /**删除标志（0代表存在 1代表删除*/
    private String create_time;                  /**创建时间*/
    private String update_time;                  /**更新时间*/
    private String  create_by;                   /**创建人*/
    private String  update_by;                   /**更新人*/
    private String  remark;
    /**备注*/

    @JsonBackReference
    @ManyToMany(mappedBy = "sysroles")
    private List<User> user;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "sys_role_table", //name是表名
            joinColumns = @JoinColumn(name = "roleid"),
            inverseJoinColumns =@JoinColumn(name = "authid")
    )
    private List<SysUserRole>  sysuserrole;


    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    public List<SysUserRole> getSysuserrole() {
        return sysuserrole;
    }

    public void setSysuserrole(List<SysUserRole> sysuserrole) {
        this.sysuserrole = sysuserrole;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getRolename() {
        return roleName;
    }

    public void setRolename(String rolename) {
        this.roleName = rolename;
    }


    public String getRole_key() {
        return role_key;
    }

    public void setRole_key(String role_key) {
        this.role_key = role_key;
    }

    public int getRole_sort() {
        return role_sort;
    }

    public void setRole_sort(int role_sort) {
        this.role_sort = role_sort;
    }

    public String getData_scope() {
        return data_scope;
    }

    public void setData_scope(String data_scope) {
        this.data_scope = data_scope;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDel_flag() {
        return del_flag;
    }

    public void setDel_flag(String del_flag) {
        this.del_flag = del_flag;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
