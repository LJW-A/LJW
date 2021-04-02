package JieZhong.dao;

import JieZhong.entity.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<SysRole, Integer> {

    public List<SysRole> findAllByRoleName(String roleName);
    public void deleteByRoleName(String roleName);
}
