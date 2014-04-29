package ca.bitjutsu.deity.entities;

import java.util.Iterator;
import java.util.List;

public interface User extends Followable {	
	/* Only exist if received from GET /users/:id */
	public String getAboutMeUrl();
	public String getBehanceUrl();
	public String getBlogUrl();
	public String getDribbleUrl();
	public String getFacebookUrl();
	public String getGithubUrl();
	public String getLinkedInUrl();
	public String getOnlineBioUrl();
	public String getTwitterUrl();
	
	/* Might not even be a thing */
	public String getWhatIveBuilt();
	
	public boolean isInvestor();
	
	/* Investor details */
	public InvestorDetails getInvestorDetails();
	
	/* Follows API */
	public boolean isFollowing(Followable followable);
	
	public Iterator<User> getFollowedUsers();
	public Iterator<Long> getFollowedUserIds();
	
	public Iterator<Startup> getFollowedStartups();
	public Iterator<Long> getFollowedStartupIds();
	
	/* Reviews API */
	public Iterator<Review> getReviews();
	
	/* Startup Roles API */
	public Iterator<StartupRole> getRoles();
	public Iterator<StartupRole> getRoles(String roleType);
	
	public interface InvestorDetails {
		public boolean getAccreditation();
		public String getAverageAmount();
		public List<Investment> getInvestments();
		
		/* TODO: this is literally the worst */
		public interface Investment {
			public long getId();
			public String getName();
			public int getQuality();
		}
	}
}
