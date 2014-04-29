package ca.bitjutsu.deity.entity;

public interface SearchResult {
	public long getId();
	public String getName();
	public String getImageUrl();
	/* TODO: enum? */
	public ResultType getType();
	public String getAngelListUrl();
	
	public enum ResultType {
		User,
		Startup,
		MarketTag,
		LocationTag
	}
}
