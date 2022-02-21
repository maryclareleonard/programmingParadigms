from abc import ABC, abstractmethod
from Sorter import *
from Filter import *
from Averager import *

from random import shuffle, random

#random generator
squares = list(n * n for n in range(10000))
shuffle(squares)
# Test: print(squares)
evens = list(n * 2 for n in range(500))
shuffle(evens)
# Test: print(evens)
floats = list (random() for n in range(200))
# Test: print (floats)

class Sorter(ABC):
    def _init_(self):
        super()._init_()

class Filterer(ABC):
    def _init_(self):
        super()._init_()

class Averager(ABC):
    def _init_(self):
        super()._init_()

class DataSet(ABC):
    def _init_(self,Sorter,Filterer,Averager):
        super()._init()
        self.sort = Sorter
        self.filter = Filterer
        self.average = Averager
    @abstractmethod
    def sort(self):
        self.sort.sort()
    def filter(self):
        self.filter.filter()
    def average(self):
        self.average.average()

    