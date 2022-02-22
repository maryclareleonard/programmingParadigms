from abc import ABC, abstractmethod
from statistics import median, mode

class Averager(ABC):
    def __init__(self):
        super().__init__()

    @abstractmethod
    def average(self):
        pass
class Mean(Averager):
    # from : https://realpython.com/sorting-algorithms-python/#the-quicksort-algorithm-in-python
    def average(self,array):
        print("in mean")
        return sum(array)/len(array)
class Median(Averager):
    # from : https://realpython.com/sorting-algorithms-python/#the-quicksort-algorithm-in-python
    def average(self,array):
        print("in med")
        return median(array)

class Mode(Averager):
    # from : https://realpython.com/sorting-algorithms-python/#the-quicksort-algorithm-in-python
    def average(self,array):
        print("in mode")
        return mode(array)