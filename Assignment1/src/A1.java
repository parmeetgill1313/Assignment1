/********************************************************************
 * Programmer:      Parmeet Gill
 * Class:           CS30S
 *
 * Assignment:      A1 Q1
 * Program Name:    Assignment 1
 *
 * Description:     prints a list of between 950 and 1000 random numbers 
 *                  between 1 and 100 to a file 
 *
 * Input:           none
 *
 * Output:          950-1000 random numbers
 ***********************************************************************/
 
 // import java libraries here as needed
 
 import javax.swing.*;
 import java.text.DecimalFormat;
 import java.io.*; 			// import file io libraries
import java.util.Random;
 
public class A1 {  // begin class
    
    public static void main(String[] args) throws IOException{  // begin main
    
    // ********* declaration of constants **********
        
        final int max = 100;            //maximum for the random # generated
        final int MAXSIZE = 1000;       //amount of random #s generated
        
    // ********** declaration of variables **********
        
        String delim[]
        int list[] = new int[MAXSIZE];      //array of ints
        int count = 0;                  //counter
        
    // create instances of objects for i/o and formatting
    
    	PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter("testOut.txt")));
        Random rand = new Random();     //random number generator
        
    // ********** Print output Banner **********
    
        printBanner();      //prints banner to output
        fileBanner(fout);   //prints banner to file
    
    // ************************ get input **********************
    
        for (int n = 0; n < MAXSIZE; n++){//start for loop 
            list[n] = rand.nextInt(max) + 1;     
        }//end int random for loop 
        
    // ************************ processing ***************************
    
    
    // ************************ print output *********************
    
        //fileList(list, MAXSIZE, fout);

        for(int i = 0; i < MAXSIZE; i++){
            fout.print(list[i] + " ");
            count++;
            
            if(count == 5){
                fout.println("");
                count = 0;
            }//end if
            
        }//end for loop

    // ******** closing message *********
        
        System.out.println("\nend of processing.");
        fout.format("end of processing.");
   
    // ***** close streams *****
        
        //fin.close();			// close input buffer
        fout.close();			// close output buffer
        
    }  // end main
    
    //************************************************
    // Purpose: print an output banner to the output file
    // Interface: IN: PrintWriter
    // Returns: none
    // *****************************************************
    public static void fileBanner(PrintWriter fo){
        fo.println("*******************************************");
        fo.println("Name:		Parmeet Gill");
        fo.println("Class:		CS30S");
        fo.println("Assignment:         Assignment 1 Q1");
        fo.println("*******************************************");    
    } // end fileBanner
    
    //************************************************
    // Purpose: print an output banner to the output window
    // Interface: IN: none
    // Returns: none
    // *****************************************************
    public static void printBanner(){
        System.out.println("*******************************************");
        System.out.println("Name:		Parmeet Gill");
        System.out.println("Class:		CS30S");
        System.out.println("Assignment:         Assignment 1 Q1");
        System.out.println("*******************************************");
    }  // end print banner
    
    //************************************************
    // Purpose: print the array to the file
    // Interface: IN: base adress of list,
    //                actual size of list
    // Returns: none
    // *****************************************************
    public static void fileList(int[] l, int n, PrintWriter fout){
       int c = 0;   //counter
       for (int i = 0; i < n; i++){
           fout.println(l[i]);  //prints the random numbers 
           c++;     //counts the #s
       }
            fout.println("\nThere are: " + c + " numbers in the array.");

    }  // end print list
    
}  // end class
