package org.wecancodeit.restingcitiesstates;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/states")
public class StateRestController {

	@Resource
	private StateRepository stateRepo;

	@RequestMapping("")
	public Iterable<State> finalAddStates(@RequestParam(defaultValue = "") String search,
			@RequestParam(defaultValue = "") String advanced) throws InterruptedException {
		if (search.isEmpty()) {
			if (advanced.isEmpty()) {
				return stateRepo.findAll();
			}
			return stateRepo.findByDescriptionIgnoreCaseLike(advanced.replace('*', '%'));
		}
		return stateRepo.findByDescriptionIgnoreCaseContains(search);
	}

	@RequestMapping("/{id")
	public State findOneState(@PathVariable long id) {
		return stateRepo.findOne(id);
	}
}