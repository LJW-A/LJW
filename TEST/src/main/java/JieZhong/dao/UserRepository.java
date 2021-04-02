package JieZhong.dao;

import JieZhong.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    public List<User> findAllByUserName(String userName);
    public void deleteByUserName(String userName);

}
