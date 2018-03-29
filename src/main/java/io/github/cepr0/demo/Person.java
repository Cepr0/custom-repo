package io.github.cepr0.demo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import java.time.LocalDateTime;

import static com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties("createdAt")
@Entity
@DynamicInsert
@DynamicUpdate
public class Person extends BaseEntity {

	private String name;

	@JsonFormat(shape = STRING)
	private LocalDateTime createdAt;

	public Person(String name) {
		this.name = name;
	}
	
	@Override
	protected void prePersist() {
		super.prePersist();
		createdAt = LocalDateTime.now();
	}
}
