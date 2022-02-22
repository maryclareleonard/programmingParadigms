from abc import ABC, abstractmethod
class Filterer(ABC):
    def __init__(self):
        super().__init__()

    @abstractmethod
    def filter(self, array, num):
        pass

class Minimum(Filterer):
    # from : https://realpython.com/sorting-algorithms-python/#the-quicksort-algorithm-in-python
    def filter(self,array,num):
        print("in min")
        list = []
        for i in array:
            if i > num:
                list.append(i)
        return list

class Maximum(Filterer):
    # from : https://realpython.com/sorting-algorithms-python/#the-quicksort-algorithm-in-python
    def filter(self,array,num):
        print("in max")
        list = []
        for i in array:
            if i < num:
                list.append(i)
        return list
