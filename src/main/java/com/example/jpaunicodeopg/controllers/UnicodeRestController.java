package com.example.jpaunicodeopg.controllers;

import com.example.jpaunicodeopg.services.UnicodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UnicodeRestController {

    @Autowired
    UnicodeService unicodeService;

    @GetMapping("/unicode/{i}")
    public String unicodeToChar(@PathVariable int i) {
        char c = (char)i;
        return "unicode = " + i + " char = " + c;
    }

    @GetMapping("/char/{c}")
    public String CharToUnicode(@PathVariable char c) {
      int unicode = (int) c;
        return "char = " + c + " char = " + unicode;
    }

    @GetMapping("/unicode/{letter}/{number}")
    public List<Character> getCharactersByAmount(@PathVariable char letter, @PathVariable int number) {
        return unicodeService.getLetters(letter, number);
    }



}
