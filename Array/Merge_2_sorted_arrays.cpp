#include<iostream>
using namespace std;
void insertion_sort(int *arr,int n)
{
    for(int i=1;i<n;i++)
    {
    // Taking the current value of arr[0]
      int current=arr[i];
      int j;
      // We need this loop to compare current value with left elements of the array.
      for(j=i-1;j>=0;j--)
      {
      //if the current value is less than arr[0]
      //i.e. i=1,j=i-1..therefore if i=1, j becomes 0
      // Taking this into calculation
      // If found the we'll shift right else break
        if(current<arr[j])
        {
          arr[j+1]=arr[j];
        }
        else
        {
          break;
        }
      }
      // If the left side remains sorted so no need to
      // do operations simply put the current value in
      // the array
      arr[j+1]=current;
    }
}


void merge(int *arr1, int size1, int *arr2, int size2, int *ans)
{
    //Write your code here    
    // Since we need to sort two arrays.
    insertion_sort(arr1,size1);
    insertion_sort(arr2,size2);
    int i=0,j=0,k=0;
    // Traversing both the arrays
    while(i<size1 && j<size2)
    {
      // Checking if current element of first array
      // is smaller than current element of second array.
      // If yes, store first array element and increment first array index.
      // Otherwise do the same with second array index.
      if(arr1[i]<arr2[j])
      {
        ans[k]=arr1[i];
        k++;i++;
      }
      else
      {
        ans[k]=arr2[j];
        k++;j++;
      }
    }
    // Storing remaining elements of first array.
    while(i<size1)
    {
      ans[k]=arr1[i];
      k++; i++;
    }
    //Storing remaing elements of second array.
    while(j<size2)
    {
      ans[k]=arr2[j];
      k++;j++;
    }
}

//Driver Code:
int main()
{
	int t;
	cin >> t;
	
	while (t--)
	{
		int size1;
		cin >> size1;

		int *arr1 = new int[size1];

		for (int i = 0; i < size1; i++)
		{
			cin >> arr1[i];
		}

		int size2;
		cin >> size2;

		int *arr2 = new int[size2];

		for (int i = 0; i < size2; i++)
		{
			cin >> arr2[i];
		}

		int *ans = new int[size1 + size2];

		merge(arr1, size1, arr2, size2, ans);

		for (int i = 0; i < size1 + size2; i++)
		{
			cout << ans[i] << " ";
		}

		cout << endl;
		delete[] arr1;
		delete[] arr2;
		delete[] ans;
	}
}
