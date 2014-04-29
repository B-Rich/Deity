package ca.bitjutsu.deity.entity;

import java.util.Iterator;
import java.util.List;

public interface Startup extends Followable {	
	public boolean isHidden();
	public boolean isCommunityProfile();

	public String getLogoUrl();
	public String getThumbUrl();
	public String getCompanyUrl();
	public String getTwitterUrl();
	public String getBlogUrl();
	public String getVideoUrl();

	public int getQuality();
	public String getProductDescription();
	
	public long getCreatedStamp();
	public long getUpdatedStamp();
	
	public List<Tag> getMarkets();
	public List<Tag> getLocations();
	
	public StatusUpdate getStatus();
	public List<Screenshot> getScreenshots();
	
	/* Comments API */
	public Iterator<Comment> getComments();
	
	/* Jobs API */
	/* These are not paginated - no need for an Iterator */
	public List<Job> getJobs();
	
	/* Press API */
	public Iterator<Press> getPress();
	
	/* Startup Roles API */
	public Iterator<StartupRole> getRoles();
	public Iterator<StartupRole> getRoles(boolean outgoing);
	public Iterator<StartupRole> getRoles(String roleType);
	public Iterator<StartupRole> getRoles(String roleType, boolean outgoing);
}
