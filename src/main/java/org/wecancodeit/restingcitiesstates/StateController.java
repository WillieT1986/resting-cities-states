package org.wecancodeit.restingcitiesstates;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StateController {

	@Resource
	StateRepository stateRepo;

	@RequestMapping("/show-states")
	public String findAllState(Model model) {
		model.addAttribute("states", stateRepo.findAll());
		return "states";
	}

	@RequestMapping("/state")
	public String findOneState(@RequestParam(value = "id") Long id, Model model) {
		model.addAttribute("state", stateRepo.findOne(id));
		return "state";
	}

}
