package com.hcl.OnlineMarketing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.OnlineMarketing.dto.StockRequestDto;
import com.hcl.OnlineMarketing.dto.StockResponseDto;
import com.hcl.OnlineMarketing.model.Stock;
import com.hcl.OnlineMarketing.service.StockService;


@RestController
public class MarketingController {
	
	@Autowired
	StockService StockService; 
	
	@PutMapping("/buyStock/{id}")
	public ResponseEntity<StockResponseDto> getStock(@PathVariable("id") Long stockId,@RequestBody StockRequestDto stock )
	{
		return new ResponseEntity<>(StockService.findByNameAndQuantity(stock.getStockId(), stock.getQuantity()),HttpStatus.OK);

	}
	
	@GetMapping("/getStock/{id}")
	public Stock getStocks(@PathVariable("id") Long id)
	{
		return StockService.findById(id);

	}
	

}
