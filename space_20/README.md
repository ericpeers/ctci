### Problem

Write a method to replace all spaces in a string with'%20'. You may assume that
the string has sufficient space at the end of the string to hold the additional
characters, and that you are given the "true" length of the string. (Note: if imple-
menting in Java, please use a character array so that you can perform this opera-
tion in place.)


### Questions
%20 - I'm assuming with the %20 as 3 characters, not a special encoding.
What's the "true" length of the string? Do you mean the length of the string, not the extra/available space.
Use a character array - I still need to resplice that array to move everything right, right? I don't have 3 spaces available in the right spot - I have them at the end, right?
Why in space? Other than you want to see me remove the remaining string? That could be slower because I have to recopy the string.
Can I not assume that the string has sufficient space? If I convert to character array, that array will be compact. I need to really add enough space at the end, no?

### Test cases
* Null, empty string
* Space at front of string
* no spaces
* Only space
* Space in middle of string - relocate remainder
* Space at end of string
* Multiple spaces

### Solution A
*iterate and count the spaces. Count them. Create char array of size str.length + 2 *spaces. (each space takes %20, but we already have one slot)
* iterate until you find a space. Put %20 in target. Then move to the next part of the string.

### Solution B
Splice the target array? Rebuild array from scratch each time.

### Time to Complete
25 minutes. Took a bit of time to look at editor. Still not thrilled with autocompletion presenting code choices to me within a second. Makes me ill to see the editor flashing while typing. Used the IDE for this though. 

### Mistakes I made
* Forgot to new a String as a return. Compilation error
* Testcase looked for empty to empty and null to null. I coded both to null in a fast case.

### Things I learned
* more on char arrays. Nothing specific here. Was trying to move fast.
* I still like, and think, in snake case.
 