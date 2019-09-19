package com.hcl.OnlineMarketing.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Stock {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long stockId;
	private String stockName;
	private double quantity;
	private double price;
	
	
}
