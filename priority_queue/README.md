## Problem
Implement a priority queue with 3 priorities represented as integers. Support the following functions:
* Remove an item
* Max size
* N priorities

## Questions
* Doesn't n priorities obviate the 3 priorities? Can I just implement as n priorities? Yes
* What should I do if the queue is at max size? Stop adding elements
* If I already have items in the queue with the priorities, random insert, or first in first out? FIFO

## Solutions
This is basically a linked list with 2 elements: priority, payload where the insertion order is based on priority. As long as the current elements priority >= priority then I should move to the next element.

I'm also assuming this could also be implemented with a sorted queue, where I submit a lambda function for that queue to pick how I sort.

This could also be implemented as 2 queues - where the first is the priority, and the second queue is the payload. 

## Test cases
* Insert into an empty queue
* Insert at the end of a populated queue
* Insert one before the end of a populated queue
* Insert at the front of a populated queue
* Insert a dup element
* Insert into a full queue
* Insert an element after existing elements in the queue.

## Comments


## What I learned
* Enumerated types in java
* Generics / templates in java
* primitive to class conversion and back
* Vector is a better arbitrary insertion class

## Time to complete
60m
45m for code
15 m for tests
