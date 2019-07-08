package bd.com.maestro.businessdump.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.stereotype.Service;

import bd.com.maestro.businessdump.models.RateChart;
import bd.com.maestro.businessdump.repositories.RateChartRepository;

@Service
public class PricingService {

	
	private RateChartRepository rateChartRepository;
	
	@Autowired
	public PricingService(RateChartRepository rateChartRepository) {
		this.rateChartRepository = rateChartRepository;
	}
	
	public void RateSaveOrUpdate(RateChart rateChart) {
		rateChartRepository.save(rateChart);
	}
	
	public RateChart RateFindById(Long id) {
		RateChart rateChart = rateChartRepository.findById(id).orElseThrow(
   				()-> new IllegalArgumentException("Not Found with this ID: "+id));
		return rateChart;
	}
	
	
	public DataTablesOutput<RateChart> getRateChart(DataTablesInput input){
		return rateChartRepository.findAll(input);
	}
	
	
}
