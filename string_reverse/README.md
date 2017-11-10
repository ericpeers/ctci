### Problem
In C or C++, iimplement a function void reverse(char *str) which reverses a null terminated string

### Questions
You want this as a reverse-in-place, right? Because it looks like you have a void, so that would imply no return value, no new string allocation.
Stupid question, but no multiple nulls - because function param doesn't include strlen in that case. That means we treat it like a pure C string.
If I get a null, can I return a null?
This is standard ascii right? It doesn't really matter, but if I need to treat it as unicode embedded in char, then I probably need to swap things as re-cast short's.

### Comments
* I've seen this one before. Should have gone faster - but I'd never written it in C before.
* If I changed the requirement to return a char *, testing becomes way easier. I can do things like printf("%s,%s\n", str, reverse(str)) instead of what I hacked together.

### Compiling it
```
gcc reverse.c
a.out
```

### Test cases
* Empty String
* Null String
* String length of 1
* Even string
* Odd length string, not 1.
* Less Interesting
    * String with numbers, other extended ascii. (am I 7 bit?)
    * Long string (still performant)

### Solution A
Foreach character in the string up to the middle of the string, swap with the mirror character on the opposing side. Note: use a countdown on the opposing side so I have an incrementor and a decrementor and I don't have to do math on each. This could make for even faster implementation later since I've got less math. Note note: subtraction vs. decrement has an equal cost, so you're not really getting faster math unless it involves strlen.

### Solution B
There is no more optimal solution. But you could recurse. You could make a copy and walk backwards.


### Time to complete
40m. 3 minor interruptions - network connection hiccuped twice, one work interruption/question. Eating dinner. 

### Things I learned
* C is easy. Except for where it core dumps.
* Thought more about the midpoint in explaining it
* C Unit is still not easy - looked at implementing one quickly
* made a mistake in returning str vs. no return. Mixing languages.
* this could be really bad for statically allocated strings - especially in program space.
* Testing is crazy important. I wrote the code initially, and set str[i] = mirror -- should be str[mirror]. It was wrong.
* Also had a problem with my printf / testing code I hacked together which caused a core dump. Surprised gcc didn't warn me I forgot to include
  the parameter in my printf. It now checks type at the compiler level, but didn't here.
* Sublists are four spaces in markdown. Somebody has a penchant for the proper indentation length. How did I ever think 3 spaces were right for 2 years in college? I guess I was "experimenting"