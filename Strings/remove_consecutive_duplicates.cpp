#include <iostream>
#include<cstring>
using namespace std;
void removeConsecutiveDuplicates(char input[]) 
{
   int len=strlen(input); // Length of the char array
    int j=1; 
    // Taking first letter to be compared with rest
    char lastChar=input[0];
    // Traversing from index 1
    for(int i=1;i<len;i++)
    {
        // comparing with last character to first element 
        // if present then skip
        if(input[i]==lastChar)
        {
            continue;
        }
        // If not same then take that variable insert it into array 
        else if(input[i]!=lastChar)
        {   lastChar=input[i];
            input[j]=lastChar;
            j++;
        }
    }
    // Appending NULL character last:
    input[j]='\0';
}

	
int main()
{
	char a[1000];
	cin.getline(a,1000);
	removeConsecutiveDuplicates(a);
	cout<<a<<endl;
}
