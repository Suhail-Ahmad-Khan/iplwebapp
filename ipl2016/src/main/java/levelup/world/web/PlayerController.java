package levelup.world.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import levelup.world.domain.Player;
import levelup.world.domain.service.PlayerService;

@Controller
public class PlayerController {

	@Autowired
	// @Qualifier("playerService") - no need this because name are the same in
	// config and here
	private PlayerService playerService;

	@RequestMapping(value = "/playerList.html", params = "teamId")
	@ModelAttribute("players")
	public List<Player> getPlayers(@RequestParam(value = "teamId", required = true) int playerTeamId) {
		return playerService.getPlayersByTeams(playerTeamId);
	}

	@RequestMapping(value = "/playerDetails.html", params = "id")
	public Player getPlayer(@RequestParam(value = "id", required = true) int playerId) {
		return playerService.getPlayerById(playerId);
	}
}