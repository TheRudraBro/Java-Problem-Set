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

------------------------------------------------------------------------------------

Problem 4 :  
In a smart city traffic control system, multiple intersections operate with automated signals
that must coordinate to manage vehicle flow efficiently. Each intersection can be represented as a
separate thread, where every signal cycles through red, green, and yellow lights with specific
time durations. To simulate real-time control, Thread.sleep() can be used to create delays
between light changes. Synchronization is necessary to ensure that no two nearby intersections
show a green light simultaneously, preventing accidents and traffic jams. A central
TrafficController class can be introduced to manage coordination among signals and assign
thread priorities, giving more green time to signals on main roads compared to side roads.

------------------------------------------------------------------------------------

Problem 5 :  
At a busy polling center during an election, people are standing in a long line to cast their
votes. However, the election authority has set special rules for managing the voting line. Senior
citizens (age 60 or above), individuals with disabilities, and pregnant women must be allowed to
vote earlier than regular voters. New voters continue to arrive one by one, and the staff must
decide who should enter the booth next based on these rules. Sometimes multiple high-priority
voters arrive together, and the order must still follow the rules strictly. Write a program that
manages the voting line according to these rules and prints the sequence in which voters will
actually vote.

------------------------------------------------------------------------------------

Problem 6 :  
6.In a busy election office, three staff members work together to prepare voter ID cards. One
staff member collects the voter details from applicants, another verifies the information, and the
last person prints the final ID card. All three tasks must happen in correct order for each

applicant: collect → verify → print. Multiple applicants are arriving continuously, and each staff
member works in their own separate unit at the same time. However, the process must ensure
that no applicant’s ID is printed before their information is properly collected and verified.
Create a program that uses multiple threads to represent the three staff members and ensures that
for every applicant, the tasks are completed in the correct order without mixing up different
applicants’ data.