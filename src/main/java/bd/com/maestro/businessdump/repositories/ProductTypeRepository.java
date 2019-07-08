package bd.com.maestro.businessdump.repositories;

import java.util.Collection;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import bd.com.maestro.businessdump.models.ProductType;

public interface ProductTypeRepository extends JpaRepository<ProductType, Long>, DataTablesRepository<ProductType, Long>{

	@Query("select new bd.com.maestro.businessdump.models.ProductType(h.id, h.name)  from ProductType h")
	Collection<ProductType> getIdAndNameOnly();
}
