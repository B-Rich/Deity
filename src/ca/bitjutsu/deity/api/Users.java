package ca.bitjutsu.deity.api;

import ca.bitjutsu.deity.auth.AccessToken;
import ca.bitjutsu.deity.entity.User;

public interface Users {
	public User getUser(long userId);
	public AuthenticatedUser getAuthenticatedUser(AccessToken accessToken);
}
