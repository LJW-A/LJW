package JieZhong.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "sys_user_role")
public class SysUserRole implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "authid")
    private int id ;

    /*@Column(name = "userid")
    private int user_id;       *//** 用户id*//*
    @Column(name = "roleid")
    private int role_id;       *//** 角色id*/

    @Column(name = "auth_name")   /**权限名称*/
    private String authorityName;


    public String getAuthorityname() {
        return authorityName;
    }

    public void setAuthorityname(String authorityname) {
        this.authorityName = authorityname;
    }

    @JsonBackReference
    @ManyToMany(mappedBy = "sysuserrole")
    private List<SysRole> sysroles;




    public List<SysRole> getSysroles() {
        return sysroles;
    }

    public void setSysroles(List<SysRole> sysroles) {
        this.sysroles = sysroles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /*public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }*/
}
