package ca.bitjutsu.deity.entity;

import java.util.Iterator;

public interface Press {
	public long getId();
	public long getCreatedAt();
	public long getUpdatedAt();
	public long getPostedAt();
	
	public long getOwnerId();
	public String getOwnerType();
	public String getSnippet();
	public String getTitle();
	public String getUrl();
	
	/* Comments API */
	public Iterator<Comment> getComments();
	
	/* Likes API */
	public Iterator<Like> getLikes();
}
