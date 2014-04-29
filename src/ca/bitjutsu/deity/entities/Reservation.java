package ca.bitjutsu.deity.entities;

public interface Reservation {
	public long getId();
	public long getStartupId();
	public long getUserId();
	public long getCreatedAt();
	public long getUpdatedAt();
	
	/* Support for mad stacks */
	public long getAmount();
}
