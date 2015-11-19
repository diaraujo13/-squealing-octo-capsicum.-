/*



1. Analisar os parenteses (
2. Analisar os conectivos e calcular seus respectivos <anterior> e <posterior>
2.1     if <anterior>||<posterior>:LETRA:pegar_resultado
2.2     else <posterior>!:LETRA:chamada_recursiva_da_função




*/



//	                         last_par += 1;   
//	                         last_par_index = j;
//	                     }
//	
//	                     if ( w.charAt(j) == ')' && last_par==0){
//	                         pos =  j;
//	                         break;
//	                     } else if ( w.charAt(j) == ')' && last_par==1 ){
//	                         last_par_index = 0;
//	                         continue;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author Izaias Araújo Gomes da Silva
 * @email izaiasousa at gmail dot com
 */
public class JavaApplication1 {

	public static void main(String args[]) {

		String v = "(A(B))";

		System.out.println(calcular(v));
	}

	public static String calcular(String w) {

		String resultado = "";

		for (int i = 0; i < w.length(); i++) {

			if (w.charAt(i) == '(') {
				
				
				for (int j = i + 1; j < w.length(); j++) {
					resultado = calcular(w.substring(j));
				}
				
				
			} else if (Character.isLetter(w.charAt(i))) {
				
				resultado = Character.toString(w.charAt(i));
				resultado.concat(calcular(w.substring(i+1)));

			} else if (w.charAt(i) == ')') {
				
			}

		}
		return resultado;
	}

}
