import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class PersonGenerator {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        ArrayList<Person> folks = new ArrayList<>();

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "_src_personTestData.txt");

      /*  a. ID (a String)
        b.	FirstName
        c.	LastName
        d.	Title (a string like Mr., Mrs., Ms., Dr., etc.)
        e.	YearOfBirth (an int)
       */

        //String personRec = "";
        String ID = "";
        String firstName = "";
        String lastName = "";
        String title = "";
        int YOB = 0;
        boolean done = false;

        do {
            ID = SafeInput.getNonZeroLenString(in, "Enter the ID [6 digits]");
            firstName = SafeInput.getNonZeroLenString(in, "Enter the first name");
            lastName = SafeInput.getNonZeroLenString(in, "Enter the last name");
            title = SafeInput.getNonZeroLenString(in, "Enter the title");
            YOB = SafeInput.getRangedInt(in, "Enter the year of birth", 1940, 2010);

            //personRec = ID + ", " + firstName + ", " + lastName + ", " + title + ", " + YOB;
            Person person = new Person(ID, firstName, lastName, title, YOB);
            folks.add(person);

            done = SafeInput.getYNConfirm(in, "Are you done?" );

        }while(!done);

        for( Person person: folks)
            System.out.println(person.toString());

        try
        {
            // Typical java pattern of inherited classes
            // we wrap a BufferedWriter around a lower level BufferedOutputStream
            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));

            // Finally can write the file LOL!

            for(Person person : folks)
            {
                // Needs looked at with tutor help
                writer.write(person.toCSVDataRecord());// stupid syntax for write rec
                // 0 is where to start (1st char) the write
                //writer.write(person.toJSONRecord()); would write record in JSON format
                //writer.write(person.toXMLRecord()); would write record in XML format
                // rec. length() is how many chars to write (all)
                writer.newLine();  // adds the new line

            }
            writer.close(); // must close the file to seal it and flush buffer
            System.out.println("Data file written!");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}
