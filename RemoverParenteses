//tmp_formula	=	m_formula.substring(i+1, 4-1); 	//	A.B
package com.diaraujo;

public class MainClass {

	/*
	 * 	TODO
	 * Identificar o indice dos parenteses
	 * Substituição de todos
	 * 
	 */
	public static void main(String[] args) {
	
		String 	formula		=	 "(T.T)";		
		
		System.out.println(   calcBrackets(formula)   );
		
		
	}
	
	
	private static String calcBrackets(String x){
	
		String		m_formula			=	x;
		String		conteudo_parenteses	=	null;
		String		com_parenteses		=	null;
		String		tmp_res		=	null;
		
		Character 	m_anterior;
		Character 	m_posterior;
		
		int			m_findex;
		int			m_lindex;
		
		for ( int i = 0; i < m_formula.length(); i++){
//			if	(	!(i-1	<	0))									// Atribui o valor do caractere anterior
//				m_anterior	=	m_formula.charAt(i-1);	
//		
//			if	(	!(i+1	>	m_formula.length()))				// Guarda o valor do caractere posterior
//				//m_posterior	=	m_formula.charAt(i+1);
			
			if	(	m_formula.charAt(i) == '('){												//	(T.T).(T.F)	->	i	->	0
				com_parenteses		=	m_formula.substring(0,5);								// 	(T.T).(T.F)	->	(T.T)
				conteudo_parenteses	=	m_formula.substring(1,4);								//	(T.T).(T.F)	->	T.T	
				
				//tmp_res				= 	calcBrackets(conteudo_parenteses); 					//	T.T			->	T
				m_formula = m_formula.replace(com_parenteses, "T");										//	(T.T).(T.F)	->	T.(T.F)
				
				//calcBrackets(m_formula);														//	T.(T.F)
				System.out.println(m_formula);
			}
			
		}
		
		
		
		return m_formula;
		
	}
	
	
	//private static void
	
}
