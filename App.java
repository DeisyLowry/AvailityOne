package com.dgl.lisp;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;


public class App 
{
    public static void main( String[] args )
    {
       // Enter String to compare
        System.out.println("Please enter a string with brackets to be evaluated");        
        Scanner in = new Scanner(System.in);
        String expression = in.nextLine();
        System.out.println("Input value is this " + expression);        
        //System.out.println(areBracketsBalanced(expression) ? "YES" : "NO"); // YES
        System.out.println(areBracketsBalanced(expression));
    }
    
      // function to check if brackets are balanced
    public static boolean areBracketsBalanced(String expr)
    {        
        
        Deque<Character> stack  = new ArrayDeque<Character>();
        
        // Traversing the Expression
        for (int i = 0; i < expr.length(); i++)
        {
            char x = expr.charAt(i);
 
            if (x == '(' || x == '[' || x == '{')
            {
                // Push the element in the stack
                stack.push(x);
                continue;
            }
 
            // cannot be empty at this point.
            if (stack.isEmpty())
                return false;
            char check;
            switch (x) {
            case ')':
                check = stack.pop();
                if (check == '{' || check == '[')
                    return false;
                break;
 
            case '}':
                check = stack.pop();
                if (check == '(' || check == '[')
                    return false;
                break;
 
            case ']':
                check = stack.pop();
                if (check == '(' || check == '{')
                    return false;
                break;
            }
        }
 
        // Check Empty Stack
        return (stack.isEmpty());
                }
}
