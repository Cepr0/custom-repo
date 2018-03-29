package io.github.cepr0.demo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.Identifiable;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Sergei Poznanski, 2018-03-29
 */
@MappedSuperclass
public class BaseEntity implements Identifiable<Integer> {
	
	private static final AtomicInteger COUNTER = new AtomicInteger();
	
	@Id
	@Getter
	@Setter
	private Integer id;
	
	public BaseEntity() {
	}
	
	@PrePersist
	protected void prePersist() {
		if (id == null) {
			id = COUNTER.incrementAndGet();
		}
	}
	
	@Override
	public String toString() {
		return "{id=" + id +	'}';
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		BaseEntity that = (BaseEntity) o;
		return Objects.equals(id, that.id);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
