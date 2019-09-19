package com.hcl.OnlineMarketing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.OnlineMarketing.Repository.StockRepository;
import com.hcl.OnlineMarketing.dto.StockResponseDto;
import com.hcl.OnlineMarketing.exception.StockNotAvaliableException;
import com.hcl.OnlineMarketing.exception.SufficientQuantityException;
import com.hcl.OnlineMarketing.model.Stock;

@Service
public class StockServiceImpl implements StockService {

   @Autowired
   StockRepository stockRepository;
	
	@Override
	public StockResponseDto findByNameAndQuantity(Long stockId, double quantity) {
		Stock stock= new Stock();
		StockResponseDto response= new StockResponseDto();
		
	 stock=stockRepository.findById(stockId).get();
	 
	 if(stock.getStockName().isEmpty()||stock.getStockName()==null)
	 {
	 throw new StockNotAvaliableException("Stock Not Avaliable");
	 }else
	 {
		if(stock.getQuantity()>=quantity) 
		{
			response.setPrice(stock.getPrice());
			response.setQuantity(stock.getQuantity());
			response.setStockId(stock.getStockId());
			response.setStockName(stock.getStockName());
			response.setMessage("Stack Avaliable Success...");
			response.setStatusCode(200);
			stock.setQuantity(stock.getQuantity()-quantity);
			stockRepository.save(stock);
		}else
		{
			throw new SufficientQuantityException("Sufficient Quantity is not avaliable");
		}
	 }	
		return response;
	}

	@Override
	public Stock findById(Long id) {
	
		return stockRepository.findById(id).get();
	}

}
