#include<iostream>
using namespace std;
void bubbleSort(int *input, int size)
{
    int temp=0;
    // Taking care of the number of rounds
    for(int j=0;j<size-1;j++) 
    {
        // Traversing through the array to compare and swap therough the elements.
        for(int i=0;i<size-j-1;i++)
        {
            if(input[i]>input[i+1])
            {
                temp=input[i];
                input[i]=input[i+1];
                input[i+1]=temp;
            }
    	}
    }   
}

int main()
{

	int t;
	cin >> t;

	while (t--)
	{
		int size;
		cin >> size;

		int *input = new int[size];

		for (int i = 0; i < size; ++i)
		{
			cin >> input[i];
		}

		bubbleSort(input, size);

		for (int i = 0; i < size; ++i)
		{
			cout << input[i] << " ";
		}

		delete[] input;
		cout << endl;
	}
}
