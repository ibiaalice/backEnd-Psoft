package dao;
import model.User;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO<T, ID extends Serializable> extends JpaRepository< User, Long> {
	User save(User user);

	User findByEmail(String email);


}
