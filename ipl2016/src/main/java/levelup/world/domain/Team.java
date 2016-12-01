package levelup.world.domain;

public class Team {

	private Integer id;
	private String teamName;
	private String coachName;
	private String ownerName;
	private String captainName;
	private String homeVenue;

	public Team() {
	}

	public Team(Integer id, String teamName, String coachName, String ownerName, String captainName, String homeVenue) {
		setId(id);
		setTeamName(teamName);
		setCoachName(coachName);
		setOwnerName(ownerName);
		setCaptainName(captainName);
		setHomeVenue(homeVenue);
	}

	public boolean isNew() {
		return id == null;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getCoachName() {
		return coachName;
	}

	public void setCoachName(String coachName) {
		this.coachName = coachName;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getCaptainName() {
		return captainName;
	}

	public void setCaptainName(String captainName) {
		this.captainName = captainName;
	}

	public String getHomeVenue() {
		return homeVenue;
	}

	public void setHomeVenue(String homeVenue) {
		this.homeVenue = homeVenue;
	}

}
