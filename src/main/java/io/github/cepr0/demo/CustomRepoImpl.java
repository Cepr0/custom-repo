package io.github.cepr0.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class CustomRepoImpl implements CustomRepo {

	private final JpaRepository<Person, Integer> personRepo;

	public CustomRepoImpl(JpaRepository<Person, Integer> personRepo) {
		this.personRepo = personRepo;
	}

	@Override
	public Person customSave(Person person) {
		return personRepo.save(person);
	}
}
