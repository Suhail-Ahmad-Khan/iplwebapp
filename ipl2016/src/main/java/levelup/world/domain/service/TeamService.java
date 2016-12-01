package levelup.world.domain.service;

import java.util.Collection;
import levelup.world.domain.Team;

public interface TeamService {

	public Collection<Team> getAllTeams();

	public Team getTeamById(int teamId);

	public Team getTeamByName(String teamName);

	public void saveTeam(Team team);

	public void deleteTeam(Team team);
}