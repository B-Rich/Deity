package ca.bitjutsu.deity.entities;

public interface Like {
	public long getId();
	public long getLikableId();
	public User getUser();
	public long getCreatedAt();
	public long getUpdatedAt();
}
