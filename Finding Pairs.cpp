/*Given an array A of N numbers, find the number of distinct pairs (i, j) such that j >=i and A[i] = A[j].
First line of the input contains number of test cases T. Each test case has two lines, first line is the number N, followed by a line consisting of N integers which are the elements of array A.
For each test case print the number of distinct pairs.

Constraints
1 <= T <= 10
1 <= N <= 10^6 
-10^6 <= A[i] <= 10^6 for 0 <= i < N
*/


// C++ Program for Finding  Pairs

#include <bits/stdc++.h>
using namespace std;

int main()
{
   
    int t;     //No. of test cases
    cin>>t;
    while (t--)
    {
        int n;    //No. of elements
        cin>>n;
        
        vector<int> vec(n);
        for (int i = 0; i < n; i++)
        {
            cin>>vec[i];
            
        }
        sort(vec.begin(), vec.end());  //sorting elements in vector

        long long int count = 0;
        int i = 0, j = 0;
        while (i < vec.size() && j < vec.size())
        {
            if (vec[j] == vec[i])
                count += (j - i);
            else
                i = j;

            j++;
        }

        cout<<count + vec.size()<<"\n";  // adding vec.size() for self pair
    }
    return (0);
}
