let convert = require('./assignment4.js');
var assert = require('assert');

let dogList = [
	["Affenpinscher", "toy", "Above Average Working Dogs", "0.7", "16", "25"],
	["Airedale Terrier", "terrier", "Above Average Working Dogs", "0.7", "16", "25"],
	["Akita", "working", "Average Working/Obedience Intelligence", "0.5", "26", "40"],
	["Alaskan Malamute", "working", "Average Working/Obedience Intelligence", "0.5", "26", "40"],
	["American Foxhound", "hound", "Average Working/Obedience Intelligence", "0.5", "26", "40"],
	["American Staffordshire Terrier", "terrier", "Above Average Working Dogs", "0.7", "16", "25"],
	["American Water Spaniel", "sporting", "Average Working/Obedience Intelligence", "0.5", "26", "40"],
	["Australian Cattle Dog", "herding", "Brightest Dogs", "0.95", "1", "4"],
	["Australian Shepherd", "herding", "Average Working/Obedience Intelligence", "0.5", "26", "40"],
	["Australian Terrier", "terrier", "Above Average Working Dogs", "0.7", "16", "25"],
	["Bearded Collie", "herding", "Above Average Working Dogs", "0.7", "16", "25"],
	["Bedlington Terrier", "terrier", "Average Working/Obedience Intelligence", "0.5", "26", "40"],
	["Belgian Malinois", "herding", "Excellent Working Dogs", "0.85", "5", "15"],
	["Belgian Sheepdog", "herding", "Excellent Working Dogs", "0.85", "5", "15"],
	["Bernese Mountain Dog", "working", "Excellent Working Dogs", "0.85", "5", "15"],
	["Bichon Frise", "nonSporting", "Average Working/Obedience Intelligence", "0.5", "26", "40"],
	["Black and Tan Coonhound", "hound", "Average Working/Obedience Intelligence", "0.5", "26", "40"],
	["Border Collie", "herding", "Brightest Dogs", "0.95", "1", "4"],
	["Border Terrier", "terrier", "Above Average Working Dogs", "0.7", "16", "25"],
	["Boston Terrier", "nonSporting", "Average Working/Obedience Intelligence", "0.5", "26", "40"]
]

describe('Dog Tests', function() {
    it('Number of terriers with obey factor >= 10 is 4', function(){
        assert.equal(4,convert.question3A(dogList))
    });
	it ('Breeds with range between lower and upper > 10:', function(){
		let list = ['Akita','Alaskan Malamute','American Foxhound','American Water Spaniel','Australian Shepherd','Bedlington Terrier','Bichon Frise','Black and Tan Coonhound','Boston Terrier'];	
		assert.equal(list,convert.question3B(dogList));
	});
	it ('Category count using closure:', function() {
	  	let array = {
		    herding: 6,
		    hound: 2,
			nonSporting: 2,
			sporting: 1,
			terrier: 5,
			toy: 1,
			working: 3
		}
	  	assert.equal(array,convert.question4Method1(dogList));
	});
	it ('Category count using a class:', function() {
  		let array = [['toy',1],['terrier',5],['working',3],['hound',2],['sporting',1],['herding',6],['nonSporting',2]]
	  	assert.equal(array,convert.question4Method2(dogList));
	})
});


