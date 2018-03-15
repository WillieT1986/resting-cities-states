package org.wecancodeit.restingcitiesstates;

import javax.annotation.Resource;

import org.junit.Test;

public class StateTest {

	@Resource
	StateRepository stateRepo;

	@Test
	public void shouldSaveAndLoadState() {
		State state = new State();
		state = stateRepo.save(state);
	}
}
