#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int solution(int n) {
    int answer = 0;
    int num = n;
    int rem = 0;
    while(num != 0){
        rem = num%3;
        answer *= 3;
        answer += rem;
        num /= 3;
    }
    return answer;
}