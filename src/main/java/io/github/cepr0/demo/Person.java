package io.github.cepr0.demo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.Identifiable;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

import static com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING;

@Data
@NoArgsConstructor
@JsonIgnoreProperties("createdAt")
@Entity
public class Person implements Identifiable<Integer> {

	private static final AtomicInteger COUNTER = new AtomicInteger();

	@Id
	private Integer id = COUNTER.incrementAndGet();

	private String name;

	@JsonFormat(shape = STRING)
//	@JsonProperty(access = READ_ONLY)
	private LocalDateTime createdAt = LocalDateTime.now();

	public Person(String name) {
		this.name = name;
	}
}
