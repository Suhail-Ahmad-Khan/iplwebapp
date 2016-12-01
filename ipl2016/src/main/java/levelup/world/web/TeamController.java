package levelup.world.web;

import java.util.Collection;
import levelup.world.domain.Team;
import levelup.world.domain.service.MockTeamService;
import levelup.world.domain.service.TeamService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TeamController {

	private TeamService teamService = new MockTeamService();

	@RequestMapping("/teamList.html")
	@ModelAttribute("teams")
	public Collection<Team> getTeams() {
		return teamService.getAllTeams();
	}

	@RequestMapping("/teamDetails.html")
	public Team getTeam(@RequestParam(value = "id", required = true) int teamId) {
		return teamService.getTeamById(teamId);
	}
}