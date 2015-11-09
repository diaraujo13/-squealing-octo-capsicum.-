/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author aluno
 */

public class Main {
    
        private static String  formula;
        private static ArrayList<String> simbolos;
        private static String conectivos [] = {".", "+", ">", ":"};


        public static void main (String args[]){


            String teste = "F.F";

            System.out.println(" RESULTADO " + calcular(teste));
        }

    /*
     *  Pegar uma fórmula e calcular seu valor
     *
     * Se...
     *
     *  CONECTIVOS -> calcular seu anterior e seu posterior e aplicar numa fórmula dependendo do conectivo
     *  NEGAÇÃO -> calcular seu posterior
     *  LETRA -> RETORNAR SEU VALOR
     *
     */
    private static String calcular(String f){


        int tamanho = f.length();

        String resultado = null;

        for (int i = 0; i < tamanho; i++){

         String tmp_pre;
         String tmp_pos;

         int posterior = i+1;
         int anterior = i-1;

         boolean isPosConectivo = false ;
         if (anterior > 0 ){
            isPosConectivo = f.charAt(anterior)=='.'  ? true : false ;
         }
         String char_atual = String.valueOf(f.charAt(i));

             
         // calcular(char_atual);
           

            for (int p = 0; p < conectivos.length ; p++){
                    if (char_atual.equals(conectivos[p])){
                        // Pega o valor anterior e o valor posterior
                        // Ambos como objeto STRING
                        tmp_pre = calcular(String.valueOf(f.charAt(anterior)));
                        tmp_pos = calcular(String.valueOf(f.charAt(posterior)));

                    System.out.println( i + " - É CONECTIVO " + char_atual + "COM " + tmp_pre + " E " + tmp_pos);

                        //Aplicar, então, na fórmula correspondente ao respectivo conectivo
                        resultado = calcularConectivo(tmp_pre, tmp_pos, char_atual) ;

                    }
                    continue;
              }

           if (char_atual.equals("~")){

                        String negacao = calcular(String.valueOf(f.charAt(posterior)));

                      //  return inverter_valor(negacao);
                        resultado =  String.valueOf(char_atual);
            }

            else if (Character.isLetter(f.charAt(i)) && !isPosConectivo )
            {
                System.out.println( i + " - É LETRA ");
               // return String.valueOf(char_atual);
              resultado = String.valueOf(char_atual);
            }else{
                    continue;
               }

                  
        

       
    } // END OF FOR LOOP


        return resultado;
} // END METHOD <CALCULAR>

    /*

        Operações básicas

    */
    private static String inverter_valor (String valor)
    {
        return  valor.equals("T") ? "F" : "V";
    }

    private static String calcularConectivo ( String anterior, String posterior, String conectivo){


        if (conectivo.equals(".")){

            System.out.println("ENTROU NO E " + anterior.equals("T") );

            System.out.println("ENTROU NO E " + posterior.equals("T") );

            String resultado = (anterior.equals("T") && posterior.equals("T")) ? "T" : "F";
                 System.out.println(resultado);

            return (anterior.equals("T") && posterior.equals("T")) ? "T" : "F";


        }else if (conectivo.equals("+")){

            return anterior.equals("F") && posterior.equals("F") ? "F" : "T";

        }else if ( conectivo.equals(">")){
            return  posterior.equals("T") ? "T" : "F";

        }else if ( conectivo.equals (":")){

            return anterior.equals(posterior) ? "T" : "F";

        }

        return "ERRO";
    }

}
