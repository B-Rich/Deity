package ca.bitjutsu.deity.api;

import java.util.Iterator;

import ca.bitjutsu.deity.entity.Job;

public interface Jobs {
	/* Jobs API */
	public Iterator<Job> getJobs();
	public Job getJob(long jobId);
}
