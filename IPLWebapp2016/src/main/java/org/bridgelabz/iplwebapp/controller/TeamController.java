package org.bridgelabz.iplwebapp.controller;

import java.io.FileReader;
import java.util.List;

import org.bridgelabz.iplwebapp.model.Team;
import org.bridgelabz.iplwebapp.service.TeamService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TeamController {

	@Autowired
	TeamService teamService;

	@RequestMapping(value = "/addTeam", method = RequestMethod.GET)
	public String addTeam() {
		Team team = new Team();
		JSONParser parser = new JSONParser();

		try {
			Object object = parser.parse(new FileReader("/home/bridgeit/Desktop/Information.json"));
			JSONObject TeamManagement = (JSONObject) object;
			JSONArray TeamList = (JSONArray) TeamManagement.get("teaminfo");
			String[] TeamNames = new String[] { "DD", "GL", "KP", "KKR", "MU", "RPS", "RCB", "SH" };

			for (int y = 0; y < TeamList.size(); y++) {

				JSONObject TeamName = (JSONObject) TeamList.get(y);
				JSONArray Teams = (JSONArray) TeamName.get(TeamNames[y]);
				System.out.println(TeamNames[y]);

				for (int i = 0; i < Teams.size(); i++) {

					JSONObject TeamDetails = (JSONObject) Teams.get(i);
					Object nameObj = TeamDetails.get("team_name");
					String teamName = (String) nameObj;
					team.setName(teamName);

					Object coachObj = TeamDetails.get("team_coach");
					String coachName = (String) coachObj;
					team.setCoachName(coachName);

					Object capatainObj = TeamDetails.get("team_captain");
					String capatainName = (String) capatainObj;
					team.setCaptainName(capatainName);

					Object venueObj = TeamDetails.get("team_home_venue");
					String venueName = (String) venueObj;
					team.setHomeVenue(venueName);

					Object ownerObj = TeamDetails.get("team_owner");
					String ownerName = (String) ownerObj;
					team.setOwnerName(ownerName);

					Object logoObj = TeamDetails.get("team_img_url");
					String logoName = (String) logoObj;
					team.setLogo(logoName);
					teamService.addTeam(team);
					
				}
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return "login";
	}

	@RequestMapping(value = "/teamList", method = RequestMethod.POST)
	public ModelAndView listAllTeam() {
		List teamInfo = teamService.listAllTeams();

		return new ModelAndView("teamList", "teamInfo",teamInfo);

	}

	@RequestMapping(value = "/teamDetails", method = RequestMethod.GET)
	public ModelAndView displayTeamDetails(@RequestParam("teamName") String teamName, Model model) {
		List teamDetails = teamService.listTeamDetails(teamName);
		model.addAttribute("msg", teamName);
		return new ModelAndView("teamDetails", "teamDetails", teamDetails);

	}
}