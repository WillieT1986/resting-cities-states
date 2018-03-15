package org.wecancodeit.restingcitiesstates;

import org.springframework.data.repository.CrudRepository;

public interface StateRepository extends CrudRepository<State, Long> {

	Iterable<State> findByDescriptionIgnoreCaseLike(String search);

	Iterable<State> findByDescriptionIgnoreCaseContains(String search);
}
