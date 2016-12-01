package levelup.world.domain.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import levelup.world.domain.Player;

public class MockPlayerService implements PlayerService {

	static List<Player> allPlayerList = new ArrayList<Player>();

	static {
		Player player1 = new Player(1, 1, "Virat Kohli", "batsman", "right handed", "right handed", "indian",
				parseDate("30-nov-1984"));
		Player player2 = new Player(2, 2, "Bhubaneshwar Kumar", "bowler", "right handed", "right handed", "indian",
				parseDate("30-nov-1984"));
		Player player3 = new Player(3, 3, "Andre Russell", "all rounder", "right handed", "right handed", "indian",
				parseDate("30-nov-1984"));
		Player player4 = new Player(4, 4, "Murali Vijay", "batsman", "right handed", "right handed", "indian",
				parseDate("30-nov-1984"));
		Player player5 = new Player(5, 1, "Keiron Pollard", "bowler", "right handed", "right handed", "indian",
				parseDate("30-nov-1984"));
		Player player6 = new Player(6, 2, "Glenn Maxwell", "all rounder", "right handed", "right handed", "indian",
				parseDate("30-nov-1984"));
		Player player7 = new Player(7, 3, "Suresh Raina", "batsman", "right handed", "right handed", "indian",
				parseDate("30-nov-1984"));
		Player player8 = new Player(8, 4, "Albie Morkel", "bowler", "right handed", "right handed", "indian",
				parseDate("30-nov-1984"));

		allPlayerList.add(player1);
		allPlayerList.add(player2);
		allPlayerList.add(player3);
		allPlayerList.add(player4);
		allPlayerList.add(player5);
		allPlayerList.add(player6);
		allPlayerList.add(player7);
		allPlayerList.add(player8);

	}

	private static Date parseDate(String textDate) {
		try {
			return new SimpleDateFormat("dd-MMM-yyyy").parse(textDate);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public List<Player> getPlayersByTeams(int playerTeamId) {

		List<Player> teamPlayers = new ArrayList<Player>();
		for (Player player : allPlayerList) {
			if (player.getTeamId() == playerTeamId) {
				teamPlayers.add(player);
			}
		}
		return teamPlayers;
	}

	public Player getPlayerById(int playerId) {
		for (Player player : allPlayerList) {
			if (player.getId() == playerId) {
				return player;
			}
		}
		return null;
	}

	public Player getPlayerByName(String playerName) {
		for (Player player : allPlayerList) {
			if (player.getPlayerName().toLowerCase().equals(playerName.toLowerCase())) {
				return player;
			}
		}
		return null;
	}

	/*
	 * public void savePlayer(Player player) { if (player.isNew()) {
	 * nextPlayerId++; player.setId(nextPlayerId);
	 * allPlayerList.put(nextPlayerId, player); } else {
	 * allPlayerList.put(player.getId(), player); } }
	 */

	public void deletePlayer(Player player) {
		allPlayerList.remove(player.getId());
	}

	public void savePlayer(Player player) {
		// TODO Auto-generated method stub

	}

}