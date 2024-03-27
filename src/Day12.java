import java.util.ArrayList;

public class Day12
{

    public static void main(String[] args)
    {
        String[] lines = FileParser.parseFile("src/input.txt");

        long total = 0;
        for (String line : lines)
        {
            total += getCombinations(line);
        }

        System.out.println(total);
    }

    public static int getCombinations(String line)
    {
        int indexOfQuestion = line.indexOf('?');
        String combo = FileParser.convertString(line);

        if (indexOfQuestion == -1)
        {
            int[] combinations = FileParser.getCombinations(line);
            return checkIfCorrect(combo, combinations);
        }

        String part1 = line.substring(0, indexOfQuestion);
        String part2 = line.substring(indexOfQuestion + 1);

        return getCombinations(part1 + "#" + part2) + getCombinations(part1 + "." + part2);
    }

    public static int checkIfCorrect(String line, int[] combinations)
    {

        // First check if the right number of pieces are present
        int total = 0;
        for (int one : combinations)
        {
            total += one;
        }

        int numOcurrences = line.length() - line.replace("#", "").length();

        if (total != numOcurrences)
        {
            return 0;
        }

        // Check if the patterns match
        ArrayList<Integer> matches = new ArrayList<>(combinations.length);

        boolean newPart = true;
        for (int i = 0; i < line.length(); i++)
        {
            // Add to either the current string or move to a new string
            if (line.charAt(i) == '.')
            {
                newPart = true;
            }
            else
            {
                if (newPart)
                {
                    matches.add(1);
                    newPart = false;
                }
                else
                {
                    int cur = matches.getLast();
                    matches.set(matches.size() - 1, cur + 1);
                }
            }
        }

        for (int i = 0; i < matches.size(); i++)
        {
            if (matches.get(i) != combinations[i]){
                return 0;
            }
        }

        return 1;
    }
}
