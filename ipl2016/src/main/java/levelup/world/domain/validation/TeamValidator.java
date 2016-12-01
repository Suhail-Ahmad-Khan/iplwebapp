package levelup.world.domain.validation;

import levelup.world.domain.Team;
import levelup.world.domain.service.MockTeamService;
import levelup.world.domain.service.TeamService;
import org.springframework.validation.Errors;

public class TeamValidator {

	private TeamService teamService = new MockTeamService();

	public void validate(Team team, Errors errors) {

		if (team.getId() <= 0) {
			errors.rejectValue("Id", "validation.negative", "must be > 0");
		}

		if (!errors.hasFieldErrors("name")) {
			Team existingTeam = teamService.getTeamByName(team.getTeamName());
			if (existingTeam != null && (team.isNew() || !(team.getId() == (existingTeam.getId())))) {
				errors.rejectValue("name", "validation.exists", "exists");
			}
		}
	}
}
