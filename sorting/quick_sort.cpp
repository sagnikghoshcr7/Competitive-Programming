#include<iostream>
using namespace std;

int partition(int input[], int start,int end)
{
    int pivot=input[start];
	int count=0;
	// finding how many values are
	// smaller than the beginning index
	for(int i=start+1;i<=end;i++)
	{
		if(input[i]<=pivot)
		{
			count++;
		}
	}
	// Thus mid value becomes
	int mid = start+count;
    int temp=input[start];
    input[start]=input[mid];
    input[mid]=temp;
	int i = start, j=end;
	while(i<=mid && j>=mid)
	{
		while(input[i]<=pivot)
		{
			// Will swap both the values
			//swap(input[i],input[j]);
			i++;
			//j--;
		}
        while(input[j]>pivot)
        {
            j--;
        }
	 	if(i<mid &&j>mid)
		{
			int temp=input[i];
            input[i]=input[j];
            input[j]=temp;
            i++;
            j--;
		}
		
	}
    return mid;
	
}
	
void quickSort1(int input[], int start,int end) 
{
	//int start=0;
	//int end = size-1;
	if(start>=end)
	{
		return;
	}
	int mid = partition(input,start,end);
	quickSort1(input,start,mid-1);
	quickSort1(input,mid+1,end);

}
void quickSort(int input[],int n)
{
    quickSort1(input,0,n-1);
}
	


int main(){
    int n;
    cin >> n;
  
    int *input = new int[n];
    
    for(int i = 0; i < n; i++) {
        cin >> input[i];
    }
    
    quickSort(input, n);
    for(int i = 0; i < n; i++) {
        cout << input[i] << " ";
    }
    
    delete [] input;

}


