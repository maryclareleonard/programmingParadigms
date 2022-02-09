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
class Counter {
    constructor(categories) {
        this.categories = categories;
        this.categoryList = [];
    }

    categoryCounter() {
        this.categories.forEach(element => {
		  	//create list of one instance of each category
            if (!(this.categoryList.includes(element))) {
                this.categoryList.push(element)
            }
            
        });
        let numOfDistinctCategories = this.categoryList.length;
        let counts = new Array(numOfDistinctCategories).fill(0);
		//then go through each element in list of categories and incremenet at index matching the
		//index of the category in the categoryList (the list just created with one instance
		//of each category)
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
}

let file = "assignment4.txt";
let i = 0;
let breed, category, comment, obey, repsLower, repsUpper;
let dogs = [];
let convert= {};

function createDogs(dogList) {
   	dogs = []
	for (let i = 0; i < dogList.length; i++) {
	  breed = dogList[i][0];
	  category = dogList[i][1];
	  comment = dogList[i][2];
	  obey = dogList[i][3];
	  repsLower = dogList[i][4];
	  repsUpper = dogList[i][5];
	  dogElement = new Dog(breed, category, comment, obey, repsLower, repsUpper);
      dogs[i] = dogElement;
	}
	return dogs;
}

//how many terriers have an obey factor greater than or equal to 0.7
convert.question3A = function(dogList) {
  	dogs = createDogs(dogList);
    let terrier = "terrier".valueOf();
    let answer = dogs.filter(dogs => (dogs.getCategory().valueOf() === terrier) && (dogs.getObey() >= 0.7) );
	let numberOfTerriers = answer.length;
    console.log(numberOfTerriers + " " + terrier + "s have an obey factor greater than or equal to 10")
    console.log();
    return numberOfTerriers; //number of terriers
}

//lists all the dog breeds for whom the avg range btw lower and upper responses is > 10
convert.question3B = function(dogList) {
  	dogs = createDogs(dogList);
    let dogMapping = dogs.map(dogs=>({ breed: dogs.getBreed(), lower: dogs.getRepsLower(), upper: dogs.getRepsUpper()}))
    let rangeCheck = dogMapping.filter(dogMapping => (dogMapping.upper-dogMapping.lower > 10) )
    let breeds = rangeCheck.map(rangeCheck => rangeCheck.breed);

    console.log("The following dogs have response ranges greater than 10:")
    console.log(breeds);
    console.log();

	return breeds;
}

//count dogs in each category
//closure method
convert.question4Method1 = function(dogList) {
  	dogs = createDogs(dogList);
    let dogCats = dogs.map(dog=>dog.category).reduce(
        function(acc,curr) {
            return acc[curr] ? ++acc[curr] : acc[curr] = 1, acc
        },{} 
    );
	return dogCats
}

//count dogs in each category
//use class method to answer same question as above
convert.question4Method2 = function(dogList) {
 	dogs = createDogs(dogList);
    let dogCats = dogs.map(dog=>dog.category);
    catsClass = new Counter(dogCats);
   	let result = catsClass.categoryCounter();
	return result;
}

module.exports = convert;

