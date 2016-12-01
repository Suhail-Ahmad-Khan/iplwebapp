package levelup.world.domain.validation;

import levelup.world.domain.Player;
import levelup.world.domain.service.MockPlayerService;
import levelup.world.domain.service.PlayerService;
import org.springframework.validation.Errors;

public class PlayerValidator {

	private PlayerService playerService = new MockPlayerService();

	public void validate(Player player, Errors errors) {

		if (player.getTeamId() != null && player.getTeamId() <= 0) {
			errors.rejectValue("TeamId", "validation.negative", "must be > 0");
		}

		if (!errors.hasFieldErrors("name")) {
			Player existingPlayer = playerService.getPlayerByName(player.getPlayerName());
			if (existingPlayer != null && (player.isNew() || !player.getId().equals(existingPlayer.getId()))) {
				errors.rejectValue("name", "validation.exists", "exists");
			}
		}
	}

}