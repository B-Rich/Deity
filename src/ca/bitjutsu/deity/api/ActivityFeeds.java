package ca.bitjutsu.deity.api;

import java.util.Iterator;

import ca.bitjutsu.deity.entities.ActivityFeedItem;

public interface ActivityFeeds {
	/**
	 * Fetches recent site activity.
	 * 
	 * If a user is authenticated, will return an iterator for a personalized Activity Feed.
	 * @returns an iterator over a collection of ActivityFeedItems.
	 */
	public Iterator<ActivityFeedItem> getActivityFeed();
}
