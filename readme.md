###### **TrueAccord Take Home**

This is my submission for the TrueAccord take home. It took me about 2 and a half hours in total, with the first hour spent mainly researching a java client. The one i normally use is part of springboot framework, so had to find a standalone one.

A few things about the submission:
1. It says the _remaining_amount_ field should be output as a "JSON number". I am not entirely sure what that is referring to, so i kept as many decimals as possible for preciseness.
2. The Payment Plans and Payments documentation says that the dates will be coming in DateTime format (even shown in sample payload). However, the endpoints that i hit only returned a Date format (no time). So, I went with what the live environment was returning (and outputted just Date) and assumed that the documentation was out of date.
3. I am assuming that Bi-weekly means every 14 days (as opposed to twice a week as meant by Bi-Annually).

My Process/Approach:
I dont think my approach for this problem was too complicated. I started with the external dependencies first, as that is a straightforward task that doesnt require any special logic. I built out models to reflect the API response objects, so they can easily be updated as the resources change.

Beyond that, I iteratively added the functionality, making sure its always working. This involved taking in the responses form the APIs and slowly performing different calculations and comparisons between the data sets. I then continued to teak small details to ensure it is correct, for example swapping my types to Big Decimal as double was inccorectly measuring the substraction values.

Things i would have done differently would have been the structure of my project and error handling. I would have broken the functions into their own static helper methods which had all data sets passed into it instead of always pulling from the full dataset returned from the API in a private variable. This would have had the business logic as a de-coupled standalone function which could have been called by any other classes/flows (for better reusibility). As well, error handling on the APIs to check for all the HTTP error codes and gracefully failing rather than hitting some type of exception. I also would have added more test cases to test for null pointers, etc. But due to the time restriction, i focused on edge cases of the problem at hand (such as a new payment plan, missed payments, etc) rather than showing my ability to null check.