package ca.bitjutsu.deity.api;

import java.util.List;

import ca.bitjutsu.deity.entities.SearchResult;

public interface Search {
	/* Search API */
	/* Results are not paginated - use Lists. */
	public List<SearchResult> search(String query);
	
	/* TODO: convenience methods in StartupImpl, MarketTagImpl, LocationTagImpl, UserImpl */
	public List<SearchResult> search(String query, SearchResult.ResultType type);
	
	public List<SearchResult> searchBySlug(String slug);
}
