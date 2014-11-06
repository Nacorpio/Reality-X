package com.nacorpio.nutilities.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression {

	/**
	 * Represents a capture group in a regular-expression match.
	 * @author Nacorpio
	 *
	 */
	public static class Group {
		
		private String name;
		private String value;
		
		private int startIndex;
		private int endIndex;
		
		private Group(String par1, int par2, int par3) {
			this.value = par1;
			this.startIndex = par2;
			this.endIndex = par3;
		}
		
		@Deprecated
		private Group(String par1, String par2) {
			this.name = par1;
			this.value = par2;
		}
		
		/**
		 * Returns the start-index of the group.
		 * @return the start-index.
		 */
		public final int startIndex() {
			return startIndex;
		}
		
		/**
		 * Returns the end-index of the group.
		 * @return the end-index.
		 */
		public final int endIndex() {
			return endIndex;
		}
		
		/**
		 * Returns the name of the group.
		 * @return the name.
		 */
		@Deprecated
		public final String name() {
			return this.name;
		}
		
		/**
		 * Returns the value of the group.
		 * @return the value.
		 */
		public final String value() {
			return this.value;
		}
		
	}
	
	public static class Match {
	
		private String value;
		private List<Group> groups = new ArrayList<Group>();
		
		private int length;
		private int index;
		
		private int startIndex;
		private int endIndex;
		
		private Match(String par1, int par2, int par3, int par4, int par5) {
			this.value = par1;
			this.length = par2;
			this.index = par3;
			this.startIndex = par4;
			this.endIndex = par5;
		}
		
		private final void addGroup(Group par1) {
			this.groups.add(par1);
		}
		
		/**
		 * Returns the groups of the match.
		 * @return the groups.
		 */
		public final List<Group> groups() {
			return groups;
		}
		
		/**
		 * Returns the group at the specified index.
		 * This excludes the whole match, so to get the first group, you
		 * just do <code>.group(0)</code>. To get the whole match, just do <code>.value()</code>.
		 * @param par1 the index of the group.
		 * @return the group at the specified index.
		 */
		public final Group group(int par1) {
			return groups.get(par1);
		}
		
		/**
		 * Returns the start index of the match.
		 * @return the start index.
		 */
		public final int startIndex() {
			return startIndex;
		}
		
		/**
		 * Returns the end index of the match.
		 * @return the end index.
		 */
		public final int endIndex() {
			return endIndex;
		}
		
		/**
		 * Returns the value of the match.
		 * @return the value.
		 */
		public final String value() {
			return value;
		}
		
		/**
		 * Returns the length of the match.
		 * @return the length.
		 */
		public final int length() {
			return length;
		}
		
		/**
		 * Returns the index of the match.
		 * @return the index.
		 */
		public final int index() {
			return index;
		}
		
	}
	
	private String pattern;
	private Matcher matcher;
	
	/**
	 * Creates a new regular-expression with the specified pattern.
	 * @param par1 the regular-expression pattern.
	 */
	public RegularExpression(String par1) {
		this.pattern = par1;
	}
	
	/**
	 * Returns the matches that matched the pattern in the specified text.
	 * @param par1 the String to find the matches within.
	 * @return the matches.
	 */
	public final List<Match> getMatches(String par1) {
		
		List<Match> results = new ArrayList<Match>();
		
		Pattern var1 = Pattern.compile(pattern);
		matcher = var1.matcher(par1);
		
		int m = 0;
		while (matcher.find()) {
		
			String varGroup1 = matcher.group();
			Match varMatch1 = new Match(varGroup1, varGroup1.length(), m, matcher.start(), matcher.end());
	
			for (int i = 0; i < matcher.groupCount(); i++) {
				varMatch1.addGroup(new Group(matcher.group(i + 1), matcher.start(i + 1), matcher.end(i + 1)));
			}
			
			results.add(varMatch1);
			
			m++;
			
		}
		
		return results;
		
	}
	
	/**
	 * Returns the matcher that has been used for matching the pattern.
	 * @return the matcher.
	 */
	public final Matcher getMatcher() {
		return matcher;
	}
	
	/**
	 * Returns whether the pattern matches the specified String.
	 * @param par1 the String.
	 * @return true/false.
	 */
	public final boolean match(String par1) {
		return par1.matches(pattern);
	}
	
	/**
	 * Returns the pattern used for finding the matches.
	 * @return the pattern.
	 */
	public final String getPattern() {
		return pattern;
	}
	
}
