package com.nacorpio.nutilities.network;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.nacorpio.nutilities.network.util.NetworkUtils;
import com.nacorpio.nutilities.regex.RegularExpression;
import com.nacorpio.nutilities.regex.RegularExpression.Group;
import com.nacorpio.nutilities.regex.RegularExpression.Match;
import com.nacorpio.nutilities.string.StringUtils;

public class WebDocument {

	public static class MatchedValue {
		
		private String value;
		private List<Group> groups = new ArrayList<Group>();
		
		public MatchedValue(String par1) {
			this.value = par1;
		}
		
		public final String value() {
			return this.value;
		}
		
		private final void setGroups(List<Group> par1) {
			this.groups = par1;
		}
		
		public final Group group(int par1) {
			return getGroups().get(par1);
		}
		
		private final List<Group> getGroups() {
			return groups;
		}
		
		@Deprecated
		private final void addGroup(Group par1) {
			groups.add(par1);
		}
		
	}
	
	private Map<String, String> regex_parameters = new HashMap<String, String>();
	private Map<String, MatchedValue> matched_values = new HashMap<String, MatchedValue>();
	
	private String source;
	
	/**
	 * Creates a new web-document from the source code of the specified link.
	 * @param par1 the link of the web-site.
	 * @throws IOException 
	 */
	public WebDocument(String par1) throws IOException {
		if (!StringUtils.isEmpty(par1)) {
			this.source = NetworkUtils.getUrlSource(par1);
		}
	}
	
	/**
	 * Creates a new web-document from the source code of the specified URL.
	 * @param par1 the URL of the web-site.
	 * @throws IOException
	 */
	public WebDocument(URL par1) throws IOException {
		this(par1.toString());
	}
	
	public final void build() {
		for (int i = 0; i < regex_parameters.size(); i++) {
			
			String var1 = (String) regex_parameters.keySet().toArray()[i];
			String var2 = (String) regex_parameters.values().toArray()[i];

			RegularExpression varRegex1 = new RegularExpression(var2);
			List<Match> varMatches1 = varRegex1.getMatches(this.source);

			MatchedValue varMatch1 = new MatchedValue(varMatches1.get(0).value());
			
			varMatch1.setGroups(varMatches1.get(0).groups());		
			matched_values.put(var1, varMatch1);
			
		}
	}
	
	/**
	 * Returns the matched value with the specified name.
	 * @param par1 the name.
	 * @return the value.
	 */
	public final MatchedValue value(String par1) {
		return matched_values.get(par1);
	}
	
	/**
	 * Adds a new regular-expression parameter.
	 * @param par1 the identifier for the parameter.
	 * @param par2 the regular-expression of the parameter.
	 */
	public final void addRegexParameter(String par1, String par2) {
		if (!regex_parameters.containsKey(par1))
			regex_parameters.put(par1, par2);
	}
	
	/**
	 * Returns all the regular-expression parameters that has been added.
	 * @return the regular-expression parameters.
	 */
	public final Map<String, String> getRegexParameters() {
		return regex_parameters;
	}
	
	/**
	 * Returns all the matched objects in the regular-expression parameters.
	 * @return the matched parameter objects.
	 */
	public final Map<String, MatchedValue> getMatchedValues() {
		return matched_values;
	}
	
	/**
	 * Returns the source-code of this document.
	 */
	public final String toString() {
		return source;
	}
	
}
