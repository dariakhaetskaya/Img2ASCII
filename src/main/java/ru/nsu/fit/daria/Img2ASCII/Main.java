package ru.nsu.fit.daria.Img2ASCII;
import java.io.*;
import org.apache.commons.cli.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Options options = new Options();
        options.addOption("f", "file", true, "Input file");
        options.addOption("h", "help", false, "Help");
        CommandLineParser parser = new DefaultParser();
        InputStream in = System.in;

        try {
            CommandLine line = parser.parse(options, args);
            if (line.hasOption("help")) {
                System.out.println("Pass this me a picture and I'll draw it for you!");
                return;
            }
            if (line.hasOption("file")) {
                String file = line.getOptionValue("file");
                System.out.println("Drawing " + file);
                Img2ASCII drawer = new Img2ASCII();
                drawer.draw(file);
            }

        } catch (ParseException exp) {
            System.err.println("Parsing failed. Reason: " + exp.getMessage());
        }
    }
}
