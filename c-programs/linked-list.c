#include <stdio.h>
#include <stdlib.h>

struct node {
  int data;           
  struct node* next;     
};       

int main(){
    
  struct node* head = (struct node*)malloc(sizeof(head));
  struct node* nNode = head;
  
 /* Take user inputs, keep storing them in linked list and then print them */
 int val = 0;
 char decide;
 while(1){
    printf("Please enter a number you want to store : ");
    scanf("%d",&val);           
    nNode->data = val;
    nNode->next = NULL;

    printf("want to enter more numbers ( y / n ) ? ");    
    scanf(" %c",&decide);
    if(decide != 'y' && decide != 'Y'){
       break;
    }
    nNode->next = (struct node*)malloc(sizeof(head)); 
    nNode = nNode->next;         
 }       
 
  /* Print the linked list*/
  struct node* n1Node = head;
  printf("\n Here is what you had entered \n");
  do{
     printf(" %d ",n1Node->data);
     n1Node = n1Node->next;    
  } while(n1Node != NULL);
  
 return 0;   
}    
