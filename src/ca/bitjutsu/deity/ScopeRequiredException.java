package ca.bitjutsu.deity;

/*
 * Make it a RuntimeException so that code can look pretty.
 */
public class ScopeRequiredException extends RuntimeException {
	/* Enable serialization. */
	private static final long serialVersionUID = 7299269989220020741L;

	public ScopeRequiredException(String scopeName) {
		super("Operation requires scope " + scopeName);
	}
}
