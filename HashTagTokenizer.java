

public class HashTagTokenizer {

	public static void main(String[] args) {

		String hashTag = args[0];
		String[] dictionary = readDictionary("dictionary.txt");
		breakHashTag(hashTag, dictionary);
	}

	public static String[] readDictionary(String fileName)
	 {
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

	public static boolean existInDictionary(String word, String []dictionary) 
	{
		for (int i=0;i<dictionary.length ;i++)
		{
			boolean same = true;
			for(int j=0;j<dictionary[i].length();j++)//check if the value of each char is the same as the word
			{
				if(dictionary[i].length()!=word.length())
				{
					same =false;
					break;
				}
				int valueofcharword = (int)(dictionary[i].charAt(j));//char of fidcetonairy
				int valuofcharcheck = (int)(word.charAt(j));//char of the word
				if(valueofcharword!=valuofcharcheck)
				{
					same = false;
					break;
				}
			}
			if(same)
				return true;
		}
		return false;
	}
		
	public static void breakHashTag(String hashtag, String[] dictionary) 
	{

		// Base case: do nothing (return) if hashtag is an empty string.
        if (hashtag.isEmpty()) 
        {
            return;
        }
        int N = hashtag.length();
        String newordl = hashtag;
        for (int i = 1; i <=N; i++) 
        {

        	newordl= hashtag.substring(0,i);
			if (existInDictionary(newordl,dictionary)) 
        	{
        		
            	System.out.println(newordl);
            	breakHashTag(hashtag.substring(i,N),dictionary);//recursing without the word we found
            	break;//exittheloop if we finf a word

        	}
        	  
        }
    }


}
