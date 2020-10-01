#include<iostream>
using namespace std;
void insertionSort(int *input, int size)
{
    // Write your code here
    // First loop will be for traversing array from 1 to n;
    for(int i=1;i<size;i++)
    {
        // Second loop will be for comaprison
        // Keeping the current value of index i as a backup to be shifted later
        int j;
        int current=input[i];
        for(j=i-1;j>=0;j--)
        {
            //Now comparing with the value of index current and index j.
            if(current<input[j])
            {
                // If condition is true we will shift the values towards right.
            	input[j+1]=input[j];
            }
            // As the if condition goes false we'll break the j loop
            // The calculation for the rest goes same
            else
            {
                break;
            }
        }
        // Calculation referenced through j loop.
        input[j+1]=current;
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

		for (int i = 0; i < size; i++)
		{
			cin >> input[i];
		}

		insertionSort(input, size);

		for (int i = 0; i < size; i++)
		{
			cout << input[i] << " ";
		}

		delete[] input;
		cout << endl;
	}

	return 0;
}
