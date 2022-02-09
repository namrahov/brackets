package com.string.controller;

import com.string.service.BracketsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/bracket")
public class BracketsController {

    private final BracketsService bracketsService;

    public BracketsController(BracketsService bracketsService) {
        this.bracketsService = bracketsService;
    }

    @PostMapping("/detect")
    public void detectBracketsType(@RequestParam String filePath) {
        bracketsService.detectBracketsType(filePath);
    }
}
