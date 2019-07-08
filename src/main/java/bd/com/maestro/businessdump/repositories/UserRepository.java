package bd.com.maestro.businessdump.repositories;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import bd.com.maestro.businessdump.models.User;

public interface UserRepository extends JpaRepository<User, Long>, DataTablesRepository<User, Long> {

	User findFirst1ByUserName(String name);
}
