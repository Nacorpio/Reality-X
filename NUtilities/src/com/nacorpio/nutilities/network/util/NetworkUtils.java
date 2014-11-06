package com.nacorpio.nutilities.network.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public final class NetworkUtils {

	 public static String getUrlSource(String url) throws IOException {
		 
         URL link = new URL(url);
         URLConnection yc = link.openConnection();
         BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream(), "UTF-8"));
         
         String inputLine;
         StringBuilder a = new StringBuilder();
         
         while ((inputLine = in.readLine()) != null)
             a.append(inputLine);
         in.close();

         return a.toString();
         
     }
	
}
