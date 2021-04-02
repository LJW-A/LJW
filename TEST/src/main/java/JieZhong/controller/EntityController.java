package JieZhong.controller;


import JieZhong.dao.RoleRepository;
import JieZhong.dao.UserRepository;
import JieZhong.dao.UserRoleRepository;
import JieZhong.entity.SysRole;
import JieZhong.entity.SysUserRole;
import JieZhong.entity.User;
import JieZhong.service.impl.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@RestController
@RequestMapping("/user")
public class EntityController {


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRoleRepository authorityRepository;
    @Autowired
    private EntityService entityService;


    /*
        用户部分的增删查改
     */
    @PostMapping("/finduser")
    public List<User> findByName(@RequestBody String userName) {
        return userRepository.findAllByUserName(userName);

    }

    @RequestMapping("/findalluser")
    public List<User> findAllUser() {
        return userRepository.findAll();
    }


    @PostMapping("/adduser")
    public List<User> addUser(@RequestBody User user) {
        SysRole sysRole = roleRepository.findAllByRoleName(user.getSysRoles().get(1).getRolename()).get(0);
        user.setUsername(user.getUsername());
        user.setSysRoles(new ArrayList<>());
        user.getSysRoles().add(sysRole);           //给用户设置权限
        userRepository.save(user);
        return userRepository.findAll();
    }


    /*
        给用户添加角色
     */
    @RequestMapping("/adduserrole")
    public List<User> addUserRole(@RequestBody User users) {

        User user = userRepository.findAllByUserName(users.getUsername()).get(0);
        SysRole role = roleRepository.findAllByRoleName(users.getSysRoles().get(1).getRolename()).get(0);
        if (user.getSysRoles() == null) {
            user.setSysRoles(new ArrayList<>());
        }
        user.getSysRoles().add(role);//给用户设置权限
        userRepository.save(user);
        return userRepository.findAll();
    }

    @RequestMapping("/deleteuser")
    public List<User> deleteUser(@RequestBody String userName) {
        entityService.deleteUser(userName);
        return userRepository.findAll();
    }

    /*
        查询用户权限
     */
    @RequestMapping("/getauth")
    public Set<SysUserRole> getAuthority(@RequestBody String userName) {
        Set<SysUserRole> authoritieSet = new HashSet<>();
        User user = userRepository.findAllByUserName(userName).get(0);
        for(SysRole role : user.getSysRoles()){
            for(SysUserRole authority : role.getSysuserrole()) {
                authoritieSet.add(authority);
            }
        }
        return authoritieSet;
    }

    /*
        角色部分的增删查改
     */
    @RequestMapping("/findallrole")
    public List<SysRole> findAllRole() {
        return roleRepository.findAll();
    }

    @RequestMapping("/addrole")
    public List<SysRole> addRole(@RequestBody SysRole sysrole) {
        SysRole role = new SysRole();
        SysUserRole authority = authorityRepository.findAllByAuthorityName(sysrole.getSysuserrole().get(0).getAuthorityname()).get(0);
        role.setRolename(sysrole.getRolename());
        role.setSysuserrole(new ArrayList<>());
        role.getSysuserrole().add(authority);
        roleRepository.save(role);
        return roleRepository.findAll();
    }

    /*
        给角色添加权限
     */
    @RequestMapping("/addroleauth")
    public List<SysRole> addRoleAuth(@RequestBody SysRole sysrole) {
        SysRole role = roleRepository.findAllByRoleName(sysrole.getRolename()).get(0);
        SysUserRole authority = authorityRepository.findAllByAuthorityName(sysrole.getSysuserrole().get(0).getAuthorityname()).get(0);
        if (role.getSysuserrole() == null) {
            role.setSysuserrole(new ArrayList<>());
        }
        role.getSysuserrole().add(authority);
        roleRepository.save(role);
        return roleRepository.findAll();
    }

    @RequestMapping("/deleterole")
    public List<SysRole> deleteRole(@RequestBody String roleName) {
        entityService.deleteRole(roleName);
        return roleRepository.findAll();
    }

    /*
        权限部分的增删查改
     */
    @RequestMapping("/findallauth")
    public List<SysUserRole> findAllAuthority() {
        return authorityRepository.findAll();
    }

    @RequestMapping("/addauth")
    public List<SysUserRole> addAuthority(@RequestBody String authorityName) {
        SysUserRole authority = new SysUserRole();
        authority.setAuthorityname(authorityName);
        authorityRepository.save(authority);
        return authorityRepository.findAll();
    }

    @RequestMapping("/deleteauth")
    public List<SysUserRole> deletAuthority(@RequestBody String authorityName) {
        entityService.deleteAuthority(authorityName);
        return authorityRepository.findAll();
    }


}
