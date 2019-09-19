package com.hcl.OnlineMarketing.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.OnlineMarketing.model.Stock;

@Repository
public interface StockRepository  extends JpaRepository<Stock,Long>{

	@Query(value="select * from stock where stock_name=?",nativeQuery=true)
	public Stock getStock(String name);
	
}
