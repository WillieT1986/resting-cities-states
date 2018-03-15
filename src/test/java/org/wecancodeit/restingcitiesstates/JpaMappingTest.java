package org.wecancodeit.restingcitiesstates;

import static org.hamcrest.Matchers.containsInAnyOrder;
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
	CitiesRepository cityRepo;

	@Test
	public void shouldSaveAndLoadState() {
		State state = new State("State Name");
		state = stateRepo.save(state);
		long stateId = state.getId();

		entityManager.flush();
		entityManager.clear();

		state = stateRepo.findOne(stateId);
		assertThat(state.getStateName(), is("State Name"));
	}

	@Test
	public void shouldSaveCityToStateRelationship() {
		State state = new State("City Name");
		stateRepo.save(state);
		long stateId = state.getId();

		Cities first = new Cities(state, "City Name");
		first = cityRepo.save(first);

		Cities second = new Cities(state, "City Name");
		second = cityRepo.save(second);

		entityManager.flush();
		entityManager.clear();

		state = stateRepo.findOne(stateId);
		assertThat(state.getCities(), containsInAnyOrder(first, second));
	}
}
