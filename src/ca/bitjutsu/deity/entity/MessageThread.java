package ca.bitjutsu.deity.entity;

import java.util.List;

public interface MessageThread {
	public long getId();
	public boolean viewed();
	public int getMessageCount();
	/* TODO: should this be getRecipient() getSender()? Or is generality better? */ 
	public List<User> getUsers();
	public Message getLastMessage();
}
