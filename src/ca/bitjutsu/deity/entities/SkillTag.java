package ca.bitjutsu.deity.entities;

import java.util.Iterator;

public interface SkillTag extends Tag {
	/* Is this implemented yet? */
	public String getLevel();
	
	/* Jobs API */
	public Iterator<Job> getJobs();
}
