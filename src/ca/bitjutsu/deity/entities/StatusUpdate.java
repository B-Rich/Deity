package ca.bitjutsu.deity.entities;

import java.util.Iterator;

public interface StatusUpdate {
	public long getId();
	public String getMessage();
	public long getCreatedAt();
	
	/* Comments API */
	public Iterator<Comment> getComments();
	
	/* Likes API */
	public Iterator<Like> getLikes();
}
