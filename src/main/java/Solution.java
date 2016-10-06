import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * Created by Ryan on 10/6/2016.
 *
 * Description
 * Given a list of people with their birth and end years (all between 1900 and 2000), find the year with the most number of people alive.
 * Code
 * Solve using a language of your choice and dataset of your own creation.
 * Submission
 * Please upload your code, dataset, and example of the program’s output to Bit Bucket or Github. Please include any graphs or charts created by your program.
 */
public class Solution {

    public static int yearWithMostLiving(String filePath) throws IOException {
        //Get the data file as an InputStream
        InputStream in = new FileInputStream(filePath);
        ObjectMapper mapper = new ObjectMapper();
        Calendar cal = Calendar.getInstance();

        //Convert the file contents to an array of Person objects
        Person[] people = mapper.readValue(in, Person[].class);

        //Initialize an array with 101 indices (one for each year 1900-2000)
        int[] living = new int[101];

        //Process each Person object
        for (Person person : people) {
            cal.setTime(person.birth_date);
            //Calculate the corresponding index for the birth year
            int born = cal.get(Calendar.YEAR) - 1900;
            cal.setTime(person.death_date);
            //Calculate the corresponding index for the death year
            int died = cal.get(Calendar.YEAR) - 1900;
            //Increment the index corresponding to every year Person was alive
            for (int j = born; j <= died; j++) {
                living[j]++;
            }
        }

        //Find the year with the most living people
        int maxVal = 0;
        int result = 0;
        for(int i=0;i<living.length;i++){
            if(living[i] > maxVal){
                maxVal = living[i];
                result = i;
            }
        }

        //Add 1900 to convert the index number back to the year
        return result + 1900;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(Solution.yearWithMostLiving("src/main/resources/MOCK_DATA.json") + " had the most living people.");
    }
}
