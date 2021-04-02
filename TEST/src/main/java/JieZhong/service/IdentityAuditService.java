package JieZhong.service;

import JieZhong.entity.IdentityAudit;

import java.util.List;

public interface IdentityAuditService {

    List<IdentityAudit> getList();

    IdentityAudit getById(int id);

    IdentityAudit insert(IdentityAudit identityAudit, String... errors);

    int update(IdentityAudit identityAudit, String... errors);

    int deleteById(int id);
}
