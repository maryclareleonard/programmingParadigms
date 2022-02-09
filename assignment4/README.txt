Dependencies:
    line-reader 
        npm install line-reader --save or yarn add line-reader

Run: mocha Test.js 

NOTE: THE LAST THREE TESTS FAIL BUT THE TEXT IS THE SAME.
I tried to debug and I assume this might be a spacing issue?

Part 3:
1. const
	Constants are block scoped like variables declared using the let keyword. 
	The value of consts cannot be changed through reassignment and cannot be redeclared. 
	However if it is an object or array its properties or items can be updated or removed.
2. html
	Javascript makes web pages interactive and dynamic. 
	It interacts with HTML the standard markup language that serves as the backbone of the website. 
	For example the canvas was declared within the HTML structure and we used Javascript to create the Irish Pong board and actions. 
3. Class/Classes
	In Javascript the user can create classes to create custom objects. 
	The constructor defines an object based on passed parameters. 
	The attributes of the new class object can be accessed through getters and setters and methods that are defined within the class by the programmer.
	Code:
	class Dog {
    	constructor(breed, category, comment, obey, reps_lower, reps_upper) {
      	  this.breed = breed;
      	  this.category = category;
      	  this.comment = comment;
        
      	  this.obey = parseFloat(obey);
      	  this.reps_lower = parseFloat(reps_lower);
      	  this.reps_upper = parseFloat(reps_upper);
   	 	}
   	 	getBreed ()     { return this.breed; }
    	getCategory()   { return this.category; }
    	getComment()    { return this.comment; }
    	getObey()       { return this.obey; }
    	getRepsLower()  { return this.reps_lower; }
    	getRepsUpper()  { return this.reps_upper; }
	}
4. Weakly Typed
	Javascript is weakly typed. 
	Types for variables are assigned implicityly. 
	Functions are weakly typed and can return any type.

5. Dynamic
	Javascript is a dynamically typed programming language. 
	Type checking is done at run time as opposed to at compile time.
6. Object Oriented
	Javascript is an object oriented language as it does not have defined classes.
	It defines behaviors using constructor functions and then reuses the class the programmer sets to create objects.

7. First Class Functions
	Javascript allows for first class functions.
	First class functions take functinons as arguments or return functions.
8. Declarative 
	Javascript allows for declarative programming where you say what it is you would like done.
	Code:
	let answer = dogs.filter(dogs => (dogs.getCategory().valueOf() === terrier) && (dogs.getObey() >= 0.7) );
9. Imperative
	Javascript alows for imperative coding where you explicitly call out exactly what it is you would like done.

	Note - this is done with a closure function described in number 10
	Code:
	categoryCounter() {
        this.categories.forEach(element => {
            if (!(this.categoryList.includes(element))) {
                this.categoryList.push(element)
            }
            
        });
        let numOfDistinctCategories = this.categoryList.length;
        let counts = new Array(numOfDistinctCategories).fill(0);
        for (let i = 0; i < numOfDistinctCategories; i++) {
            this.categories.forEach(element => {
                if ( element == this.categoryList[i]) {
                    counts[i]++; 
                }
            });
        }
        let result = [];
        for (let j = 0; j < numOfDistinctCategories; j++) {
            result.push([this.categoryList[j], counts[j]]);
        }
		return result;
    }
10. Closure function
	Closure functions bundle functions together so that scope can be shared between the two (within the lexical environment). 
	The internal function can access the scope of the external parameters.
	Code:
    let dogCats = dogs.map(dog=>dog.category).reduce(
        function(acc,curr) {
            return acc[curr] ? ++acc[curr] : acc[curr] = 1, acc
        },{} 
    );
	
