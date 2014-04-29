package ca.bitjutsu.deity.entities;

import java.util.Iterator;

public interface Comment {
	public long getId();
	public String getCommentText();
	public long getCreatedAt();
	public User getUser();
	
	/* Likes API */
	public Iterator<Like> getLikes();
}
