package com.hcl.OnlineMarketing.service;

import com.hcl.OnlineMarketing.dto.StockResponseDto;
import com.hcl.OnlineMarketing.model.Stock;
public interface StockService {
	
	public StockResponseDto findByNameAndQuantity(Long stockId,double quantity);
	
	public Stock findById(Long id);

}
