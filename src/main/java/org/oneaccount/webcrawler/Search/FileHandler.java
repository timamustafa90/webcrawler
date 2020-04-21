package org.oneaccount.webcrawler.Search;

import java.io.*;

public class FileHandler {

    public static void writeFile(BufferedReader in, String filename) {
        BufferedWriter writer = null;

        try {
            File file = new File(filename);
            writer = new BufferedWriter(new FileWriter(file));


            for (String line = in.readLine(); line != null; line = in.readLine()) {
                writer.write(line);
                writer.newLine();
            }
            writer.flush();
        }
        catch (IOException ioException) {
            ioException.printStackTrace();
        }
        finally {
            try{
                if(writer!=null)
                    writer.close();
            }catch(Exception ex){
                System.out.println("Error in closing the BufferedWriter"+ex);
            }
        }
    }
}
