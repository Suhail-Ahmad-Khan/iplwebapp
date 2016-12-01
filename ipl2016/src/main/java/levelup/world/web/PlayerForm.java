package levelup.world.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import levelup.world.domain.Player;
import levelup.world.domain.service.MockPlayerService;
import levelup.world.domain.service.PlayerService;
import levelup.world.domain.validation.PlayerValidator;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/playerForm.html")
@SessionAttributes("player")
public class PlayerForm {

	@Autowired
	private PlayerService playerService;
	
	private PlayerValidator playerValidator = new PlayerValidator();

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {

		dataBinder.setDisallowedFields(new String[] { "id" });
		dataBinder.setRequiredFields(
				new String[] { "playerName", "role", "battingStyle", "bowlingStyle", "nationality" });
		dataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(false));

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		dateFormat.setLenient(false);
		dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	@RequestMapping(method = RequestMethod.GET)
	public Player setUpForm(@RequestParam(value = "id", required = false) Integer playerId) {
		if (playerId == null) {
			return new Player();
		} else {
			return playerService.getPlayerById(playerId);
		}
	}

	@RequestMapping(params = "create", method = RequestMethod.POST)
	public String create(Player player, BindingResult result, SessionStatus status) {
		return update(player, result, status);
	}

	@RequestMapping(params = "update", method = RequestMethod.POST)
	public String update(Player player, BindingResult result, SessionStatus status) {
		playerValidator.validate(player, result);
		if (result.hasErrors()) {
			return "playerForm";
		} else {
			playerService.savePlayer(player);
			status.setComplete();
			return "redirect:playerList.html";
		}
	}

	@RequestMapping(params = "delete", method = RequestMethod.POST)
	public String delete(Player player, BindingResult result, SessionStatus status) {
		playerService.deletePlayer(player);
		status.setComplete();
		return "redirect:playerList.html";
	}
}