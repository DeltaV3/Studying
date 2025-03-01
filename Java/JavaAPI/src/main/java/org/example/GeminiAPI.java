package org.example;
import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;

import javax.swing.*;

public class GeminiAPI {
    public static void main(String[] args) {
        String apiKey = System.getenv("GEMINI_API_KEY");
        if (apiKey == null || apiKey.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por Favor, por una API valida", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Client client = Client.builder().apiKey(apiKey).build();

        try {
            String text = JOptionPane.showInputDialog("Preguntale a don Gemini ");
            GenerateContentResponse response = client.models.generateContent(
                    "gemini-2.0-flash",
                    text,
                    null
            );
            JOptionPane.showMessageDialog(null, "Pregunta: "+ text + "\n\n" + response.text());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
