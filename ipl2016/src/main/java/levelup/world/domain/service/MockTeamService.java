package levelup.world.domain.service;

import levelup.world.domain.Team;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MockTeamService implements TeamService {

	private static Map<Integer, Team> teams = new HashMap<Integer, Team>();
	private static int nextTeamId = 200;

	static {
		teams.put(1, new Team(1, "Royal Challengers Bangalore", "Anil Kumble", "Vijay Mallya", "Virat Kohli", "Bangalore"));
		teams.put(2, new Team(2, "Sunisers Hyderabad", "Tom Moody", "Kalanithi Maran", "David Warner", "Hyderabad"));
		teams.put(3, new Team(3, "Kolkata Knight Riders", "Jacques Kallis", "Shahrukh Khan", "Gautam Gambhir", "Kolkata"));
		teams.put(4, new Team(4, "Chennai Superkings", "Anil Kumble", "Vijay Mallya", "Virat Kohli", "Bangalore"));
		teams.put(5, new Team(5, "Mumbai Indians", "Anil Kumble", "Vijay Mallya", "Virat Kohli", "Bangalore"));
		teams.put(6, new Team(6, "Kings XI Punjab", "Anil Kumble", "Vijay Mallya", "Virat Kohli", "Bangalore"));
		teams.put(7, new Team(7, "Gujarat Lions", "Anil Kumble", "Vijay Mallya", "Virat Kohli", "Bangalore"));
	}

	public Collection<Team> getAllTeams() {
		return teams.values();
	}

	public Team getTeamById(int teamId) {
		// Returns a new object and not just a reference
		// to an object in the collection.
		Team team = teams.get(teamId);
		return new Team(team.getId(), team.getTeamName(), team.getCoachName(), team.getOwnerName(),
				team.getCaptainName(), team.getHomeVenue());
	}

	public Team getTeamByName(String teamName) {
		for (Team team : teams.values()) {
			if (team.getTeamName().toLowerCase().equals(teamName.toLowerCase())) {
				return team;
			}
		}
		return null;
	}

	public void saveTeam(Team team) {
		if (team.isNew()) {
			nextTeamId++;
			team.setId(nextTeamId);
			teams.put(nextTeamId, team);
		} else {
			teams.put(team.getId(), team);
		}
	}

	public void deleteTeam(Team team) {
		teams.remove(team.getId());
	}
}
