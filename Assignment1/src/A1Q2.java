/********************************************************************
 * Programmer:	Parmeet Gill
 * Class:  CS30S
 *
 * Assignment:  Assignment 1 Question 2
 * Program Name:  A1Q2.java
 *
 * Description: reads the input from the file and tells the frequency of any
 *              number or range of numbers
 *
 * Input:   from the testOut from A1
 *
 * Output:  the frequency of any number and the frequency of a range of numbers
 *          the 5 random numbers in an array
 ***********************************************************************/
 
 // import java libraries here as needed
 
 import javax.swing.*;
 import java.text.DecimalFormat;
 import java.io.*; 					// import file io libraries
import java.util.Random;

public class A1Q2 {  // begin class
    
    public static void main(String[] args) throws IOException{  // begin main
    
    // ********* declaration of constants **********
        
        final int MAXSIZE = 1000;
        final int MAX = 101;
        final int intSen = -1;
        final String strinSen = "-1";
        
    // ********** declaration of variables **********
        
        String delim = "[ ]+";
        String strin = "";
        String input1[] = null;
        String strinMultNum = "";
        String tokens[] = null;
        String delim2 = "[-]+";

        int counter = 0;
        int number = 0;
        int freq[] = new int[MAX];
        int intSingleNum = 0;
        int list[] = new int[MAXSIZE];
        int num1 = 0;
        int num2 = 0;

    // create instances of objects for i/o and formatting
    
    	BufferedReader fin = new BufferedReader(new FileReader("testOut.txt"));
    	//PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter("Outa1.txt")));
       // ProgramInfo programinfo = new ProgramInfo("A1 " + "Q2");
    	
    // ********** Print output Banner **********
    
    	printBanner();      //prints banner to output
 	    	
    // ************************ get input **********************
    
        strin = fin.readLine();
        counter = 0;
        
    	while (strin != null) {
            input1 = strin.split(delim);
            System.out.println(strin + "\n");
            
            for (int n = 0; n< 5; n++) {
                list[counter] = Integer.parseInt(input1[n]);
                //System.out.println("Number " + count + " is generated " + array[count] + " times\n");
                
                counter++;
            }//end for loop
            
            strin = fin.readLine();
        }//end while loop
        
    // ************************ processing ***************************

        for (number = 1; number < MAX ; number++) {
        for (int n = 0; n < MAXSIZE; n++) {

            if (list[n] == number) {
                freq[number]++;
            }//end if statement

        }//end for loop
        System.out.println("Number " + number + " is generated " + freq[number] + " times\n");
        }//end for loop

        while (!(intSingleNum == intSen || strinMultNum.equals(strinSen))) {
            intSingleNum = Integer.parseInt(JOptionPane.showInputDialog(
            "Enter the number that you would like to see the frequency of "
                    + " or -1 to end"));
            
            if (intSingleNum != intSen) {
                System.out.println("The frequency of " + intSingleNum + " is "  
                    + freq[intSingleNum]);
            }

            strinMultNum = JOptionPane.showInputDialog(
            "Enter the numbers that you would like to see the frequency of "
                    + "(ex: 10-20), or -1 to end");
            
            if (!(strinMultNum.equals(strinSen))) {
            tokens = strinMultNum.split(delim2);
            num1 = Integer.parseInt(tokens[0]);
            num2 = Integer.parseInt(tokens[1]);
            
            for (int n = num1; n <= num2; n++) {
                System.out.println("The frequency of " + n + " is "  
                   + freq[n]);
            }//end for loop
            }//end multnum if
        }//end while loop
        
    // ************************ print output ****************************

        //fileList(array, MAXLIST, fout);
        //printList(array, MAXLIST, fout);
    
    // ******** closing message *********
        
        //System.out.println(programinfo.eoFile);
        //fout.println(programinfo.eoFile);
        
    // ***** close streams *****
        
        fin.close();			// close input buffer
       // fout.close();			// close output buffer
    }  // end main
    
    
    //************************************************
    // Purpose: print the array to file
    // Interface: IN: base address of list,
    //                actual size of list
    // Returns: 
    // *****************************************************
    public static void fileList(int[] a, int b, PrintWriter fout){
        fout.println("\nThere are " + b + " numbers in the array\n");
        for (int i = 0; i < b; i++) {
            //fout.println(a[i]);
            fout.println(a[i]);
           
        }//end for
    }  // end file list
    
    //************************************************
    // Purpose: print the array to console
    // Interface: IN: base address of list,
    //                actual size of list
    // Returns: 
    // *****************************************************
    public static void printList(int[] a, int b, PrintWriter fout){
        System.out.println("\nThere are " + b + " numbers in the array\n");
        for (int i = 0; i < b; i++) {
            System.out.println(a[i]);
        }//end for
    }  // end print list
    //************************************************
    // Purpose: print an output banner to the output window
    // Interface: IN: none
    // Returns: none
    // *****************************************************
    public static void printBanner(){
        System.out.println("*******************************************");
        System.out.println("Name:		Parmeet Gill");
        System.out.println("Class:		CS30S");
        System.out.println("Assignment:         Assignment 1 Q2");
        System.out.println("*******************************************");
    }  // end print banner

}  // end class

