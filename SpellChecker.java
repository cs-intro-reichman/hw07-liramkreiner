
public class SpellChecker {


	public static void main(String[] args) {
		String word = args[0];
		int threshold = Integer.parseInt(args[1]);
		String[] dictionary = readDictionary("dictionary.txt");
		String correction = spellChecker(word, threshold, dictionary);
		System.out.println(correction);
		//System.out.println(levenshtein(word,"control"));

	}

	public static String tail(String str) 
	{
		if(str.length()==1)
		{
			return "";
		}
		 return str.substring(1);
	}

	public static int levenshtein(String word1, String word2) 
	{
		if(word1.length()==0)
			return word2.length();
		if(word2.length()==0)
			return word1.length();
		word1 = word1.toLowerCase();
		word2 = word2.toLowerCase();
		if(word1.charAt(0)==word2.charAt(0))
			return levenshtein(tail(word1),tail(word2));
		  return 1+ Math.min(levenshtein(tail(word1),tail(word2)),Math.min(levenshtein(tail(word1),word2),levenshtein(word1,tail(word2)))) ; 
	}

	public static String[] readDictionary(String fileName) {
		String[] dictionary = new String[3000];

		In in = new In(fileName);
		String word = in.readLine();
		int inedx = 0;
		while(word!=null)
		{
			dictionary[inedx] = word;
			word = in.readLine();
			inedx++;
		}
		return dictionary;
	}

	public static String spellChecker(String word, int threshold, String[] dictionary)
	{
		int value = threshold;
		String similerword = word;
		for(int i=0;i<3000;i++)
		{
			int valueofdictionary = levenshtein(word,dictionary[i]);
			if(valueofdictionary<=threshold)//check all the dictionary with the word
			{
				if(valueofdictionary<value)
				{
					value=valueofdictionary;
					similerword = dictionary[i];
				}
			}
		}

		return similerword;
	}

}
