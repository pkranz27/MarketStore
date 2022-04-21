package com.tts.Market.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Product {// This sets a model for us to use as a object to interact with and the attributes that they will have and are able to be manipulated
	@Id// Sets as the type of id will be read
	@GeneratedValue(strategy = GenerationType.AUTO)    // Value which we generate the id by
	@Column(name="product_id")// contorls the name of the coulmn in the dtatabase
	@NotNull
	private Long id;
	
	private int quantity;
	private double price;
	
	private String description;
	private String name;
	private String brand;
	private String category;
	private String image;
	
	
}
