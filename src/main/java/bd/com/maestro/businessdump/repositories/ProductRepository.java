package bd.com.maestro.businessdump.repositories;

import java.util.Collection;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import bd.com.maestro.businessdump.models.Product;


public interface ProductRepository extends JpaRepository<Product, Long>, DataTablesRepository<Product, Long> {

	@Query("select new bd.com.maestro.businessdump.models.Product(h.id, h.name)  from Product h")
	Collection<Product> getIdAndNameOnly();
}
