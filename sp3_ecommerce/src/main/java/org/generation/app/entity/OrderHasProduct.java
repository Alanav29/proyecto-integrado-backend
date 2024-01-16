package org.generation.app.entity;

import org.generation.app.entity.compositeKey.OrderProductKey;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
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
@Table(name="orders_has_products")
public class OrderHasProduct {

	@EmbeddedId
	OrderProductKey id;
	
	@ManyToOne
	@MapsId("orderId" )
	@JsonIgnoreProperties("user")
	private Order order;
	
	@ManyToOne
	@MapsId("productId" )
	private Product product;
}
