package ca.bitjutsu.deity.entity;

import java.util.Iterator;

public interface LocationTag extends Tag {
	/* Jobs API */
	public Iterator<Job> getJobs();
}
