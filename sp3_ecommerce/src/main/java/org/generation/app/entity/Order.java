package org.generation.app.entity;

import java.sql.Timestamp;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name="Orders")
public class Order {

	@Id
	@GeneratedValue( strategy=GenerationType.IDENTITY)
	@Column(name="id_order")
	private Long id;
	@Column(name="order_date")
	private Timestamp orderDate;
	@Column(name="total", nullable=false)
	private Double total;
	
	@ManyToOne
	@JoinColumn(name="fk_user_id", nullable=false)
	private User user;
	
}
