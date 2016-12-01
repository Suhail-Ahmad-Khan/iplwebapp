package levelup.world.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import levelup.world.domain.Team;
import levelup.world.domain.service.MockTeamService;
import levelup.world.domain.service.TeamService;
import levelup.world.domain.validation.TeamValidator;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/teamForm.html")
@SessionAttributes("team")
public class TeamForm {

	private TeamService teamService = new MockTeamService();

	private TeamValidator teamValidator = new TeamValidator();

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {

		dataBinder.setDisallowedFields(new String[] { "id" });
		dataBinder.setRequiredFields(
				new String[] { "teamName", "coachName", "ownerName", "captainName", "logo", "homeVenue" });
		dataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(false));

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		dateFormat.setLenient(false);
		dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	@RequestMapping(method = RequestMethod.GET)
	public Team setUpForm(@RequestParam(value = "id", required = false) Integer teamId) {
		if (teamId == null) {
			return new Team();
		} else {
			return teamService.getTeamById(teamId);
		}
	}

	@RequestMapping(params = "create", method = RequestMethod.POST)
	public String create(Team team, BindingResult result, SessionStatus status) {
		return update(team, result, status);
	}

	@RequestMapping(params = "update", method = RequestMethod.POST)
	public String update(Team team, BindingResult result, SessionStatus status) {
		teamValidator.validate(team, result);
		if (result.hasErrors()) {
			return "teamForm";
		} else {
			teamService.saveTeam(team);
			status.setComplete();
			return "redirect:countryList.html";
		}
	}

	@RequestMapping(params = "delete", method = RequestMethod.POST)
	public String delete(Team team, BindingResult result, SessionStatus status) {
		teamService.deleteTeam(team);
		status.setComplete();
		return "redirect:teamList.html";
	}

}