package com.br.updateproject.updateproject;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.br.updateproject.updateproject.PathAndName;


/**
 *
 * @author wilson
 * //Objetivo : Usar esse programa para fazer o update de todos os projetos do Xlibs
 */
public class Main {
    public static void main(String[] args) throws IOException{
        
        
        
        System.out.println("Server-controllers");
        update(PathAndName.PATH_SEVER_CONTROLLER,PathAndName.SEVER_CONTROLLER);
        update(PathAndName.PATH_SEVER_CONTROLLER_REMOTE_SSH,PathAndName.SERVER_CONTROLLER_REMOTE_SSH);
        
        System.out.println("Modulos");
        update(PathAndName.PATH_MODULO_BASE,PathAndName.MODULO_BASE);
        update(PathAndName.PATH_PLD_PRO,PathAndName.PLD_PRO);
        update(PathAndName.PATH_LIBS,PathAndName.LIBS);
        
        System.out.println("Sufixo xlibs");
        update(PathAndName.PATH_XLIBS_BASE,PathAndName.XLIBS_BASE);
        update(PathAndName.PATH_XLIBS_DATA,PathAndName.XLIBS_DATA);
        update(PathAndName.PATH_XLIBS,PathAndName.XLIBS);

    }
    
    public static void update(String path,String projectName){
        
        try{
         List<String> listCommand = new ArrayList<>();
         listCommand.add("svn");
         listCommand.add("update");
         
        ProcessBuilder processBuilder = new ProcessBuilder(listCommand);
        processBuilder.directory(new File(path));
        
        Process process = processBuilder.start();
        
        System.out.println("Updating the project "+projectName);
        // for reading the output from stream
        BufferedReader stdInput
            = new BufferedReader(new InputStreamReader(
                process.getInputStream()));
        String s = null;
        while ((s = stdInput.readLine()) != null) {
            System.out.println(s);
        }
       
        System.out.println("-------------------------------------------");
        
        }catch(IOException e){
            
            System.out.println(e);
        }
    }
            
}
