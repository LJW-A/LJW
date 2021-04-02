package JieZhong.dao;

import JieZhong.entity.SysUserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<SysUserRole, Integer> {

    public List<SysUserRole> findAllByAuthorityName(String authorityName);
    public void deleteByAuthorityName(String authorityName);
}
