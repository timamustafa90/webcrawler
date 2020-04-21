package org.oneaccount.webcrawler.Input;

import java.util.Scanner;

public class ConsoleInputReader implements InputReader {

    private Scanner consoleReader;
    private String searchTerm;

    public ConsoleInputReader() {
        consoleReader = new Scanner(System.in);
        promptUser();
    }

    private void promptUser() {
        System.out.println("Please enter a search term: ");
        searchTerm = consoleReader.nextLine();
        consoleReader.close();
    }

    public String getSearchTerm() {
        return searchTerm;
    }


}
