## Problem
Convert a string aaabbcddd to a3b2c1d3. If the compressed string is longer than the original, then return the original

## Questions
* assume ascii?
* Does case matter?
* Can I have numbers in my string? should I escape those? Assume no numbers

## Solutions
iterate across the string. Count the character that I'm on. If I am on a different character, emit current character and count.

Early exit: If output length is > string length, then exit. 

## Test cases
* Empty String
* Null string
* Long string
* String len 1
* String with only dups
* String with equal length
* String with a dup/tuple at the end
* String with numbers (escape them)
* String with backslash (escape it)

## Comments
I'm curious what the performance is of charAt vs. toCharArray

## What I learned
* Walk through my test cases manually. It's too easy to let unit test catch issues.
* Length is not a method on primitive arrays. It is a property. 

## Time to complete
20m