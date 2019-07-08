package bd.com.maestro.businessdump.repositories;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import bd.com.maestro.businessdump.models.RateChart;

public interface RateChartRepository extends JpaRepository<RateChart, Long>, DataTablesRepository<RateChart, Long> {
	
	

}
