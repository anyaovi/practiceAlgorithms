import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class CountWords {

	public static void main(String[] args) {
		String path = "resources/cv000_tok-11609.txt";
		String text = "";
		String[] words;
		HashMap<String, Integer> mapWords = new HashMap<String, Integer>();
		String word;
		int count = 0;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(path));
			String strLine;
			while ((strLine = reader.readLine()) != null) {
				text += strLine;
			}
			reader.close();
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
		
		text = text.toLowerCase();
		text = text.replaceAll("[-+.^:,]","");
		words = text.split("\\s+");
		
		for (int i = 0; i < words.length; i++) {
			word = words[i];
			if (mapWords.get(word) == null) {
				mapWords.put(word, 1);
			} else {
				count = mapWords.get(word) + 1;
				mapWords.put(word, count);
			}
		}
		for (Map.Entry<String, Integer> entry : mapWords.entrySet()) {
			String key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println(key + " " + value);
		}

	}

}
