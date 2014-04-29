package ca.bitjutsu.deity.entities;

import java.util.Iterator;

public interface Review {
	public long getId();
	public int getRating();
	public String getNote();
	public long getCreatedAt();
	
	/* Comments API */
	public Iterator<Comment> getComments();
	
	/* Likes API */
	public Iterator<Like> getLikes();
	
	/* Reviews API */
	public String getReviewerRelationship();
	
	public interface ReviewerRelationship {
		public String getAs();
		public String getRelationship();
	}
}
