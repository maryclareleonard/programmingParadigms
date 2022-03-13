# Animal behavior hierarchies 
from abc import ABC, abstractmethod
from random import randint  
class AnimalBehavior(ABC): 
    def __init__(self):
        super().__init__()
        self.head_x = 0
        self.head_y = 0
        self.length = 3     #added to track length of the snake 
        self.positions = [ [0] * 2]* 3  # 2 x 10 array with 0s
        self.steps = 0
        self.meals = 0
        self.foodX = 0
        self.foodY = 0
        self.eatenTotal = 0

        self.content = Content(self)
        self.hungry = Hungry(self)
        self.engorged = Engorged(self)

        self.state = self.content
        

    #strategy materials
    @abstractmethod
    def getColor(self):
        pass

    @abstractmethod
    def getSpeed(self):
        pass

    @abstractmethod
    def getFood(self):
        pass

    def setState(self,newState):
        self.state = newState

    def getContentState(self):
        if self.state == self.content:
            return 1
        else:
            return 0

    def getHungryState(self):
        if self.state == self.hungry:
            return 1
        else:
            return 0

    def getEngorgedState(self):
        if self.state == self.engorged:
            return 1
        else:
            return 0

    def printStatus(self):
        self.state.printStatus()

    def getLength(self):
        return self.length

    def getPositions(self):
        return self.positions

    def setStartingPosition(self,width,height):
        # - 4 to avoid snake being out of grid bounds to start
        self.head_x = randint(3, width-3)
        self.head_y = randint(3, height-3)

    def setFood(self,width,height):
        # - 2 to avoid food being out of grid bounds
        self.foodX = randint(2, width-2)
        self.foodY = randint(2, height-2) 

    def getFoodX(self):
        return self.foodX

    def getFoodY(self): 
        return self.foodY
        
    def getX(self):
        return self.head_x
    
    def getY(self):
        return self.head_y

    #set positioning for snake body
    def setPositions(self, xdelta, ydelta):
        for i in range(self.length):
            if i == 0:
                self.positions[0] = [self.head_x,self.head_y]
            else: 
                self.positions[i] = [self.head_x + i*xdelta, self.head_y + i*ydelta]
		
    # for state determination
    def checkSteps(self):
        self.printStatus()
        print("Step Count: ", self.steps)
        print("Meal Count", self.meals)
        if self.steps == 20:
            if self.getContentState():
                self.setState(self.hungry)
                self.meals = 0 #start tracking meals
            elif self.getEngorgedState():
                self.setState(self.content)
                self.steps = 0 #start tracking steps 
                self.meals = 0 #start tracking meals
        if self.meals == 3:
            if self.getContentState():
                self.setState(self.engorged)
                self.steps = 0 #start tracking steps
        if self.meals == 5:
            if self.getHungryState():
                self.setState(self.engorged)
                self.steps = 0 #start tracking steps

    #move snake around board
    def move(self,changeX, changeY):
        self.head_x = self.head_x + changeX
        self.head_y = self.head_y + changeY 
        newPos = [(self.positions[0][0] + changeX), (self.positions[0][1] + changeY)]
        self.positions.insert(0,newPos) #insert new head
        eaten = self.checkEat(newPos) #check if food was just erased (by snake)
        clearMrk = self.positions[-1] #clear marker at this location
        self.steps = self.steps + 1
        self.checkSteps() # state logic
        if eaten:
            self.length = self.length + 1
            self.meals = self.meals + 1
            self.eatenTotal = self.eatenTotal + 1 #will not be reset for state purposes
            self.steps = 0 #reset steps since just eaten
            #don't delete so snake extends
        else: 
            del self.positions[-1] #if nothing eaten, delete last element
            
        return [clearMrk, eaten]

    def checkEat(self,newPos):
        if (newPos[0] == self.getFoodX()) and (newPos[1] == self.getFoodY()):
            return 1
        else:
            return 0

    def outOfBounds(self):
       for i in range(self.length-1):
            x = self.positions[i][0]
            y = self.positions[i][1] 
            if ( x < 1 or x > 24):
                return 1
            elif ( y < 1 or y > 36): 
                return 1
            else:
                continue

    def hitSelf(self):
        for i in range(self.length-1):
            x = self.positions[i][0]
            y = self.positions[i][1] 
            for j in range(i+1,self.length-1):
                a = self.positions[j][0]
                b = self.positions[j][1]  
                if x == a and y == b:
                    return 1
                else:
                    continue

class State(ABC):
    def __init__(self,animalBehavior):
        self.animalBehavior = animalBehavior
    def setState(self,newState):
        self.state = newState
    @abstractmethod
    def printStatus(self):
        pass
    
class Content(State):
    def __init__(self, animal_behavior):
        super().__init__(animal_behavior)
        
    def printStatus(self):
        print("Happy as a clam!!")

class Engorged(State):
    def printStatus(self):
        print("GOSH I'm stuffed.")

class Hungry(State):      
    def printStatus(self):
        print("I NEED Food!!")      

class Snake(AnimalBehavior): 
    def getColor(self):
        return "black"
    def getSpeed(self):
        return 750
    def getFood(self):
        return "red"

    
class Caterpillar(AnimalBehavior): 
    def getColor(self):
        return "green"
    def getSpeed(self):
        return 1000
    def getFood(self):
        return "brown"

		
class Worm(AnimalBehavior): 
    def getColor(self):
        return "brown"
    def getSpeed(self):
        return 1250
    def getFood(self):
        return "yellow"



