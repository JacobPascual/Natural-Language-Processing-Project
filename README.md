# Natural-Language-Processing-Project
This is my Unit 6 APCSA Project

# Unit 6 - Natural Language Processing Project

## Introduction

Natural language processing (NLP) is used in many apps and devices to interact with users and make meaning of text to determine how to respond, find information, or to create new text. Your goal is to use natural language processing techniques to identify structure, patterns, and meaning in a text to have conversations with a user, execute commands, perform manipulations on the text, or generate new text.

## Requirements

Use your knowledge of object-oriented programming, ArrayLists, the String class, and algorithms to create a program that uses natural language processing techniques:

- **Create at least two ArrayLists** – Create at least two ArrayLists to store the data used in your program, such as data from text files or entered by the user.
- **Implement one or more algorithms** – Implement one or more algorithms that use loops and conditionals to find or manipulate elements in an ArrayList or String object.
- **Use methods in the String classs** - Use one or more methods in the String class in your program, such as to divide text into sentences or phrases.
- **Use at least one natural language processing technique** – Use a natural language processing technique to process, analyze, and/or generate text.
- **Document your code** – Use comments to explain the purpose of the methods and code segments and note any preconditions and postconditions.

## UML Diagram

Put and image of your UML Diagram here. Upload the image of your UML Diagram to your repository, then use the Markdown syntax to insert your image here. Make sure your image file name is one word, otherwise it might not properly get display on this README.

![UML Diagram for my project](![alt text](image.png))

## Video

Record a short video of your project to display here on your README. You can do this by:

- Screen record your project running on Code.org.
- Upload that recording to YouTube.
- Take a thumbnail for your image.
- Upload the thumbnail image to your repo.
- Use the following markdown code:

[![Thumbnail for my projet](![alt text](image-1.png))]([youtube-URL-here](https://youtu.be/dxkJboO1XWE))

## Project Description

My application is a recipe generator app that generates recipes based on what the user wants to make. The program analyzes user input to determine the type of recipe they'd like, and then uses a series of keywords to filter a list of recipes for the user. After filtering the lists of recipes, it prints all possible indexes that would match the user's description

## NLP Techniques

I implemented keyword tagging and data analysis into my project, which was exemplified in the method Filter(String input) as it takes a string provided by the user and separates each word into an index of an ArrayList. It then goes through that ArrayList and checks if each word matches a keyword that will determine which filter is used on the recipe list. 