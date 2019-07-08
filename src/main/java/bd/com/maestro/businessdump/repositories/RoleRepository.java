package bd.com.maestro.businessdump.repositories;

import java.util.Collection;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import bd.com.maestro.businessdump.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long>, DataTablesRepository<Role, Long> {
	/*
	@Query("select new bd.com.maestro.businessdump.models.Role(h.id, h.name)  from Role h")
	Collection<Role> getIdAndNameOnly();
	*/
	
	@Query("select new bd.com.maestro.businessdump.models.Role(h.id, h.name)  from Role h where (h.id > :roleId and h.id <= :roleMaxId ) or h.id > 9")
	Collection<Role> getIdAndNameOnly(@Param("roleId")Long roleId, @Param("roleMaxId")Long roleMaxId);
	
}
