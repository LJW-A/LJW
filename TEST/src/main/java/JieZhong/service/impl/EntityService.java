package JieZhong.service.impl;

import JieZhong.dao.RoleRepository;
import JieZhong.dao.UserRepository;
import JieZhong.dao.UserRoleRepository;
import JieZhong.entity.SysRole;
import JieZhong.entity.SysUserRole;
import JieZhong.entity.User;
import JieZhong.service.EntityAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EntityService implements EntityAService {

    @Autowired
    private UserRepository userrepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRoleRepository authorityRepository;

    @Transactional
    public void deleteUser(String userName) {
        List<User> users = userrepository.findAllByUserName(userName);
        //如果删除维护端数据，只是把维护端的List清空
        for(User user : users) {
            user.getSysRoles().clear();
            userrepository.save(user); //执行save()之后才会保存到数据库中
        }
        userrepository.deleteByUserName(userName);
    }

    @Transactional
    public void deleteRole(String roleName) {
        List<SysRole> roles = roleRepository.findAllByRoleName(roleName);
        List<User> users = userrepository.findAll();
        for (User user : users) {
            List<SysRole> userRole = user.getSysRoles();
            for (SysRole role : roles) {
                if (userRole.contains(role)) {
                    userRole.remove(role);
                }
                role.getSysuserrole().clear();
                roleRepository.save(role);
            }
            userrepository.save(user);
        }
        roleRepository.deleteByRoleName(roleName);
    }

    @Transactional
    public void deleteAuthority(String authorityName) {
        List<SysUserRole> authorities = authorityRepository.findAllByAuthorityName(authorityName);
        List<SysRole> roles = roleRepository.findAll();
        //如果删除被维护端的数据，则把用户（维护端）的List中要移除的角色（被维护端）都remove掉
        for (SysRole role : roles) {
            List<SysUserRole> roleAuthoritis = role.getSysuserrole();
            for (SysUserRole authority : authorities) {
                if (roleAuthoritis.contains(authority)) {
                    roleAuthoritis.remove(authority);
                }
            }
            roleRepository.save(role);
        }
        authorityRepository.deleteByAuthorityName(authorityName);
    }

}
