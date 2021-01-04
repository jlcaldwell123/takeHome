TrueAccord Take Home

This is my submission for the TrueAccord take home. It took me about 2 and a half hours in total, with the first hour spent mainly researching a java client. The one i normally use is part of springboot framework, so had to find a standalone one.

A few things about the submission:
1. It says the _remaining_amount_ field should be output as a "JSON number". I am not entirely sure what that is referring to, so i kept as many decimals as possible for preciseness.
2. The Payment Plans and Payments documentation says that the dates will be coming in DateTime format (even shown in sample payload). However, the endpoints that i hit only returned a Date format (no time). So, I went with what the live environment was returning (and outputted just Date) and assumed that the documentation was out of date.
3. I am assuming that Bi-weekly means every 14 days (as opposed to twice a week as meant by Bi-Annually).