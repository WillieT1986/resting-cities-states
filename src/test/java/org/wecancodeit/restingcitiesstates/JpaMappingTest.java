package org.wecancodeit.restingcitiesstates;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class JpaMappingTest {

	@Resource
	private TestEntityManager entityManager;

	@Resource
	StateRepository stateRepo;

	@Resource
	CityRepository cityRepo;

	@Test
	public void shouldSaveAndLoadState() {
		State state = new State(null, "State Name");
		state = stateRepo.save(state);
		long stateId = state.getId();

		entityManager.flush();
		entityManager.clear();

		state = stateRepo.findOne(stateId);
		assertThat(state.getStateName(), is("State Name"));
	}

	@Test
	public void shouldSaveCityToStateRelationship() {
		City city = new City("City Name");
		cityRepo.save(city);
		long cityId = city.getId();

		State first = new State(city, "State Name");
		first = stateRepo.save(first);

		State second = new State(city, "State Name");
		second = stateRepo.save(second);
	}
}
