from abc import ABC, abstractmethod
from ast import Module
from Sorter import *
from Filterer import *
from Averager import *

from random import shuffle, random

#random generator
squares = list(n * n for n in range(10000))
shuffle(squares)
#print(squares)
evens = list(n * 2 for n in range(500))
#shuffle(evens)
#print(evens)
floats = list (random() for n in range(200))
#print (floats)



class DataSet(ABC):
    def __init__(self,array,Sorter,Filterer,Averager):
        super().__init__()
        self.array = array
        self.sort = Sorter
        self.filter = Filterer
        self.average = Averager
    def sort(self):
        self.sort(self.array)
    def filter(self):
        self.filter(self.array,1000)
    def average(self):
        self.average(self.array)

class DataSets():
    def __init__(self):
        self.list = []
        self.list.append(DataSet(self.create_dataset,QuickSort,Minimum,Mean))

    def create_dataset(self):
        array = shuffle(list(n * n for n in range(10000)))
        return array

        #list.append(DataSet(QuickSort,Minimum,Mean))
        #list.append(DataSet(QuickSort,Minimum,Mode))
        #list.append(DataSet(QuickSort,Maximum,Mean))
        #list.append(DataSet(QuickSort,Maximum,Mode))
        #list.append(DataSet(InsertionSort,Maximum,Mode))
        #list.append(DataSet(InsertionSort,Minimum,Mode))
        

sets = DataSets()
print(sets.list[0])


    