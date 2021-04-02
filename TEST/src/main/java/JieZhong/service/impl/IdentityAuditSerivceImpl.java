package JieZhong.service.impl;

import JieZhong.dao.IdentityAuditMapper;
import JieZhong.entity.IdentityAudit;
import JieZhong.service.IdentityAuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IdentityAuditSerivceImpl implements IdentityAuditService {

    @Autowired(required = false)
    private IdentityAuditMapper identityAuditMapper;


    @Override
    public List<IdentityAudit> getList() {
        return identityAuditMapper.getList();
    }

    @Override
    public IdentityAudit getById(int id) {
        return identityAuditMapper.getById(id);
    }

    @Override
    public IdentityAudit insert(IdentityAudit identityAudit, String... errors) {
        int insert = identityAuditMapper.insert(identityAudit);
        if(insert>0){
            return identityAudit;
        }
        return null;
    }

    @Override
    public int update(IdentityAudit identityAudit, String... errors) {
        return identityAuditMapper.update(identityAudit);
    }

    @Override
    public int deleteById(int id) {
        return identityAuditMapper.deleteById(id);
    }
}
