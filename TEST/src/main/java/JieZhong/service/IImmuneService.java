package JieZhong.service;

import JieZhong.entity.Immune;

import java.util.List;

public interface IImmuneService {

    List<Immune> getList();

    Immune getById(int id);

    Immune insert(Immune immune, String... errors);

    int update(Immune immune, String... errors);

    int deleteById(int id);

    List<Immune> selectListAll(int tag);
}
