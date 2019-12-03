# String API Documentation

This API returns information about given string (lower/uppercase letter, number and special characters count and also total count of letters in the word) in JSON format.

How to use:
1. Launch the application
2. Enter the query in browser: http://localhost:8080/service?text=VALUE 
      *Note! Replace 'VALUE' with desired string*
3. The program will return response in JSON

FUNCTIONS:

void countLowerCaseLetters(void) - This function counts lower case letters in the given string and sets 'lowerCase' variable on it's Service object to the counted amount; 

void countUpperCaseLetters(void) -This function counts upper case letters in the given string and sets 'upperCase' variable on it's Service object to the counted amount;

void countNumbers(void) - This function counts numbers in the given string and sets 'numbers' variable on it's Service object to the counted amount;

void countSpecialSigns(void) - This function counts special signs in the given string and sets 'specialCharacters' variable on it's Service object to the counted amount;

void countAll(void) - This function counts all characters in the given string in the given string and sets 'characterSum' variable on it's Service object to the counted amount;

CLASSES:

Ex2Application.java - SpringBoot Java class, starts the service;

Service.java - A Java class that counts characters in the string passed by the service and stores the counted values in it's variables

ServiceController.java - Service controller Java class. It gets the value from the endpoint and return JSON string containing information about the string (given string, lower case characters count, upper case characters count, numbers count, special characters count and number of characters in the given string). 

**Example for string 'VALUE':**
{"aString":"VALUE","lowerCase":0,"upperCase":5,"numbers":0,"specialCharacters":0,"characterSum":5}
