# Animal behavior hierarchies 
from abc import ABC, abstractmethod
from random import randint  
class AnimalBehavior(ABC): 
    def __init__(self):
        super().__init__()
        self.head_x = 0
        self.head_y = 0
        self.length = 3     #added to track length of the snake 
        self.positions = [ [0] * 2]* 10  # 2 x 10 array with 0s
        print(self.positions)
            
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

    def setPositions(self, xdelta, ydelta):
        for i in range(self.length):
            if i == 0:
                print("here")
                self.positions[0] = [self.head_x,self.head_y]
                print(self.positions)
            else: 
                print("here2")
                self.positions[i] = [self.head_x + i*xdelta, self.head_y + i*ydelta]
        print(self.positions)

    def getPositions(self):
        return self.positions
		
    def moveHead(self,changeX, changeY):
        self.head_x = self.head_x + changeX
        self.head_y = self.head_y + changeY
        self.positions[0] = [self.head_x,self.head_y]
        #self.length = self.length + 1
        for i in range(self.length):
            if (i == 0):
                self.positions[0] = [self.head_x,self.head_y] 
            else:
                newX = self.positions[i][0] + 1
                newY = self.positions[i][1] + 1
                self.positions[i] = [newX, newY]
        #    else:
        #        temp = self.positions[i]
        #        self.positions[i] = self.positions[i+1]
        #        self.positions [i+1] = temp

        
    def setStartingPosition(self,width,height):
        self.head_x = randint(0, width)
        self.head_y = randint(0, height)

        
    def getX(self):
        return self.head_x
    
    def getY(self):
        return self.head_y

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