package ca.bitjutsu.deity.entity;

public interface Follow {
	public long getId();
	public long getCreatedAt();
	
	public Followable getFollower();
	public Followable getFollowed();
}
