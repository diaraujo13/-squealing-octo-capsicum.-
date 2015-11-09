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
        private static char conectivos [] = {'.','+','>',':'};



    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /*
            Leitura da fórmula e separação de todos os
            símbolos proposicionais em um ArrayList<String>
       */

        simbolos = new ArrayList<String>(); // Receberá os símbolos proposicionais únicos
       
        Scanner reader = new Scanner(System.in);
        formula = reader.nextLine();
            
        
            for (int z = 0; z < formula.length(); z++){
                if (Character.isLetter(formula.charAt(z)) ){

                    String tmp = String.valueOf(formula.charAt(z));
                    simbolos.add(tmp);
                    
                }
            }
        
         
        

        
        /* 
          Geração dos símbolos de TRUE e FALSE
       */
       
                    ArrayList<ArrayList<String>> lista_valores = new ArrayList<ArrayList<String>>();

                    ArrayList<String> coluna_1 = new ArrayList<String>();
                    ArrayList<String> coluna_2 = new ArrayList<String>();

                    coluna_1.add("T");
                    coluna_1.add("F");
                    coluna_1.add("T");
                    coluna_1.add("F");

                    coluna_2.add("T");
                    coluna_2.add("T");
                    coluna_2.add("F");
                    coluna_2.add("F");

                    lista_valores.add(coluna_1);
                    lista_valores.add(coluna_2);

                    String tmp_formula;

        /*
            Substituição de todos os valores na fórmula pelos respectivos valores T ou F
       */
        for ( int i = 0 ; i < lista_valores.get(0).size(); i++){

            tmp_formula = formula;
            for (int k = 0; k < lista_valores.size(); k++){

                System.out.print(lista_valores.get(k).get(i));

                tmp_formula = tmp_formula.replace(simbolos.get(k) , lista_valores.get(k).get(i));


            }

            System.out.print(" -- "+ tmp_formula + " -- ");

            // Calcular a fórmula
            // Seu valor atual alterado
            System.out.print  ( calcular (tmp_formula) + "\n" );
            
        }
     
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


        for (int i = 0; i < f.length(); i++){

             for (int p = 0; p < conectivos.length ; p++){
             
                 String tmp_pre;
                 String tmp_pos;

                 int posterior = i+1;
                 int anterior = i-1;


                    if (f.charAt(i) == conectivos[p]){

                        // Pega o valor anterior e o valor posterior
                        // Ambos como objeto STRING
                        tmp_pre = calcular(String.valueOf(f.charAt(anterior)));
                        tmp_pos = calcular(String.valueOf(f.charAt(posterior)));

                        // Armazena o valor do conectivo
                        String tmp_conectivo = String.valueOf(conectivos[p]);

                        //Aplicar, então, na fórmula correspondente ao respectivo conectivo
                        return calcularConectivo(tmp_pre, tmp_pos, tmp_conectivo) ;

                    } else if (f.charAt(i) == '~'){

                        String negacao = calcular(String.valueOf(f.charAt(posterior)));
                        
                        return inverter_valor(negacao);
                       
                    } else if (Character.isLetter(f.charAt(i)))
                    {
                        return String.valueOf(f.charAt(i));
                    }

             }
        }

        return "PQP";
    }


    /*

        Operações básicas

    */
    private static String inverter_valor (String valor){
        return  valor.equals("T") ? "F" : "V";
    }

    private static String calcularConectivo ( String anterior, String posterior, String conectivo){


        if (conectivo.equals(".")){

            return anterior.equals("T") && posterior.equals("T") ? "T" : "F";


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
