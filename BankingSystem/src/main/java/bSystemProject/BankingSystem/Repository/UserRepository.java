package bSystemProject.BankingSystem.Repository;

import bSystemProject.BankingSystem.Module.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserInfo, Integer> {
}
