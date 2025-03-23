package com.NeoBank;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.NeoBank.config.NeoBankApplication; // Make sure this import is correct

@SpringBootTest(classes = NeoBankApplication.class)  // Explicitly specify the main application class
class NeoBankApplicationTests {

    @Test
    void contextLoads() {
    }
}
