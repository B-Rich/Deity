package ca.bitjutsu.deity.entity;

import java.util.List;

public interface Job {
	public long getId();
	public String getTitle();
	
	public long getCreatedAt();
	public long getUpdatedAt();
	
	public EquityInfo getEquityInfo();
	/* Support/encourage mad stacks */
	public long getSalaryMax();
	public long getSalaryMin();
	
	public String getAngelListUrl();
	
	public Startup getStartup();
	public List<Tag> getTags();
	
	public class EquityInfo {
		public float cliff;
		public float min;
		public float max;
		public float vest;
	}
}
