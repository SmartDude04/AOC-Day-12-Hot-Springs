import java.util.ArrayList;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Arrays;
import java.util.Scanner; // Import the Scanner class to read text files

public class FileParser
{
    public static String[] parseFile(String name)
    {
        ArrayList<String> file = new ArrayList<String>();

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

    public static void getString(String[] file)
    {
        for (int i = 0; i < file.length; i++)
        {
            int indexOfBreak = file[i].indexOf(",") - 2;

            file[i] = file[i].substring(0, indexOfBreak);
        }
    }

    public static int[] getCombinations(String line)
    {
        ArrayList<Integer> combinations = new ArrayList<>();
        line = line.substring(line.indexOf(",") - 1);

        for (int i = 0; i < line.length(); i++)
        {
            if (line.charAt(i) != ',')
            {
                combinations.add(Integer.parseInt(line.substring(i, i + 1)));
            }
        }

        Integer[] combos = new Integer[combinations.size()];
        combos = combinations.toArray(combos);
        return Arrays.stream(combos).mapToInt(Integer::intValue).toArray();
    }
}
