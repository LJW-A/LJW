package JieZhong.service;

import JieZhong.entity.SysRoleMake;

import java.util.List;

public interface ISysRoleMakeService {

    List<SysRoleMake> QueryList(int hospitalid);


    List<SysRoleMake>  getById(int id);

    SysRoleMake insert(SysRoleMake sysRoleMake, String... errors);

    int update(SysRoleMake sysRoleMake, String... errors);

    int deleteById(int id);
}
