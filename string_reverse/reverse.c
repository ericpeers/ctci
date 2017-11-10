#include <stdio.h>
#include <string.h>


void reverse (char *str) {
    if (str == NULL) return; //null ptrs are bad. defensive coding.

    int len = strlen(str);
    if (len == 0) return; //early exit. Empty str.

    int mirror = len - 1; // 0 based index. Gotta drop one.

    //midpoint may be this value, or this value + 0.5 (odd numbers). I don't have to mirror/reverse the centerpoint in an odd
    //string. Eg: XYCAB will only flips [0] for [4] and [1] for [2]. [3] remains constant.

    int midpoint = len >> 1; // don't assume I have a smart compiler. Do it here to prevent reevaluation of the div each time. Also assume that
                             // compiler is dumb and will implement a div as a more costly operation. Maybe it won't.
                             // finally demonstrate how clever I am with a right shift 1 is equal to a div 2.


    for (int i=0;i<midpoint;i++) {
        char swap; //aka the xchg primitive in x86 Assembly. opportunity for optimization.
        swap = str[i];
        str[i] = str[mirror];
        str[mirror] = swap;
        mirror--;
    }

}

void main(void) {
    char str[256];
    reverse(NULL); //shouldn't do anything.

    str[0] = '\0';
    printf("%s,", str); reverse(str); printf("%s\n", str);

    //strlen of 1
    strncpy(str, "a", 255);
    printf("%s,", str); reverse(str); printf("%s\n", str);

    //even
    strncpy(str, "abcdDCBA", 255);
    printf("%s,", str); reverse(str); printf("%s\n", str);


    //strlen 5, odd
    strncpy(str, "hello", 255);
    printf("%s,", str); reverse(str); printf("%s\n", str);


}
