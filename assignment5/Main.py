from abc import ABC, abstractmethod
from ast import Module
from Sorter import *
from Filterer import *
from Averager import *

from random import shuffle, random

class DataSet(ABC):
    def __init__(self,array,Sorter,Filterer,Averager):
        super().__init__()
        self.array = array
        self.sorter = Sorter
        self.filterer = Filterer
        self.averager = Averager
    def sort(self):
        self.sorter.sort(self)
    def filter(self):
        self.filterer.filter(self,self.array,50)
    def average(self):
        self.averager.average(self,self.array)

class DataSets():
    def __init__(self):
        self.list = []
        self.list.append(DataSet(self.create_dataset(),QuickSort,Minimum,Mean))
        self.list.append(DataSet(self.create_dataset(),QuickSort,Maximum,Mean))
        self.list.append(DataSet(self.create_dataset(),InsertionSort,Minimum,Mean))
        self.list.append(DataSet(self.create_dataset(),InsertionSort,Minimum,Median))
        self.list.append(DataSet(self.create_dataset(),InsertionSort,Minimum,Mode))
    
    def print(self):
        for i in range(len(self.list)):
            print("Array {}:".format(i))
            print(self.list[i].array)
            self.list[i].sort()
            self.list[i].average()
            self.list[i].filter()
            print() 

    def create_dataset(self):
        squares = list(n * n for n in range(15))
        shuffle(squares)    
        return squares
        

sets = DataSets()
sets.print()



    