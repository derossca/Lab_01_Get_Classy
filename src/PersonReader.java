import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import static java.nio.file.StandardOpenOption.CREATE;

public class PersonReader {
    public static void main(String[] args)
    {
        JFileChooser chooser = new JFileChooser();
        File selectedFile;
        String rec = "";
        ArrayList<Person> folks = new ArrayList<>();


        try {
            // uses a fixed known path:
            //  Path file = Paths.get("c:\\My Documents\\data.txt");

            // use the toolkit to get the current working directory of the IDE
            // Not sure if the toolkit is thread safe...
            File workingDirectory = new File(System.getProperty("user.dir"));

            chooser.setCurrentDirectory(workingDirectory);

            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();

                // Typical java pattern of inherited classes
                // we wrap a BufferedWriter around a lower level BufferedOutputStream
                InputStream in =
                        new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(in));

                // Finally we can read the file LOL!

                System.out.printf("%-8s%-14s%-12s%-8s%-5s%n", "ID#", "Firstname", "Lastname", "Title", "YOB");
                System.out.println("=============================================");

                int line = 0;
                while (reader.ready()) {
                    rec = reader.readLine();
                    line++;
                    // echo to screen
                    //splitting info
                    String[] info = rec.split(",");

                    //make person object and add it to array list
                    Person person = new Person(info[0], info[1], info[2], info[3], Integer.parseInt(info[4]));
                    folks.add(person);

                    //print data
                    System.out.printf("%-8s%-14s%-12s%-8s%-5s%n", person.getIDNum(), person.getFirstName(), person.getLastName(), person.getTitle(), person.getYOB());
                }
                reader.close(); // must close the file to seal it and flush buffer
                System.out.println("\n\nData file read!");


            } else  // User closed the chooser without selecting a file
            {
                System.out.println("No file selected!!! ... exiting.\nRun the program again and select a file.");
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found!!!");
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}