package com.testvgrant;

import java.util.ArrayList;
import java.util.List;

class Newspaper {
    String name;
    double[] prices;

    public Newspaper(String name, double[] prices) {
        this.name = name;
        this.prices = prices;
    }

    public double getPriceOnDay(int day) {
        return prices[day];
    }
}

public class NewspaperSubscriptions {

    public static void main(String[] args) {
        // Data structure to hold newspaper details
        List<Newspaper> newspapers = new ArrayList<>();
        newspapers.add(new Newspaper("TOI", new double[]{3, 3, 3, 3, 3, 5, 6}));
        newspapers.add(new Newspaper("Hindu", new double[]{2.5, 2.5, 2.5, 2.5, 2.5, 4, 4}));
        newspapers.add(new Newspaper("ET", new double[]{4, 4, 4, 4, 4, 4, 10}));
        newspapers.add(new Newspaper("BM", new double[]{1.5, 1.5, 1.5, 1.5, 1.5, 1.5, 1.5}));
        newspapers.add(new Newspaper("HT", new double[]{2, 2, 2, 2, 2, 4, 4}));

        double budget = 40;
        List<List<String>> combinations = findCombinations(newspapers, budget);

        // Print all possible combinations
        for (List<String> combination : combinations) {
            System.out.println(combination);
        }
    }

    public static List<List<String>> findCombinations(List<Newspaper> newspapers, double budget) {
        List<List<String>> result = new ArrayList<>();
        List<String> currentCombination = new ArrayList<>();
        findCombinationsHelper(newspapers, budget, 0, currentCombination, result);
        return result;
    }

    private static void findCombinationsHelper(List<Newspaper> newspapers, double budget,
                                               int startIndex, List<String> currentCombination, List<List<String>> result) {
        if (budget == 0) {
            // Found a valid combination
            result.add(new ArrayList<>(currentCombination));
            return;
        }

        for (int i = startIndex; i < newspapers.size(); i++) {
            Newspaper newspaper = newspapers.get(i);
            for (int day = 0; day < newspaper.prices.length; day++) {
                if (newspaper.getPriceOnDay(day) <= budget) {
                    // Add newspaper to the current combination
                    currentCombination.add(newspaper.name);

                    // Recursive call with reduced budget and updated startIndex to avoid duplicates
                    findCombinationsHelper(newspapers, budget - newspaper.getPriceOnDay(day), i + 1, currentCombination, result);

                    // Backtrack: Remove the last newspaper added to try other combinations
                    currentCombination.remove(currentCombination.size() - 1);
                }
            }
        }
    }
}
