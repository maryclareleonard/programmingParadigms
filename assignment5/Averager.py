from abc import ABC, abstractmethod
from statistics import median, mode

class Averager(ABC):
    def __init__(self):
        super().__init__()

    @abstractmethod
    def average(self):
        pass
class Mean(Averager):
    def average(self,array):
        print("Averager:     The mean of this array is {}".format(sum(array)/len(array)))
class Median(Averager):
    def average(self,array):
        print("Averager:     The median of this array is {}".format(median(array)))

class Mode(Averager):
    def average(self,array):
        print("Averager:     The mode of this array is {}".format(mode(array)))