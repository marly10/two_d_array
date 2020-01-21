/*
Ricky McKenzie
2D Array , Lab - CSC 1043
*/

//imports requested library
import java.io.*;
import java.util.*;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.io.File;
import java.text.DecimalFormat;


public class two_d_array_lab{

public static void main(String [] args)throws IOException{

      //Decimal formation with $
      DecimalFormat format = new DecimalFormat("$0.00");
      
      int data_weeks, propellant_week, all_data;
      
       //Array being used to store the data found in txt file
      double [][] voyager = new double [13][4];
      
      
      //scanner keyboard and reading txt file.
      Scanner keyboard = new Scanner(System.in);
      
      //reads the voyager1.txt file input
      System.out.print("Please enter the name of the file that you wish to process: ");
      
      String file_name = keyboard.next();
      
      //file_name = "voyager1.txt";
      Scanner readFile = new Scanner(new File(file_name));

      //Do while loop to test and insures the data being entered in an Int only!
       do{
    
            System.out.print("How many weeks of data will be processed? ");
                                
                  while (!keyboard.hasNextInt()){ 
                 
                        keyboard.next();
                        System.out.print("Please enter an integer: "); 
                                                                 
                                                }
                       data_weeks = keyboard.nextInt();

                      }while(data_weeks < 0 );
      
      //if the value entered for the week is larger than the actual size of the array being text with
      if(data_weeks > voyager.length ){  
            data_weeks = 13;
            System.out.println("Number of weeks is out of bounds. Assuming the entire 13 weeks: ");
            System.out.println();
                                      }

    //provide menu of services
      System.out.println("Enter number 1-4 to make your choice. Enter quit to end program");
      System.out.println();
      System.out.println("1. Calculate average fuel consumption for the entire series of weeks represented");
      System.out.println("2. Calculate average output for the entire series of weeks represented");
      System.out.println("3. Retrieve the propellent remaining for any 1 week (numbering starts at 0)");
      System.out.println("4. Print the data for any one week");
      System.out.println();
   
      //var declaration
      int i, j, num = 0, nums = 0;
      double fuel_consumption = 0.0, output_watts = 0.0;
      
      //value for the switch case
      System.out.print("Which operation would you like to perform? ");
      String value_entered = keyboard.next();
      
     
            
        for (  i = 0; i < voyager.length; i++ ){
        
            for (  j = 0; j < voyager[i].length; j++ ){             
                 
                 voyager[i][j] = readFile.nextDouble();

                                                        }//for loop ends inside one

                                                  }//for loop ends outside one
                                   
      //reads the entered string. Then selects the case to run based on user input
        while (!value_entered.equals("quit")){
        
        //instantiation of value whiole setting them to zero while in the case
        String index_change;
        String temp; 
        propellant_week = 0;
        all_data = 0;


         switch(value_entered){

            //case 1 beings here
            case "1":  
            //operation 1 Average fuel consumption for the entire series of weeks represented (you are processing a column)
                                                       
              for(i=0; i < data_weeks; i++ ){
              
                 fuel_consumption+=voyager[i][0];
                 
                 num++;

                                             }
                                             
                 System.out.println("Average fuel consumption was "+ format.format(fuel_consumption/num));
                       
                
               break;
            
                //case 2 beings here

            case "2": 
            
              
                //operation 2
                  
                for(i=0; i < data_weeks; i++ )
                {

                  output_watts+=voyager[i][2];
                  
                  nums++;

                }                            
                  System.out.println("Average output(watts) was "+ format.format(output_watts/nums));
                  
     
              break; 
               
                 //case 3 beings here
    
            case "3":
            
                 //operation 3 Propellant remaining for any 1 week (the user must enter the week) (you are processing 1 element)
             
             do{
    
                System.out.print("For which week would you like the propellant value? Available weeks are 0 to " + (data_weeks - 1) + ": ");
                                
                  while (!keyboard.hasNextInt()){ 
                 
                        keyboard.next();
                        System.out.print("Please enter an integer: "); 
                                                                 
                                                }
                    propellant_week = keyboard.nextInt(); 

                      }while(propellant_week < 0 );

                   
                
                if(propellant_week > voyager.length || voyager.length == propellant_week || propellant_week >= data_weeks){
                
                     //propellant_week = 0;
                     
                     
                     System.out.println("Invalid week entered. Operation aborted");
          
                                                                                            }
                  else{                                                                         
                  System.out.println("Propellant remaining "+ voyager[propellant_week][1]);
                  
                      }
            
              break;
                     
           //case 4 beings here
               
           case"4":

                //operation 4
                
                do{
                
                  all_data = 0;
    
                  System.out.print("For which week would you like the data? ");
                                                  
                 while (!keyboard.hasNextInt()){ 
                 
                        keyboard.next();
                        
                        System.out.print("Please enter an integer: "); 
                                                                 
                                                }
                    all_data = keyboard.nextInt(); 

                      }while(all_data <0);
                      
                      
                        if(all_data > voyager.length || all_data == voyager.length ){
                    
                           System.out.println();
                           System.out.println("Invalid week entered. Highest week possible is 12");
                           System.out.println();
 
                           
                                                                                      }
                  else
                  { 
                      //System.out.println();
                      System.out.println("Fuel\t"+ "Propel\t"+ "Output\t"+ "Margin\t");
                      System.out.println("-----\t"+ "------\t"+ "------\t"+ "------\t");
                
                      for(i=0; i < 4; i++ )
                       {
                          System.out.print(voyager[all_data][i] + "\t ");
                          System.out.print("");
                   
                  }
                  
                   System.out.println();
                       }
                          
         
              
            break;
            
               //default print if anything other than 1,2,3,4 is entered
               default:
                
                System.out.println("Invalid choice. Please enter 1-4 or quit");
                System.out.println();

                  
              }         
         System.out.println();
         System.out.print("Which operation would you like to perform? ");
         value_entered = keyboard.next();
         
        
            }//end of while loop that instantiate the value entered
      
      //prints the end of the system
      System.out.println("To space and beyond!");
   }
}


   