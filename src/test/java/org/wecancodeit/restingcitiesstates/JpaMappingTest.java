package org.wecancodeit.restingcitiesstates;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

public class JpaMappingTest {

	@Resource
	private TestEntityManager entityManager;

	@Resource
	StateRepository stateRepo;

	@Test
	public void shouldSaveAndLoadState() {
		State state = new State();
		state = stateRepo.save(state);
		long stateId = state.getId();

		entityManager.flush();
		entityManager.clear();

		state = stateRepo.findOne(stateId);
		assertThat(state.getStateName(), is("State Name"));
	}
}
