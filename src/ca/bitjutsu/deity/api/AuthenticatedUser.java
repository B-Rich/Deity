package ca.bitjutsu.deity.api;

import java.util.Iterator;
import java.util.List;

import ca.bitjutsu.deity.ScopeRequiredException;
import ca.bitjutsu.deity.entity.ActivityFeedItem;
import ca.bitjutsu.deity.entity.Comment;
import ca.bitjutsu.deity.entity.Follow;
import ca.bitjutsu.deity.entity.Followable;
import ca.bitjutsu.deity.entity.Intro;
import ca.bitjutsu.deity.entity.Like;
import ca.bitjutsu.deity.entity.Message;
import ca.bitjutsu.deity.entity.MessageThread;
import ca.bitjutsu.deity.entity.Press;
import ca.bitjutsu.deity.entity.Reservation;
import ca.bitjutsu.deity.entity.Review;
import ca.bitjutsu.deity.entity.Startup;
import ca.bitjutsu.deity.entity.StartupRole;
import ca.bitjutsu.deity.entity.StatusUpdate;
import ca.bitjutsu.deity.entity.User;

public interface AuthenticatedUser extends User {
	/* Activity Feeds API. */
	public Iterator<ActivityFeedItem> getActivityFeed();
	
	/* Comments API. - requires comment scope */
	public Comment comment(Press press) throws ScopeRequiredException;
	public Comment comment(Review review) throws ScopeRequiredException;
	public Comment comment(Startup startup) throws ScopeRequiredException;
	public Comment comment(StartupRole role) throws ScopeRequiredException;
	public Comment comment(StatusUpdate status) throws ScopeRequiredException;
	
	/* Follows API. */
	public Follow follow(Followable entity);
	public Follow unfollow(Followable entity);
	public boolean isFollowing(Followable entity);
	public boolean isFollowedBy(User user);
	
	/* Intros API. */
	public Intro intro(Startup startup);
	public Intro intro(Startup startup, String note);
	
	/* Likes API. - requires comment scope */
	public Like like(Comment comment) throws ScopeRequiredException;
	public Like like(StartupRole role) throws ScopeRequiredException;
	public Like like(StatusUpdate status) throws ScopeRequiredException;
	
	/* Messages API - requires message scope */
	public Iterator<MessageThread> getMessages() throws ScopeRequiredException;
	public Iterator<MessageThread> getUnreadMessages() throws ScopeRequiredException;
	public Iterator<MessageThread> getSentMessages() throws ScopeRequiredException;

	/* TODO: this doesn't seem to be the best way to do this. Do it better. */
	/* Messages API separate? i.e. public MessageBox getMessages() */
	public Iterator<Message> getThread(MessageThread thread) throws ScopeRequiredException;
	
	public Message message(User user) throws ScopeRequiredException;
	public Message message(MessageThread thread) throws ScopeRequiredException;
	
	public boolean markAsRead(Message message) throws ScopeRequiredException;
	public boolean markAsRead(List<Message> messages) throws ScopeRequiredException;
	
	/* Reservations API - requires invest scope */
	public List<Reservation> getReservations() throws ScopeRequiredException;
	public Reservation getReservation(Startup startup) throws ScopeRequiredException;
	public Reservation makeReservation(Startup startup, long amount) throws ScopeRequiredException;
	public Reservation updateReservation(Reservation reservation, long amount) throws ScopeRequiredException;
	public boolean deleteReservation(Reservation reservation) throws ScopeRequiredException;
	
	/* Status Updates API */
	public StatusUpdate postUpdate();
	public StatusUpdate postUpdate(Startup startup);
	public StatusUpdate deleteUpdate(StatusUpdate status);
}
