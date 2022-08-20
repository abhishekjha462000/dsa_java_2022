#include <iostream>
using namespace std;
class Experiment{
public:
	int *data;
	Experiment(){
		// default constructor 
		cout << "Default constructor was called..." << endl;
		data = new int[100];
	}
	Experiment(const Experiment& e){
		cout << "Copy constructor was called..." << endl;
		data = new int[100];
		for(int i = 0;i<100;i++){
			data[i] = (e.data)[i];
		}

	}
	Experiment& operator=(const Experiment& e){
		// data is already pointing to an array of 100 integers
		// no need to do data = new int[100]
		cout << "Copy assignment operator was called" << endl;
		for(int i = 0;i<100;i++){
			data[i] = e.data[i];
		}
		return *this;
	}
	Experiment(Experiment&& e) noexcept {
		// move constructor 
		cout << "Move constructor was called..." << endl;
		data = e.data;
	}
	Experiment& operator=(Experiment&& e) noexcept {
		// move assignment operator
		// first free the menory that the current object is holding
		cout << "Move assignment was called..." << endl;
		delete [] data;
		data = e.data;
		e.data = nullptr;
		return *this;
	}
	~Experiment(){
		if(data != NULL){
			// free data
			delete [] data;

		}
	}
	Experiment operator+(const Experiment& other){
		Experiment temp;
		temp.data = new int[200];
		int i = 0;
		for(;i<100;i++){
			temp.data[i] = data[i];
		}
		for(int j = 0;j<100;j++){
			temp.data[i++] = other.data[j];
		}
		return temp;
	}
};
int main(){
	#ifndef ONLINE_JUDGE
		freopen("input.txt","r",stdin);
		freopen("output.txt","w",stdout);
		freopen("error.txt","w",stderr);
	#endif
	Experiment e1; // Default constructor
	Experiment e2 = e1;
	Experiment e3{e1+e2};// why is this not working
	// cout << e3.data << endl; 

	return 0;
}
