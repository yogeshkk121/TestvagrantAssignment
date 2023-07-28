First i use Newspaper class ,this class represents a newspaper subscription and contains the name of the newspaper and its daily prices in Indian rupees.
then NewspaperSubscriptions class implements the logic to calculate all possible combinations of newspaper subscriptions within the given weekly budget.

In the constructor of NewspaperSubscriptions, the program initializes a list of Newspaper objects and populates it with the newspaper names and their corresponding daily prices.

This method is a recursive function that explores all possible combinations of newspaper subscriptions for each day of the week.
It takes several parameters: result (a list to store the valid combinations), currentCombination (a list to keep track of the current combination being considered), dayIndex (an index representing the current day), and remainingBudget (the budget left after considering the subscriptions till the current day).
The method starts by checking the base case: if dayIndex is equal to 7 (Sunday), it means we have considered all days of the week, and if there's still a non-negative remainingBudget, it means we found a valid combination. In this case, the current combination is added to the result list.
If the base case is not met, the method iterates through all newspapers and checks if the budget is sufficient to subscribe to that newspaper on the current day. If so, it adds the newspaper to the currentCombination list and calls itself recursively for the next day with the updated budget.

findCombinations method is the entry point for calculating all possible combinations of subscriptions for a given weekly budget.
It initializes an empty result list and calls the findCombinations method to generate all valid combinations. The result is then returned.

In the main method, an instance of NewspaperSubscriptions is created.
The weekly budget is set to 40 rupees.
The 
findCombinationsHelper  method is called to find all possible combinations for the given weekly budget.
Then prints the possible combinations.

if i give weekly budget as 40.0 then Possible combinations are,
[TOI, BM]
[BM, HT]
[Hindu, BM]
[Hindu, HT]
