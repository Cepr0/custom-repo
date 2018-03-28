package io.github.cepr0.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomRepoImplTest {

	@Autowired private CustomRepo customRepo;
	@Autowired private PersonRepo personRepo;

	@Test
	public void customSave() {
		customRepo.customSave(new Person("person1"));
		assertThat(personRepo.count()).isEqualTo(1L);
	}
}