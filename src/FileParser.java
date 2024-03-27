import java.util.ArrayList;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Arrays;
import java.util.Scanner; // Import the Scanner class to read text files

public class FileParser
{
    public static String[] parseFile(String name)
    {
        ArrayList<String> file = new ArrayList<>();

        try
        {
            File myObj = new File(name);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine())
            {
                String data = myReader.nextLine();
                file.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        String[] fileArr = new String[file.size()];
        return file.toArray(fileArr);

    }

    public static String convertString(String line)
    {
        return line.substring(0, line.indexOf(" "));
    }

    public static int[] getCombinations(String line)
    {

        line = line.substring(line.indexOf(" ") + 1);

        return Arrays.stream(line.split(",")).mapToInt(Integer::parseInt).toArray();
    }
}
