/*
  Rewrite Programming Exercise 11.16 to store the answers in a set rather than a
  list.
*/

import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class E21_15 {
  public static void main(String[] args) {
    int number1 = (int)(Math.random() * 10);
    int number2 = (int)(Math.random() * 10);

    Scanner input = new Scanner(System.in);

    System.out.print("What is " + number1 + " + " + number2 + "? ");
    int answer = input.nextInt();

    Set<Integer> answers = new HashSet<>();
    while (number1 + number2 != answer) {
      if (answers.contains(answer)) {
        System.out.println("You already entered " + answer);
      }
      System.out.print("Wrong answer. Try again. What is " +
        number1 + " + " + number2 + "? ");
      answers.add(answer);
      answer = input.nextInt();
    }

    System.out.println("You got it!");
  }
}
