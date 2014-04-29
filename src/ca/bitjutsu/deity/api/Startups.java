package ca.bitjutsu.deity.api;

import java.util.Iterator;

import ca.bitjutsu.deity.entities.Startup;

public interface Startups {
	/* Startups API */
	public Startup getStartup(long startupId);
	
	/* This probably won't work
	 * See: https://angel.co/api/spec/startups#GET_startups%3Ffilter%3Draising */
	public Iterator<Startup> getRaisingStartups();
}
