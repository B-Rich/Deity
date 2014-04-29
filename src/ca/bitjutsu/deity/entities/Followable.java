package ca.bitjutsu.deity.entities;

import java.util.Iterator;

public interface Followable {
	public long getId();
	public String getName();
	public String getAngelListUrl();
	public int getFollowerCount();
	
	/* Can be bio for User, HighLevel for Startup */
	public String getDescription();
	public String getImageUrl();
	
	/* Follows API */
	public boolean isFollowedBy(User user);
	public Iterator<User> getFollowers();
	public Iterator<Long> getFollowerIds();
	
	/* Status Updates API */
	public Iterator<StatusUpdate> getStatusUpdates();
}
