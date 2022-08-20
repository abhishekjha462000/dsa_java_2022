#include <iostream>
#include <unordered_map>
using namespace std;

ostream& operator<<(ostream& os,const pair<int,string>& p)
{
	os << "{" << p.first << ", " << p.second << "}" << endl; 
	return os;
}
ostream& operator<<(ostream& os,const unordered_map<int,string>& m)
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

	/**
	 * It does not stores the key in sorted order
	 * Also, does not preserve the insertion order
	 * They use hash-tables 
	 * Use unordered_map when you do not want the keys to be stored in sorted order
	 * i.e. In case when order is not important(only frequency matters)
	 * All the operations are in O(1)
	 * cannot use complex keys as their hash codes are not defined in the 
	 * standard library. Either you will have to define them sepearately or you can use "std::boost" library
	 * Valid keys are -- int, char,float,double,bool,string etc...
	 **/
	unordered_map<int, string> m;

	m.insert({1,"Abhishek"});
	m[90] = "sameer";
	m.insert(make_pair(2,"Bhoomika"));
	m.emplace(3,"Jacob lurie");// creates objects in place 

	cout << m << endl;
  	cout << m[90] << endl;
  
  	m[100]; // this is a valid statement, It will create a key value pair as {100, }
  
  	cout << m << endl;
	cout << m.size() << endl;

	if(m.empty())
	{
		cout << "unordered map is empty..." << endl;
	}else{
		cout << "unordered map is not empty..." << endl;
	}

	
	/**
	 * For erasing an object we can use erase method, The erase method
	 * can either take an iterator or a key 
	 * 
	 * Better to pass in a key as when passing an iterator you do not know which key it is pointing to
	 **/

	m.erase(m.begin()); // do not use this as use do not know which element it points to
	cout << m << endl;

	// Instead use this
	m.erase(2); // Just pass the key

	cout << m << endl;

	/**
	 * Finding a key in unordered_map
	 * 
	 * For this we use `find` method which takes in a key and searches for it in the u_map
	 * 
	 * The function returns an iterator, if the key is found then we get a valid iterator 
	 * otherwise we get the end iterator of the 
	 * u_map
	 **/

	auto it = m.find(1);

	if(it == m.end())
		cout << "Key not found..." << endl;
	else{
		cout << (*it) << endl;
	}


	
	/**
	 * For emptying the u_map we can use clear() method
	 **/

	m.clear();

	if(m.empty())
		cout << "unordered map is now empty..." << endl;
	else{
		cout << "Not empty yet..." << endl;
	}
	return 0;
}
