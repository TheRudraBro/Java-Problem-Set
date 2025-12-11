## JAVA Problem Set 
------------------------------------------------------------------------------------
Problem 1 : 
To clean and format inconsistent customer names into proper case in Java, you first trim the leading and trailing spaces, then convert the entire string to lowercase to remove mixed-case issues, and finally split the name into individual words. For each word, you capitalize the first letter and keep the remaining letters in lowercase, then join all the formatted words back together with a single space. This ensures that inputs like " rAhUL shArmA ", "NEHA singh", or " ajAY VERMA" are normalized by removing extra spaces, correcting letter casing, and producing a clean, properly formatted result such as Rahul Sharma or Ajay Verma.

------------------------------------------------------------------------------------

Problem 1 :  
A banking system processes each customer transaction in a separate thread, but some
transactions fail due to errors like invalid amounts, number-format issues, or arithmetic errors
during fee calculation. Write a Java program where each thread handles one transaction and uses
proper exception handling inside the thread so that any error is caught and logged without
stopping other running threads.

------------------------------------------------------------------------------------

Problem 3 : 
At a university, the IT department is developing an automated system to analyze student
feedback collected after each semester. Since large amounts of text need to be processed, the
developer decides to use multithreading to speed up string operations. One thread counts how
many words are in the feedback, another identifies the longest word to detect key highlights, and
a third converts the feedback text to lowercase for normalization. By running these tasks
simultaneously using threads, the program efficiently demonstrates how string processing and
threading can work together for real-time text analysis in Java.