package ca.bitjutsu.deity.entities;

import java.util.Iterator;

public interface LocationTag extends Tag {
	/* Jobs API */
	public Iterator<Job> getJobs();
}
