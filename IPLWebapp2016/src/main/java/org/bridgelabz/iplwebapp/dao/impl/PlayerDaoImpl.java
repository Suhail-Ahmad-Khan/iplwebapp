package org.bridgelabz.iplwebapp.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.bridgelabz.iplwebapp.dao.PlayerDao;
import org.bridgelabz.iplwebapp.model.Player;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class PlayerDaoImpl implements PlayerDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void addPlayer(Player player) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.save(player);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<Player> listAllPlayers(Integer teamId) {
		Session session = sessionFactory.getCurrentSession();
		Query<Player> query = session.createQuery("from Player");
		List<Player> playerList = query.getResultList();

		List<Player> teamPlayers = new ArrayList<Player>();
		for (Player player : playerList) {
			if (player.getTeamId() == teamId) {
				teamPlayers.add(player);
			}
		}
		return teamPlayers;
	}

	public List<Player> listPlayerDetails(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Query<Player> query = session.createQuery("from Player where id=:id");
		query.setParameter("id", id);
		List<Player> playerDetails = query.getResultList();
		return playerDetails;
	}
}
