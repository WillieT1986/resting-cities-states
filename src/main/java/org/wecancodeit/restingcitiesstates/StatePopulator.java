package org.wecancodeit.restingcitiesstates;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StatePopulator implements CommandLineRunner {

	@Resource
	private StateRepository stateRepo;

	@Resource
	private CitiesRepository cityRepo;

	@Override
	public void run(String... args) throws Exception {
		State ohio = new State("Ohio");
		State virginia = new State("Virginia");
		State nevada = new State("Nevada");

		stateRepo.save(ohio);
		stateRepo.save(virginia);
		stateRepo.save(nevada);

		Cities columbus = new Cities("Columbus", ohio);
		Cities cleveland = new Cities("Cleveland", ohio);
		Cities wooster = new Cities("Wooster", ohio);
		Cities roanoke = new Cities("Roanoke", virginia);
		Cities bluefield = new Cities("Bluefield", virginia);
		Cities reno = new Cities("Reno", nevada);

		cityRepo.save(columbus);
		cityRepo.save(cleveland);
		cityRepo.save(wooster);
		cityRepo.save(roanoke);
		cityRepo.save(bluefield);
		cityRepo.save(reno);
	}
}