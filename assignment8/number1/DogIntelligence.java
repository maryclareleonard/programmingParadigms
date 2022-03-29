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
        this.reps_lower = -1;
        this.reps_upper = -1; 
    }

    //constructor
    public DogIntelligence(String line){
        String [] lineSplit = line.split(",",6);
        this.breed = lineSplit[0];
        this.category = lineSplit[1]; 
        this.comment = lineSplit[2];
        this.obey = Double.parseDouble(lineSplit[3]);
        this.reps_lower = Integer.parseInt(lineSplit[4]);
        this.reps_upper = Integer.parseInt(lineSplit[5]); 
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

}