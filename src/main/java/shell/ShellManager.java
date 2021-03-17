package shell;

import catalog.Catalog;
import catalog.CatalogUtil;
import exceptions.CommandLineException;
import exceptions.InvalidCatalogException;
import media.Image;
import media.Movie;
import shell.commands.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShellManager {
    List<Command> availableCommands = new ArrayList<Command>();
    public void initializeShell() {
        printMessageNewLine("Welcome to the Catalog Shell interface");
        initializeAvailableCommands();
        displayAvailableCommands();
        displayOptionalText();
        //executeTest();
        try {
            Catalog catalog = CatalogUtil.load("media/catalog.ser");
            startQueryingForCommands(catalog);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void executeTest() {
        try{
            Catalog catalog = CatalogUtil.load("media/catalog.ser");

            AddCommand ac = new AddCommand();
            ac.executeAddCommand(catalog, new Image("berserk", "media/files/berserk.jpg"));

            SaveCommand sc = new SaveCommand();
            sc.saveCommand(catalog);

            LoadCommand loc = new LoadCommand();
            loc.loadCommand("media/catalog.ser");

            PlayCommand pc = new PlayCommand();
            pc.playCommand(catalog);

            ListCommand lic = new ListCommand();
            lic.listCommand(catalog);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * We do this because we want to take the names of the methods directly from the their respective classes
     * This way the ShellManager will simply take the information about a given command straight from its according class
     */
    private void initializeAvailableCommands() {
        AddCommand ac = new AddCommand();
        LoadCommand loc = new LoadCommand();
        ListCommand lic = new ListCommand();
        SaveCommand sc = new SaveCommand();
        PlayCommand pc = new PlayCommand();

        availableCommands.add(ac);
        availableCommands.add(loc);
        availableCommands.add(lic);
        availableCommands.add(sc);
        availableCommands.add(pc);
    }

    private void displayOptionalText() {
        //TODO
        //printMessageNewLine("For more information, type <command> --help");
    }

    private void displayAvailableCommands() {
        printMessageNewLine("Available commands: ");
        availableCommands.forEach(command -> {
            printMessage("\t" + command.getCommandName() + " ");
            command.getArguments().forEach(argument -> {
                printMessage(argument + " ");
            });
            printMessageNewLine("");
        });
    }

    private void startQueryingForCommands(Catalog catalog) throws CommandLineException {
        printMessageNewLine("Next command: \n");
        String command = "";
        try {
            command = readCommand();
        } catch (IOException e) {
            e.printStackTrace();
            methodFailed("Error at command line");
        }
        try {
            if(interpretCommand(catalog, command)) {
                startQueryingForCommands(catalog);
            }
        } catch (CommandLineException e) {
            printMessageNewLine("Command line exception caught!");
            e.printStackTrace();
        }
    }

    private void methodFailed(String errorMessage) {
        printMessageNewLine("Error: " + errorMessage);
    }

    private String readCommand() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }

    private void printMessageNewLine(String message) {
        System.out.println(message);
    }

    private void printMessage(String message) {
        System.out.print(message);
    }

    private boolean interpretCommand(Catalog catalog, String lineCommand) throws CommandLineException {
        List<String> splitCommand = Arrays.asList(lineCommand.split(" ").clone());
        for (Command command : availableCommands) {
            if (command.getCommandName().equalsIgnoreCase(splitCommand.get(0))) {
                // get the command
                // All the logic inside each switch case will be moved to its according class
                switch (splitCommand.get(0)) {
                    case "add" -> {
                        // get the item type
                        //add Image musashi media/files/musashi.jpg
                        switch (splitCommand.get(1)) {
                            case "Image" -> {
                                Image nImage = new Image(splitCommand.get(2), splitCommand.get(3));
                                ((AddCommand) command).executeAddCommand(catalog, nImage);
                                return true;
                            }
                            case "Movie" -> {
                                Movie nMovie = new Movie(splitCommand.get(2), splitCommand.get(3), "");
                                ((AddCommand) command).executeAddCommand(catalog, nMovie);
                                return true;
                            }
                            default -> {
                                throw new CommandLineException(new Exception());
                            }
                        }
                    }
                    case "list" -> {
                        ListCommand lic = new ListCommand();
                        lic.listCommand(catalog);
                        return true;
                    }
                    case "save" -> {
                        SaveCommand sc = new SaveCommand();
                        try {
                            sc.saveCommand(catalog);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        return true;
                    }
                    case "play" -> {
                        PlayCommand pc = new PlayCommand();
                        pc.playCommand(catalog);
                        return true;
                    }
                    case "load" -> {
                        LoadCommand loc = new LoadCommand();
                        try {
                            loc.loadCommand("media/catalog.ser");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        return true;
                    }
                    case "exit" -> {
                        printMessageNewLine("Exiting");
                        return false;
                    }
                }
            }
        }
        throw new CommandLineException(new Exception());
    }
}
