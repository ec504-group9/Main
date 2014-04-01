/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//package imagetovideo;

/**
 *
 * @author Jeannie
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int argsLength = args.length;
        String EXTENSION = ".osa";
        int EXTENSIONLength = EXTENSION.length();
        
        if (argsLength > 0) {
            
            switch (args[0]) {
                case "gui":
                    // code to run gui here
                    System.out.println("Gui runs here...");
                    break;
                    
                case "encode":
                    
                    if (argsLength < 4 && !"--output".equals(args[argsLength - 2])){  // if "--output" flag not found, exit encoding
                        System.out.println("Command format invalid. No '--output' flag found or not enough arguments entered.");
                        System.out.println("Encoding failed. Exiting program...");
                    }
                    else {
                        
                        // check if output file has correct filename extension
                        String outputFilename = args[argsLength - 1];
                        int outputFileLength = outputFilename.length();
                        String thisFileExtension;
                        thisFileExtension = new String (outputFilename.substring(outputFileLength - EXTENSIONLength, outputFileLength));
                        
                        if (EXTENSION.equals(thisFileExtension) && outputFileLength > EXTENSIONLength){
                            
                            // pass all filenames to encode function
                            String[] imageFiles;
                            imageFiles = new String [argsLength - 3];

                            for (int ii = 1; ii < argsLength - 2; ii++){
                                imageFiles[ii - 1] = args[ii];
                            }
                            
                            System.out.println("Encoding started...");
                            //encode(imageFiles, outputFilename);
                            System.out.println("Encoding completed...");
                        }
                        else {
                            System.out.println("Output file must be specified with extension " + EXTENSION + " Please try again. Exiting program...");
                        }
                    }
                    break;
                    
                case "view":
                    
                    if (argsLength != 2 || args[1].length() <= EXTENSIONLength) {
                        System.out.println("Incorrect view command format. Exiting program...");
                    }
                    else {
                        String outputFilename = args[1];
                        int outputFileLength = outputFilename.length();
                        
                        String thisFileExtension;
                        thisFileExtension = new String (outputFilename.substring(outputFileLength - EXTENSIONLength, outputFileLength));
                        
                        if (EXTENSION.equals(thisFileExtension)){
                            System.out.println("Viewer launching...");
                            //view(outputFilename);
                        }
                        else {
                            System.out.println("Output file must be a " + EXTENSION + " file. Please try again. Exiting program...");
                        }
                        
                    }
                    break;
            }
        }
        else {
            System.out.println("Command not specified...");
            System.out.println("Exiting program...");
        }
        
    }
    
}

