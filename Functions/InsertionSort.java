/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Functions;

import ProcessedData.CourseCandidate;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author joni
 */
public class InsertionSort {

    public static ArrayList<CourseCandidate> InsertionSort(ArrayList<CourseCandidate> cand) {
        
        int j;                     // the number of items sorted so far
        CourseCandidate key;                // the item to be inserted
        int i;
        CourseCandidate[]C = new CourseCandidate[cand.size()];
        cand.toArray(C);
        for (j = 1; j < cand.size(); j++) // Start with 1 (not 0)
        {
            key = C[ j];
            for (i = j - 1; (i >= 0) && (C[ i].compareTo(key) == -1); i--) // Smaller values are moving up
            {
                C[ i + 1] = C[ i];
            }
            C[ i + 1] = key;    // Put the key in its proper location
        }
        ArrayList<CourseCandidate> result = new ArrayList<>();
        result.addAll(Arrays.asList(C));
        return result;
    }
}
