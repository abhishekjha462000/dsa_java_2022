#include <iostream>
#include <map>
using namespace std;

ostream& operator<<(ostream& os,const pair<int,string>& p)
{
	os << "{" << p.first << ", " << p.second << "}" << endl; 
	return os;
}
ostream& operator<<(ostream& os,const map<int,string>& m)
{
	for(const auto& x : m)
	{
		os << x;
	}
	return os;
}
int main()
{
	#ifndef ONLINE_JUDGE
			freopen("input.txt","r",stdin);
			freopen("output.txt","w",stdout);
			freopen("error.txt","w",stderr);
	#endif
  	// map uses "AVL trees"(self balancing trees)
	map<int,string> m;
	m[0] = "Abhishek";
	m[-89] = "Bhoomika";

	m.insert({1,"sameer"});

	// cout << m << endl;

	m.insert({1,"Alpha"});

	// cout << m << endl;

	m[1] = "Alpha";

	// cout << m << endl;

	m.insert(make_pair(4,"jacob"));
	m.emplace(5,"priyanka"); // makes the object in-place and does not invoke the
	// copy constructor of the pair class.

	// cout << m << endl;


	// map<int,string>::iterator it = m.begin();

	// cout << "using iterators..." << endl;
	// while(it != m.end())
	// {
	// 	cout << *it;
	// 	++it;
	// }

	// Time for inserting is O(log n) and access krne ki bhi time complexity O(log n)
	m[90]; // elements has been accessed this takes O(log n) time even if I have done just nothing
	// An empty string would be inserted in the place of m[90];


	// Map stores the unique key value pairs in the sorted order of key
	cout << m << endl;


	// Finding a key in map

	auto it = m.find(-89); // m.find(key) takes the key and not the value;

	// this find operation is also O(log n) time complexity operation 
	if(it == m.end())
	{
		cout << "NO VALUE" << endl;
	}else{
		cout << *it << endl;
	}

	// Keys  are read only 
	// auto itr = m.begin();

	// while(itr != m.end())
	// {
	// 	(*itr).first += 1;
	// 	++itr;
	// }

	cout << m << endl;

	cout << m.size() << endl;
	cout << m.empty() << endl;
	// m.clear();
	// cout << m.size() << endl;



	m.erase(5); // erases the element with key as 5

	cout << m << endl;

	m.erase(++m.begin()); // erases the element after the first element

	cout << m << endl;

	map<int,string> m2 = std::move(m);


	cout << m2 << endl;
	cout << "see m now" << endl;

	cout << m << endl;
	return 0;
}
