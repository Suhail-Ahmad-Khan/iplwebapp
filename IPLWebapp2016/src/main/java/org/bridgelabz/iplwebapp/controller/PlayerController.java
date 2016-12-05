package org.bridgelabz.iplwebapp.controller;

import java.io.FileReader;
import java.util.List;

import org.bridgelabz.iplwebapp.model.Player;
import org.bridgelabz.iplwebapp.service.PlayerService;
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
public class PlayerController {

	@Autowired
	PlayerService playerService;

	@RequestMapping(value = "/addPlayer", method = RequestMethod.GET)
	public String addPlayer() {
		Player player = new Player();
		JSONParser parser = new JSONParser();

		try {
			Object object = parser.parse(new FileReader("/home/bridgeit/Desktop/Player1.json"));
			JSONObject PlayerManagement = (JSONObject) object;
			JSONArray PlayerList = (JSONArray) PlayerManagement.get("Playersinfo");
			String[] PlayerNames = new String[] { "Akhil", "Amit", "Carlos", "Chama", "Imran", "Jayant", "Duminy",
					"Karun", "Khaleel", "Mahipal", "Mayank", "Mohammed", "Nathan", "Pawan", "Pawan_Suyal", "Quinton",
					"Pratyush", "Rishabh", "Sam", "Sanju", "Shahbaz", "Shreyas", "Zaheer", "Virat", "Varun", "Abu",
					"Sreenath", "Samuel", "Stuart", "Yuzvendra", "AB", "Praveen", "Chris", "Travis", "Iqbal", "Kedar",
					"Akshay", "Sarfaraz", "Vikramjeet", "Mandeep", "Adam", "Harshal", "Lokesh", "Parveez", "Kane",
					"Sachin", "Mitchell", "Vikas", "Shane", "David", "Tabraiz", "Chris" };

			for (int y = 0; y < PlayerList.size(); y++) {

				JSONObject PlayerName = (JSONObject) PlayerList.get(y);
				JSONArray Players = (JSONArray) PlayerName.get(PlayerNames[y]);
				/* System.out.println(PlayerNames[y]); */

				for (int i = 0; i < Players.size(); i++) {

					JSONObject PlayerDetails = (JSONObject) Players.get(i);
					Object nameObj = PlayerDetails.get("player_name");
					String playerName = (String) nameObj;
					player.setName(playerName);

					Object imageObj = PlayerDetails.get("player_img_url");
					String image = (String) imageObj;
					player.setImage(image);

					Object teamIdObj = PlayerDetails.get("team_id");
					/* Integer teamId = Integer.parseInt((String)teamIdObj); */
					Integer teamIdName = Integer.valueOf((String) teamIdObj);
					player.setTeamId(teamIdName);

					Object roleObj = PlayerDetails.get("player_role");
					String role = (String) roleObj;
					player.setRole(role);

					Object battingStyleObj = PlayerDetails.get("player_batting_style");
					String battingStyle = (String) battingStyleObj;
					player.setBattingStyle(battingStyle);

					Object bowlingStyleObj = PlayerDetails.get("player_bowling_style");
					String bowlingStyle = (String) bowlingStyleObj;
					player.setBowlingStyle(bowlingStyle);

					Object nationalityObj = PlayerDetails.get("player_nationality");
					String nationality = (String) nationalityObj;
					player.setNationality(nationality);

					Object DOBObj = PlayerDetails.get("player_dob");
					String DOB = (String) DOBObj;
					player.setDOB(DOB);

					playerService.addPlayer(player);

				}
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return "login";
	}

	@RequestMapping(value = "/PlayerList", method = RequestMethod.GET)
	public ModelAndView listAllPlayer(@RequestParam("teamId") Integer teamId, Model model) {
		List<Player> playerInfo = playerService.listAllPlayers(teamId);

		return new ModelAndView("PlayerList", "playerInfo", playerInfo);

	}

	@RequestMapping(value = "/playerDetails", method = RequestMethod.GET)
	public ModelAndView displayPlayerDetails(@RequestParam("id") Integer id, Model model) {
		List<Player> playerDetails = playerService.listPlayerDetails(id);
		/*model.addAttribute("msg", id);*/
		return new ModelAndView("playerDetails", "playerDetails", playerDetails);

	}

}
