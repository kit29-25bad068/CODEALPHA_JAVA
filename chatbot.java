import java.util.*;
public class chatbot{
    HashMap<String, String> responses;

    public chatbot(){
        responses = new HashMap<>();
        String[] greetings = {"hello", "hi", "hey", "howdy"};
        for(String g : greetings){
            responses.put(g, "Hi there! How can I help you?");
        }
        String[] name = {"name", "who are you", "introduce yourself"};
        for(String n : name){
            responses.put(n, "I am JavaBot, your AI assistant!");
        }
        String[] abt = {"who created you", "who made you", "who is your creator"};
        for(String a : abt){
            responses.put(a, "I was created by a student to assist you!");
        }
        String[] help = {"help", "assist", "support"};
        for(String h : help){
            responses.put(h, "You can ask me about AI, Java, Data Science or just chat!");
        }
        String[] ai = {"what is ai", "artificial intelligence", "ai"};
        for(String a : ai){
            responses.put(a, "AI is the simulation of human intelligence in machines.");
        }
        String[] java = {"what is java", "java"};
        for(String j : java){
            responses.put(j, "Java is a high-level, object-oriented programming language.");
        }
        String[] joke = {"joke", "tell me a joke", "make me laugh", "funny"};
        for(String j : joke){
            responses.put(j, "Why do programmers prefer dark mode? Because light attracts bugs!");
        }
        String[] encourage = {"encourage me", "motivate me", "sad", "feeling down"};
        for(String e : encourage){
            responses.put(e, "Keep pushing forward! Every step is closer to your goal!");
        }
        String[] ds = {"data science", "data", "ds"};
        for(String d : ds){
            responses.put(d, "Data Science involves extracting insights from structured and unstructured data.");
        }
        String[] ml = {"machine learning", "ml"};
        for(String m : ml){
            responses.put(m, "Machine Learning is a subset of AI that enables systems to learn from data.");
        }
        String[] python = {"python"};
        for(String p : python){
            responses.put(p, "Python is the most popular language for AI and Data Science!");
        }
        String[] bye = {"bye", "exit", "goodbye", "see you", "tata"};
        for(String b : bye){
            responses.put(b, "Bye! Have a great day!");
        }
    }
    public String getResponse(String input){
        input = input.toLowerCase();
        for(String key : responses.keySet()){
            if(input.contains(key)){
                return responses.get(key);
            }
        }
        return "I'm not sure how to respond to that. Can you ask something else?";
    }
}
import java.util.Scanner;

public class Main_chatbot {
    public static void main(String[] args){
        Scanner  s = new Scanner(System.in);
        chatbot bot = new chatbot();
        System.out.println("Welcome to the Chatbot! How can I help you?");
        while(true){
            System.out.print("You: ");
            String userInput = s.nextLine();
            if(userInput.equalsIgnoreCase("exit") || userInput.equalsIgnoreCase("bye")){
                System.out.println("Chatbot: Goodbye!");
                break;
            }
            String response = bot.getResponse(userInput);
            System.out.println("Chatbot: " + response);
        } 
        s.close();
    }
}
