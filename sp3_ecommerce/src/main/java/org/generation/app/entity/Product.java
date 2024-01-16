package org.generation.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name="Products")
public class Product {
	@Id
	@GeneratedValue( strategy=GenerationType.IDENTITY)
	@Column(name="id_product")
	private Long id;
	@Column(name="title", nullable=false, length=45, unique=true)
	private String title;
	@Column(name="price", nullable=false)
	private Double price;
	@Column(name="description",nullable=false, length=300)
	private String description;
	@Column(name="width", nullable=false)
	private Double width;
	@Column(name="height", nullable=false)
	private Double heigth;
	@Column(name="color", nullable=false, length=25)
	private String color;
	@Column(name="img", nullable=false, length=500, unique=true)
	private String img;
	
	
	
	
	
	
	
}



