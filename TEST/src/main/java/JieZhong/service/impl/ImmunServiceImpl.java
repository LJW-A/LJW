package JieZhong.service.impl;

import JieZhong.dao.ImmuneMapper;
import JieZhong.entity.Immune;
import JieZhong.service.IImmuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImmunServiceImpl implements IImmuneService {

    @Autowired(required = false)
    private ImmuneMapper immuneMapper;

    @Override
    public List<Immune> getList() {
        return immuneMapper.getList();
    }

    @Override
    public Immune getById(int id) {
        return immuneMapper.getById(id);
    }

    @Override
    public Immune insert(Immune immune, String... errors) {
        int insert = immuneMapper.insert(immune);
        if (insert>0){
            return immune;
        }
        return null;
    }

    @Override
    public int update(Immune immune, String... errors) {
        int update = immuneMapper.update(immune);
        if(update>0){
            return update;
        }
        return 0;
    }

    @Override
    public int deleteById(int id) {
        return immuneMapper.deleteById(id);
    }

    @Override
    public List<Immune> selectListAll(int tag) {
        return immuneMapper.listAll(tag);
    }
}
