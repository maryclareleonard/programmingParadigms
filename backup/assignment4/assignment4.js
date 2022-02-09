mocha.setup("bdd");
chai.should();

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
        //console.log(this.categories);
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
        console.log(result);
        //return [category, current+1];
    }
}

let dogs = [];
let file = "assignment4.txt";
let i = 0;

//how many terriers have an obey factor greater than or equal to 0.7
function question3A(dogs) {
    //let answer = dogs.filter( dogs => dogs.getObey() >= 0.7);
    let terrier = "terrier".valueOf();
    let answer = dogs.filter(dogs => (dogs.getCategory().valueOf() === terrier) && (dogs.getObey() >= 0.7) );
    console.log(answer.length + " " + terrier + "s have an obey factor greater than or equal to 10")
    console.log()
    return answer.length; //number of terriers
}

//lists all the dog breeds for whom the avg range btw lower and upper responses is > 10
function question3B(dogs) {
    let dogMapping = dogs.map(dogs=>({ breed: dogs.getBreed(), lower: dogs.getRepsLower(), upper: dogs.getRepsUpper()}))
    let rangeCheck = dogMapping.filter(dogMapping => (dogMapping.upper-dogMapping.lower > 10) )
    let breeds = rangeCheck.map(rangeCheck => rangeCheck.breed);

    console.log("The following dogs have response ranges greater than 10:")
    console.log(`${breeds}, `);
    console.log();
}

function question4Method1(dogs) {
    let dogCats = dogs.map(dog=>dog.category).reduce(
        function(acc,curr) {
            return acc[curr] ? ++acc[curr] : acc[curr] = 1, acc
        },{} 
    );
    console.log(dogCats);

}

function question4Method2(dogs) {
    let dogCats = dogs.map(dog=>dog.category);
    catsClass = new Counter(dogCats);
    catsClass.categoryCounter();
}

function fileRead(file) {
    let line = [];
    const lineReader = require('line-reader');
    lineReader.eachLine(file,(line,last)=> {
        lineArray = line.split(",");
        let breed = lineArray[0];
        let category = lineArray[1].replace('"','').replace('"',''); 
        let comment = lineArray[2].replace('"','');
        let obey = lineArray[3].replace('"','');
        let repsLower = lineArray[4].replace('"',''); 
        let repsUpper = lineArray[5].replace('"','');
        dogElement = new Dog(breed, category, comment, obey, repsLower, repsUpper);
        dogs[i] = dogElement;
        i++;
        if (last) {
            //call functions to answer questions
            question3A(dogs);
            question3B(dogs);
            question4Method1(dogs);
            question4Method2(dogs);
        }
    })
}

fileRead(file);


describe('Dog Tests', function() {
    it('Number of terriers with obey factor >= 10: ', function(){
        i = question3A(dogs);
        i.should.equal(4);
    });
});

