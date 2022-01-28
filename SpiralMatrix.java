// Assumptions: 
// - Given an m x n matrix of integers (m rows, n columns)
// - m >= 1 and n >= 1 (there is at least one element in the matrix)
// - Input matrices are either rectangular or square in shape
// - Clockwise traversal always starts at the index [0][0] (the top left corner)


import java.lang.StringBuilder;
import java.util.ArrayList;

public class Question1 {
    
    String matrix(int[][] input) {

        ArrayList<Integer> int_list = new ArrayList<Integer>();

        // Convert the 2D array into a 1D ArrayList
        for (int i = 0; i < input.length; i++) 
            for (int j = 0; j < input[i].length; j++) 
                int_list.add(input[i][j]); 
            
        

        // Store the length of the original 2D matrix
        int length = input[0].length;

        StringBuilder result = new StringBuilder();


        // Stop iterating once the 1D ArrayList is out of elements
        while (int_list.size() > 0)
        {
            // Add in the first length-1 elements into the result string
            // Remove those elements from the 1D ArrayList
            for (int i = 0; i < length-1; i++) 
            {
                String temp = Integer.toString(int_list.get(0));
                int_list.remove(0);
                result.append(temp + ", ");
            }

            
            // Add in every j+length element into the result string
            // Remove those elements from the 1D ArrayList
            for (int j = 0; j < int_list.size(); j+=length-1)
            {
                String temp = Integer.toString(int_list.get(j));
                result.append(temp + ", ");
                int_list.remove(j); 
            }


            // If the list is empty, break loop
            if (int_list.isEmpty()) { break; }


            // Reached the end of the 1D ArrayList, decrement length by 1
            length--;
           

            // Starting from the end of the ArrayList, add in the last length-1 elements into the result string
            // Remove those elements from the 1D ArrayList
            for (int i = 0 ; i < length-1; i++)
            {
                String temp = Integer.toString( int_list.get(int_list.size()-1) );
                int_list.remove(int_list.size()-1);
                result.append(temp + ", ");    
            }

            
            // Starting from the end of the ArayList, add in every j+length element into the result string
            // Remove those elements from the 1D ArrayList
            for (int j = int_list.size()-1; j > -1; j-=length)
            {
                String temp = Integer.toString( int_list.get(j) );
                result.append(temp + ", ");  
                int_list.remove(j); 
                
            }

            // Reached the start of the 1D ArrayList, decrement length by 1
            length--;
        }

        // Remove the extraneous ", " from the result string and return 
        result.setLength(result.length() - 2);
        return result.toString();
    }
}


