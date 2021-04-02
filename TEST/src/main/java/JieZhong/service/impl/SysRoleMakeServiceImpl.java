package JieZhong.service.impl;

import JieZhong.dao.SysRoleMakeMapper;
import JieZhong.entity.SysRoleMake;
import JieZhong.service.ISysRoleMakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysRoleMakeServiceImpl implements ISysRoleMakeService {

    @Autowired(required = false)
    private SysRoleMakeMapper sysRoleMakeMapper;



    @Override
    public List<SysRoleMake> QueryList(int hospitalid) {
        return sysRoleMakeMapper.QueryList(hospitalid);
    }

    @Override
    public List<SysRoleMake>  getById(int id) {
        return sysRoleMakeMapper.getById(id);
    }

    @Override
    public SysRoleMake insert(SysRoleMake sysRoleMake, String... errors) {
        int insert = sysRoleMakeMapper.insert(sysRoleMake);
        if(insert>0){
            return sysRoleMake;
        }
        return null;
    }

    @Override
    public int update(SysRoleMake sysRoleMake, String... errors) {
        return sysRoleMakeMapper.update(sysRoleMake);
    }

    @Override
    public int deleteById(int id) {
        return sysRoleMakeMapper.deleteById(id);
    }
}
