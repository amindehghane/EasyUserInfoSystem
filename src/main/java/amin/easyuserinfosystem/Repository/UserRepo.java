package amin.easyuserinfosystem.Repository;

import amin.easyuserinfosystem.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {

}
