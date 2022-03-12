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
            
    @abstractmethod
    def getColor(self):
        pass

    @abstractmethod
    def getSpeed(self):
        pass

    @abstractmethod
    def getFood(self):
        pass

    def getLength(self):
        return self.length

    def getPositions(self):
        return self.positions

    def getIsBent(self):
        return self.isBent

    def setIsBent(self, setVar):
        self.isBent = setVar

    def setStartingPosition(self,width,height):
        self.head_x = randint(0, width)
        self.head_y = randint(0, height)

    def setFood(self,width,height):
        self.foodX = randint(0, width)
        self.foodY = randint(0, height) 

    def getFoodX(self):
        return self.foodX

    def getFoodY(self): 
        return self.foodY
        
    def getX(self):
        return self.head_x
    
    def getY(self):
        return self.head_y

    def setPositions(self, xdelta, ydelta):
        for i in range(self.length):
            if i == 0:
                self.positions[0] = [self.head_x,self.head_y]
                #print(self.positions)
            else: 
                self.positions[i] = [self.head_x + i*xdelta, self.head_y + i*ydelta]
        #print(self.positions)
		
    def checkSteps(self):
        if self.steps == 20:
            print("CHANGE STATE")
        if self.steps == 40:
            print("CHANGE STATE")
        if self.meals == 3:
            print("CHANGE STATE")
        if self.meals == 5:
           print("CHANGE STATE") 

    def move(self,changeX, changeY):
        self.head_x = self.head_x + changeX
        self.head_y = self.head_y + changeY 
        newPos = [(self.positions[0][0] + changeX), (self.positions[0][1] + changeY)]
        self.positions.insert(0,newPos)
        clearMrk = self.positions[-1]
        self.steps = self.steps + 1
        print(self.steps)
        self.checkSteps()
        del self.positions[-1]
        return clearMrk

    def moveHead(self,changeX, changeY):
        clearMrk = self.move(changeX,changeY)
        return clearMrk

    
        
    def outOfBounds(self):
       for i in range(self.length):
            x = self.positions[i][0]
            y = self.positions[i][1] 
            if ( x < 1 or x > 24):
                return 1
            elif ( y < 1 or y > 36): 
                return 1
            else:
                continue
class Snake(AnimalBehavior): 
    def getColor(self):
        return "green"
    def getSpeed(self):
        return 1
    def getFood(self):
        return "red"
    

class Caterpillar(AnimalBehavior): 
    def getColor(self):
        return "red"
    def getSpeed(self):
        return 3
    def getFood(self):
        return "green"
		
class Worm(AnimalBehavior): 
    def getColor(self):
        return "brown"
    def getSpeed(self):
        return 2
    def getFood(self):
        return "yellow"