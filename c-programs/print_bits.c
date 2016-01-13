#include <stdio.h>

void printBits(int i);

int main(){
    int i = 0;
    printf("Enter a number : ");
    scanf("%d",&i);
    printf("\nHere is the number in bit format : ");
    printBits(i);
}    

void printBits(int i){
   int count, andMask;
   for(count = 31; count >= 0; count--){
      andMask = 1 << count;
      if(i & andMask){
           printf("1");     
      }else{
           printf("0");
      }           
   }          
}     
