package ca.bitjutsu.deity.entity;

import java.util.Iterator;

public interface Tag {
	public long getId();
	public String getName();
	public String getDisplayName();
	public String getAngelListUrl();
	
	/* See https://angel.co/api/spec/tags#GET_tags_%3Aid */
	public TagStatistics getAllStatistics();
	public TagStatistics getDirectStatistics();
	
	public Iterator<Startup> getTaggedStartups();
	public Iterator<Startup> getTaggedStartups(Tag.ResultOrder order);
	
	public Iterator<User> getTaggedUsers();
	public Iterator<User> getTaggedUsers(Tag.IncludeType type);
	
	/* TODO: Implement by_activity/by_residence in MarketTag/LocationTag */
	public Iterator<User> getTaggedInvestors();
	
	public Iterator<Tag> getChildren();
	public Iterator<Tag> getParents();
	
	public enum ResultOrder {
		popularity,
		asc,
		desc
	}
	
	/* TODO: better naming for "self" */
	public enum IncludeType {
		self,
		children,
		parents
	}
	
	public interface TagStatistics {
		public int getInvestorFollowerCount();
		public int getFollowerCount();
		public int getStartupCount();
		public int getUserCount();
	}
}
