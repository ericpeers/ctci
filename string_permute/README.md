## Problem
Given two strings, write a method to decide if one is a permutation of the other

## Questions
Are we assuming simple permutation, or are we looking for a more complicated adjacency/similarity? E.g. speling and spelling might be a permutation because they are not far apart, or even spelling and spelking are permutations because there is a typo in the second. his=>hers are more of an nlp problem
   -assume not.
   
Are we assuming that it's sufficient to look to see if one string is a substring of the other?
   -this is too simple.  "ABC" => "XYZGHIABCDEF" could return true. This is probably o(n) in that you scan the larger of the 2 strings to see if the first letter of the smaller string is present. Then you walk each string until you either have a full match on the smaller of the string, or you have a mismatch, at which point you return to the original index of the first letter match in the larger string, increment by 1, and then move to the next. 

Are we looking to see all the ways I could organize/arrange string A into B? e.g. "ABC" => "BCA"?
   -I think this is the real question here.

Can I assume a-z, or does case/other space matter?
## Solutions
If the lengths are different, they cannot be a permutation of each other. Think of it as a grab bag for my target string. For every character in lefthand string, look to see if the character is present in right hand string, and if it is, remove it. If I ever have a character present on lhs, but not present/remaining in rhs, then this is not a permutation. If I hash each character to a count (or just use it as an index), then it's relatively compact in memory, and it gives me o(n) performance.

I could also solve this by computing all the possible permutations and then strcmping those. But the possible permuatsions are n*n-1*n-2*n-3, so that would imply an O(n!) time, and that would suck.

## Test cases
* empty
* null
* 1 char string
* 2 char string
* long string (performant)
* dup chars: aaa vs. aab, aaa vs. aaa, [aaabbcc vs ccbbaaa, aaabbcc=>acbcbaa]


## Comments
I manually checked my code via my test cases (before writing them), and discovered a problem with nulls (there are pairs here that don't otherwise happen). I also check the code and found an indexing problem where I was doing things C style.

## What I learned
* Character to int casting in Java
* Discovered how to turn off autocomplete in idea which makes the flashing less. 

## Time to complete
35 minutes
