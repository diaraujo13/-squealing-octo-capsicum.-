/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author  Izaias Araújo Gomes da Silva
 * @email   izaiasousa  at  gmail   dot com
 */
public class IdentificarParenteses {
    
    public static void main (String args[]){
        
        String w = "(A.B)";
        int pos =  0;
        
        int last_par        =   0;
        int last_par_index  =   0;
            
        for (int i=0; i<w.length(); i++){
            if (w.charAt(i)=='('){
                for (int j=i+1; j < w.length(); j++){

                    if ( w.charAt(j) == '(' ){
                        last_par += 1;   
                        last_par_index = j;
                    }

                    if ( w.charAt(j) == ')' && last_par==0){
                        pos =  j;
                        break;
                    } else if ( w.charAt(j) == ')' && last_par==1 ){
                        last_par_index = 0;
                        continue;
                    }


                }

            }
        }
        
        
    }
}
