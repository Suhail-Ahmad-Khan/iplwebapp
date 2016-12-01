package org.bridgelabz.iplwebapp.model;

import java.util.Date;

public class Player {

	private Long id;
	private Long teamId;
	private String profilePicture;
	private String role;
	private String battingStyle;
	private String bowlingStyle;
	private String nationality;
	private Date dateOfBirth;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTeamId() {
		return teamId;
	}

	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}
	
	public String getProfilePicture()
	{
		return profilePicture;
	}
	
	public void setProfilePicture(String profilePicture)
	{
		this.profilePicture = profilePicture;
	}
	
	public String getRole()
	{
		return role;
	}
	
	public void setRole(String role)
	{
		this.role = role;
	}
	
	public String getBattingStyle()
	{
		return battingStyle;
	}
	
	public void setBattingStyle(String battingStyle)
	{
		this.battingStyle = battingStyle;
	}
	
	public String getBowlingStyle()
	{
		return bowlingStyle;
	}
	
	public void setBowlingStyle(String bowlingStyle)
	{
		this.bowlingStyle = bowlingStyle;
	}
	
	public String getNationality()
	{
		return nationality;
	}
	
	public void setNationality(String nationality)
	{
		this.nationality = nationality;
	}
	
	public Date getDateOfBirth()
	{
		return dateOfBirth;
	}
	
	public void setDateOfBirth(Date dateOfBirth)
	{
		this.dateOfBirth = dateOfBirth;
	}

}
