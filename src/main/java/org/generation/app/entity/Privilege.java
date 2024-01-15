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
@Table(name="Privileges")
public class Privilege {
	
	@Id
	@GeneratedValue( strategy=GenerationType.IDENTITY)
	@Column(name="id_privilege")
	private Long id;
	@Column(name="privilege", nullable=false, length=45)
	private String privilege;
	
	public Privilege(String privilege) {
		this.privilege = privilege;
	}
}
