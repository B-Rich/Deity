package ca.bitjutsu.deity.entities;

import java.util.List;


public interface ActivityFeedItem {
	public String getId();
	public String getCreatedAt();
	public String getDescription();
	public String getText();
	public Followable getActor();
	public Followable getTarget();
	
	/* TODO: is this too general? */
	public List<Integer> getGenerators();
	
	/* Extra? */
	public List<User> getPromoters();
	public int getNumLikes();
	public int getNumComments();
}
