### Problem
Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures.

### Questions
Do we care about character encoding (makes it a 2 byte solution for B)? What about case (upper vs lower)? 0-9 and other non alpha's allowed to be excluded?

### Solution A
Foreach character in the string, check to see if it is contained in the set. If it is, then return false. If it at end of routine, set to true. 

### Complexity A
Insertion times dependent on underlying set insertion time. Since each insert is o(1), and my lookup is o(1), I have n inserts, and I have n lookups. That's o(2n), which still comes out to roughly o(n). But my worst case can be worse in o(n) can be an insert time for atypical, which gives me o(n^2). The static array allocation in B is probably going to be faster, but for anything other than an 8 bit allocate in char, this one is probably better understood.


### Tests for A
* Empty String
* Null String
* String of numbers and other interesting characters
* Upcase vs. lowcase
* Long String - do we exit in a hueristic time? Memory bounded?
* Short string - just "a". In case someone handles boundary conditions wrong
* "aa"
* "hello" - has a duplicate
* "helloh" - dups at boundary conditions
* "abcdefghijklmn" - no dups
* "AabBcCdD" - no dups
* Spaces - dups and no dups


### Solution B
create a set by using an array of booleans that is max sized at 256 or 65536 and initialized to false. Foreach character in string, check to see if false. If present, we return "false". Otherwise, mark it present with a "true".

### Solution B prime
Use bit shifting for your booleans to store 32 of them at a time and bitmask and shift.  Index into the array is the character right shifted by 5 (2^32), and pick off which byte within the array by low order 5 bytes.

### Solution B prime prime
Run o(n^2) by iterating across the same string multiple times, starting 1 character forward each time, and going to end of string (i and then j) and see if there is a match from current character. J always starts one later in the string than i except at end of str.




### Comments
Autobuilding mvn - seems slow the first time but...
```
mvn archetype:generate -DgroupId=net.mtnboy -Dpackage=net.mtnboy.StringUnique -DartifactId=string-app -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```