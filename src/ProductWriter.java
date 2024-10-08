import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class ProductWriter {
    public static void main(String[] args) {

        ArrayList<Product> things = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "_src_ProductTestData.txt");

      /*
      a.	ID (a String as before in Person)
      b.	Name (a String)
      c.	Description (a String a short sentence)
      d.	Cost (This is currency so it will be a Java double)

       */

        String productRec = "";
        String ID = "";
        String name = "";
        String descript = "";
        double cost = 0;
        boolean done = false;

        do {
            ID = SafeInput.getNonZeroLenString(in, "Enter the ID [6 digits]");
            name = SafeInput.getNonZeroLenString(in, "Enter the name of the product");
            descript = SafeInput.getNonZeroLenString(in, "Enter the description of the product");
            cost = SafeInput.getDouble(in, "What is the cost of the product?");

            Product products = new Product(ID, name, descript, cost);
            things.add(products);

            done = SafeInput.getYNConfirm(in, "Are you done?" );

        }while(!done);

        for( Product product: things)
            System.out.println(product.toCSVDataRecord());

        try
        {
            // Typical java pattern of inherited classes
            // we wrap a BufferedWriter around a lower level BufferedOutputStream
            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));

            // Finally can write the file LOL!

            for(Product product : things)
            {
                writer.write(product.toCSVDataRecord());  // stupid syntax for write rec
                // 0 is where to start (1st char) the write
                //writer.write(product.toJSONRecord()); would write in JSON format
                //writer.write(product.toXMLRecord()); would write in XML format
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
