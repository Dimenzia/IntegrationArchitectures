package de.hbrs.ia.controller;

import de.hbrs.ia.exceptions.InvalidInputException;

import java.io.BufferedReader;
import java.io.IOException;

public class CheckFunctions {

    public static int positiveIntegerCheck(BufferedReader reader) throws InvalidInputException, IOException {
        try {
            int i = Integer.parseInt(reader.readLine());
            if(i < 0) {
                throw new InvalidInputException("");
            }
            return i;
        } catch (NumberFormatException | InvalidInputException e) {
            throw new InvalidInputException("Invalid input, please enter a positive number (starting by 0)");
        }
    }

    public static String nameCheck(BufferedReader reader) throws InvalidInputException, IOException {
        String s = reader.readLine();
        try {
            int i = Integer.parseInt(s);
            throw new InvalidInputException("Invalid input, please enter a name");
        } catch (NumberFormatException e) {
            return s;
        }
    }

    public static int yearCheck(BufferedReader reader) throws InvalidInputException, IOException {
        try {
            int i = Integer.parseInt(reader.readLine());
            if (i < 1970) {
                throw new InvalidInputException("");
            }
            return i;
        } catch (NumberFormatException | InvalidInputException e) {
            throw new InvalidInputException("Invalid input, please enter a year after 1970");
        }
    }
}
