package com.example.jpaunicodeopg.services;

import com.example.jpaunicodeopg.models.Unicode;
import com.example.jpaunicodeopg.repositories.UnicodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UnicodeService {

    @Autowired
    UnicodeRepository unicodeRepository;


    public void saveUnicode() {
        final int maxUnicodeRange = 0x10FFFF;

        for (int n = 0; n <= maxUnicodeRange; n++) {
            char charValue = (char) n;

            if (Character.isDefined(charValue)) {
                Unicode unicode = new Unicode();
                unicode.setUnicode(n);
                unicode.setLetter(charValue);
                unicode.setName(Character.getName(n));
                unicode.setDescription(checkCharDescription(charValue));
                unicodeRepository.save(unicode);
            }
        }
    }

        private String checkCharDescription(char c) {
            String charType;
            if (Character.isLetter(c)) {
                charType = "Letter";
            } else if (Character.isDigit(c)) {
                charType = "Number";
            } else if (Character.isEmoji(c)) {
                charType = "Emoji";
            } else {
                charType = "Unspecified";
            }
            return charType;
        }

    public List<Character> getLetters(char letter, int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("Number must be higher than 0.");
        }

        if (letter < 'a' || letter > 'z') {
            throw new IllegalArgumentException("Letter must be between 'a' and 'z'.");
        }

        List<Character> result = new ArrayList<>();

        for (int i = 0; i < number; i++) {
            char currentLetter = (char) ((letter - 'a' + i) % 26 + 'a');
            result.add(currentLetter);
        }
        return result;
    }
}
