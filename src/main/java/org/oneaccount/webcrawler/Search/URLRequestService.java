package org.oneaccount.webcrawler.Search;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;


public class URLRequestService {
    //The complete implementation would have used the Google API but we will be using the URLConnection API to minimise the usage of the libraries
    //However, this means that Google can detect programmatic requests to a endpoint sometimes does not allow access
    //Therefore, I have hard coded to a different URL for demonstration purporses
    public static void querySearchEngine(String query) {
        BufferedReader in = null;
        try {
            // final URL url = new URL("https://www.google.com/search?q=" + URLEncoder.encode(query, "UTF-8"));
            final URL url = new URL("https://www.hellomagazine.com/");
            final URLConnection connection = url.openConnection();

            connection.setConnectTimeout(60000);
            connection.setReadTimeout(60000);
            connection.addRequestProperty("User-Agent", "Google Chrome/36");

            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            //The complete implementation would pick this up from the properties file
            String filename = "GoogleSearchResults.txt";
            FileHandler.writeFile(in, filename);

        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            try {
                if (in != null)
                    in.close();
            } catch (Exception ex) {
                System.out.println("Error in closing the BufferedReader" + ex);
            }
        }
    }


    public static void requestURL(String urlPath, String name) {
        BufferedReader in = null;
        try {
            final URL url = new URL(urlPath);
            final URLConnection connection = url.openConnection();

            connection.setConnectTimeout(60000);
            connection.setReadTimeout(60000);
            connection.addRequestProperty("User-Agent", "Google Chrome/36");//put the browser name/version

            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String filename = name + ".txt";
            FileHandler.writeFile(in,filename);

        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            try {
                if (in != null)
                    in.close();
            } catch (Exception ex) {
                System.out.println("Error in closing the BufferedWriter" + ex);
            }
        }


    }


}
