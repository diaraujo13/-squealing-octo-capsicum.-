import java.util.TreeMap;

public class Main{
	
	private static String statement_tmp = "(A:B)>C ";
	
	public static void main (String args[]){
		
		//boolean tmp = statement_tmp.startsWith("(");
	
		String tmp = nota_polonesa(statement_tmp);
		
		System.out.printf("%s\n", tmp);
		
	}
	
	private static String nota_polonesa(String c){
		
		String 		formula = "";
		
		Character 	tmp;
		Character 	anterior = '¬';
		Character	posterior = '¬';
		
		for (int i = 0; i < statement_tmp.length(); i++){
			tmp = c.charAt(i);
			
					if (!(i-1 < 0))
					anterior	=	c.charAt(i-1);
					if (!(i+1>0))
					posterior	=	c.charAt(i+1);
			
					if (tmp.equals('>')){
					if (Character.isLetter(anterior) && Character.isLetter(posterior))
						formula.endsWith('>' + anterior.toString() + posterior.toString());
					}
					
		}
		
		
		return null;
	}
}
