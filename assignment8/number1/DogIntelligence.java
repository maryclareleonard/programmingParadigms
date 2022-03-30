public class DogIntelligence {
    String breed;
    String category; 
    String comment;
    double obey;
    int reps_lower;
    int reps_upper;

    //no argument constructor
    public DogIntelligence() {
        this.breed = " ";
        this.category = " ";
        this.comment = " ";
        this.obey = -1;
        this.reps_lower = -2;
        this.reps_upper = -1; 
    }

    //constructor
    public DogIntelligence(String line){
        String [] lineSplit = line.split(",",6);
        this.breed = lineSplit[0];
        this.category = lineSplit[1];
        this.comment = lineSplit[2];
        this.obey = Double.valueOf((lineSplit[3]).substring(1,lineSplit[3].length() -1));
        this.reps_lower = Integer.valueOf((lineSplit[4]).substring(1,lineSplit[4].length() -1));
        this.reps_upper = Integer.valueOf((lineSplit[5]).substring(1,lineSplit[5].length() -1));
    }

    //equality
    public boolean equals(Object other) {
        if (other == this) { return true; }
        if (other == null) { return false; }
        if (getClass() != other.getClass()) { return false; }
        DogIntelligence dogIntell = (DogIntelligence)other;
            return ( 
                this.breed.equals(dogIntell.breed) &&
                this.category.equals(dogIntell.category) &&
                this.comment.equals(dogIntell.comment) &&
                this.obey == dogIntell.obey &&
                this.reps_lower == dogIntell.reps_lower &&
                this.reps_upper == dogIntell.reps_upper
            );
    }

    //string 
    public String toString() { //override to string method
        return  "Breed: " + this.breed + ", " + "Category: " + this.category + ", " + 
                "\nComment: " + this.comment + ", " + 
                "\nObey " + this.obey + ", " + "Reps: " + this.reps_lower + " to " + this.reps_upper + "\n";
    }

    //hashcode
    public int hash() {
        String myString = this.toString();
        return (int) myString.hashCode();
    }

}