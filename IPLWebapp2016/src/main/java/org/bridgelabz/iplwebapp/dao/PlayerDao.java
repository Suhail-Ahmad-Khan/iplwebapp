package org.bridgelabz.iplwebapp.dao;

import java.util.List;

import org.bridgelabz.iplwebapp.model.Player;

public interface PlayerDao {

	public void addPlayer(Player player);

	public List<Player> listAllPlayers(Integer teamId);

	public List<Player> listPlayerDetails(Integer id);

}
