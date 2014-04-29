package ca.bitjutsu.deity.entity;

public interface Intro {
	public long getId();
	public long getStartupId();
	public long getUserId();
	
	public long getCreatedAt();
	public int getIntroCount();
	public boolean isPending();
	public String getNote();
}
