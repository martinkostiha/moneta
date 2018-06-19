package cz.moneta;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class TextServiceImpl implements TextService {
	
	private static final Set<Character> CHARS_TO_UPPERCASE =  "aeiou".chars()
			.mapToObj(c -> (char)c)
			.collect(Collectors.toSet());

	@Override
	public String transform(String input) {
		if (input == null) {
			return null;
		}
 
		char[] characters = reduceSpaces(input).toCharArray();
				
		int leftIdx = 0;
		int rightIdx = characters.length - 1;
		
		for ( ; leftIdx <= rightIdx; leftIdx++, rightIdx--) {
						
			char leftChar = characters[leftIdx];
			char rightChar = characters[rightIdx];
			
			characters[leftIdx] = changeCharacterCase(rightChar, leftChar);
			characters[rightIdx] = changeCharacterCase(leftChar, rightChar);
		}
				
		return String.valueOf(characters);
	}

	private String reduceSpaces(String input) {
		return input.replaceAll("[ ]+", " ");
	}

	private char changeCharacterCase(char character, char accordingTo) {
		
		if (CHARS_TO_UPPERCASE.contains(accordingTo)) {
			return Character.toUpperCase(character);
		}
		return Character.toLowerCase(character);
	}

}
