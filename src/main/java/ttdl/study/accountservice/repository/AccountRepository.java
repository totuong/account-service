package ttdl.study.accountservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ttdl.study.accountservice.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{

}
