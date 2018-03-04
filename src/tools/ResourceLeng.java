/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

/**
 * @version 1.0
 * @author Diego Alvarez
 */
public class ResourceLeng {
    private static final String[] Languagues = {"Español", "Ingles"};
    private static String[] IsoLanguague = {"es", "en"};
    
    public static String[] getLanguages(){
        return Languagues;
    }
    
    public static String getIso(String _languague){
        String respuesta = null;
        int index = 0;
        for(int i = 0; i < Languagues.length; i++){
            if(Languagues[i].equals(_languague)){
                index = i;
                break;
            }
        }
        respuesta = IsoLanguague[index];
        return respuesta;
    }
    
    
    
    /** 
     * Initial App String
     */
    public final static String APP_INIT = "app_init";
    
    /**
     * Title on title bar
     */
    public final static String APP_TITLE = "app_title";
   
    /**
     * Text from main button application
     */
    public final static String HELLO_BUTTON = "hello_button";
    
    /**
     * Text for log
     */
    public final static String HELLO_LOG = "hello_log";
       
    /**
     * Text
     */
    public final static String HELLO_WORLD = "hello_world";
}
