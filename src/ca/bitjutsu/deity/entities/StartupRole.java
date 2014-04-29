package ca.bitjutsu.deity.entities;

import java.util.Iterator;

public interface StartupRole {
	public long getId();
	public boolean isConfirmed();
	public Startup getStartup();
	
	/* TODO: date format */
	public String getStartedAt();
	
	public String getRole();
	public long getCreatedAt();
	public long getEndedAt();
	public User getTagged();
	public String getTitle();
	
	/* Comments API */
	public Iterator<Comment> getComments();
	
	/* Likes API */
	public Iterator<Like> getLikes();
}
