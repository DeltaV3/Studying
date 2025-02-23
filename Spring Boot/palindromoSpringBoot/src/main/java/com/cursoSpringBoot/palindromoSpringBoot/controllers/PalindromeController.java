package com.cursoSpringBoot.palindromoSpringBoot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PalindromeController {

    /**
     * Endpoint para verificar si una palabra es un palindromo
     * @param word la palabra a verficar
     * @return si la palabra es un palindromo
     */
    @GetMapping("/palindromo/{word}")
    public String Palindrome(@PathVariable String word) {
        if (isPalindrome(word)) {
            return "La palabra " + word + " es un palindromo" ;
        } else {
            return "La palabra " + word + " no es un palindromo" ;
        }
    }

    /**
     * Metodo para verificar si la palabra es un palindromo
     * @param word la palabra a verificar
     * @return true si la palabra es un palindromo, false lo contrario
     */
    private boolean isPalindrome(String word) {
        int length = word.length();
        for (int i = 0; i < length / 2; i++) {
            if (word.charAt(i) != word.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
