## Problem
Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, write a method to rotate the image by 90 degrees. Can you do this in place?

## Questions
* By in place, do I have to rotate the image? Or can I create an access method that just returns the data rotated instead?
* Why 4 bytes? RGB would be 3 no?
* 4 bytes in each row per pixel, right? so N*4 in the row? Or is it in column or some other esoteric format?
* In place - 4 way swap ok? Is that "in place enough?"
* Is it ok to create a single row/columns worth of data for the swap?


## Solutions
### Rotation matrices
```
A B C D    M I E A
E F G H    N J F B
I J K L    O K G C
M N O P    P L H D

ABCDE UPKFA 
FGHIJ VQLGB
KLMNO WRMHC
PQRST XSNID
UVWXY YTOJE
```

A=> 0,0 to 0,4.
F=> 1,1 to 2,2.
G=> 1,2 to 2,1
algorithm is take current row, and shift to column n-1-row#
so row 0 becomes 4-1-0 = column 3
row 1 becomes 4-1-1 = column 2.
this, unfortunately doesn't work in place.

so instead, rotate each ring, one at a time. Stopping at row > (ring /2). Odd elements in center (size n%2 != 0) need not be flipped. Each ring adds 1 to each of row,col.


## Test cases
* empty matrix, null
* 1x1, 2x2, 3x3, 4x4, 5x5, 7x7
* 4 byted-ness may be interesting, but I could just treat this as an int. Having or signature values in the high order and small order bytes*

## Comments
* My brain doesn't like this problem for some reason. It seems inelegant to build a ring based approach for in place.
* Getting the math right between row and column is tricky.

## What I learned
* Array initialization in Java uses left to right, 0th element on the left
* Newest version of Junit has array comparators. Maven brings in an earlier version.



## Time to complete
3 hours
