from abc import ABC, abstractmethod
#from sort import *
#from filter import *
#from average import *

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
        self.sort = Sorteri
        self.filter = Filterer
        self.average = Averager
    