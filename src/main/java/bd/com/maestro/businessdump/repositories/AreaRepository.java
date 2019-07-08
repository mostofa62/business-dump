package bd.com.maestro.businessdump.repositories;

import java.util.Collection;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import bd.com.maestro.businessdump.models.Area;

public interface AreaRepository extends JpaRepository<Area, Long>, DataTablesRepository<Area, Long> {

	@Query("select new bd.com.maestro.businessdump.models.Area(h.id, h.name)  from Area h")
	Collection<Area> getIdAndNameOnly();
}
