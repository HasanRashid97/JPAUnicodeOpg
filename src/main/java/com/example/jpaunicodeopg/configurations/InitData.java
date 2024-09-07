package com.example.jpaunicodeopg.configurations;

import com.example.jpaunicodeopg.services.UnicodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitData implements CommandLineRunner {

    @Autowired
    UnicodeService unicodeService;

    @Override
    public void run(String... args) throws Exception {
        unicodeService.saveUnicode();
    }
}
