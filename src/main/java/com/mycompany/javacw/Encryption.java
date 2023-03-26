package com.mycompany.javacw;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;



public class Encryption {
    
    //This is needed to specify the format for the byte Array
    private static final String UNICODE_FORMAT = "UTF-8";
    

    
    public static SecretKey generateKey(String encryptType){
        try{
            KeyGenerator keyGen = KeyGenerator.getInstance(encryptType);
            SecretKey myKey = keyGen.generateKey();
            return myKey;
        }catch(Exception e){
            return null;
        }
    }
     public static byte[] encryptInputString(String data, SecretKey myKey, Cipher myCipher ){
         try{
             /**To encrypt the data must be in byte format**/
             byte[] byteData = data.getBytes(UNICODE_FORMAT);
             
             /**Initializes the cipher and encrypts the byte array**/
             myCipher.init(Cipher.ENCRYPT_MODE, myKey);
             byte[] encryptedData = myCipher.doFinal(byteData);
             
             return encryptedData;
         }catch(Exception e){
             return null;
         }
     }
     
     public static String decryptInputString(byte[] encryptedData, SecretKey myKey, Cipher myCipher){
         try{            
             /**Initializes the cipher and decrypts the byte array**/
             myCipher.init(Cipher.DECRYPT_MODE, myKey);
             byte[] decryptedData = myCipher.doFinal(encryptedData);
             
             /**Converts the byte array into a string**/
             String finalResult = new String(decryptedData);
             
             return finalResult;
             
         }catch(Exception e){
             System.out.println(e);
             return null;
         }
     }
    
    
}
