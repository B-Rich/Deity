package ca.bitjutsu.deity.entity;

public interface Message {
	public long getId();
	public String getBody();
	public long getRecipientId();
	public long getSenderId();
	public long getCreatedAt();
	
	/* Only defined for messages sent to authenticated user */
	public boolean isUnread();
}
