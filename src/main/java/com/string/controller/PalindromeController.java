package com.string.controller;

import com.string.service.PalindromeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/palindrome")
public class PalindromeController {

    private final PalindromeService palindromeService;

    public PalindromeController(PalindromeService palindromeService) {
        this.palindromeService = palindromeService;
    }

    @PostMapping("/detect")
    public void detectPalindromeOfNumber(@RequestParam String filePath) {
        palindromeService.detectPalindromeOfNumber(filePath);
    }
}
