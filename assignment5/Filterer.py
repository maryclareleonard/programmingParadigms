from abc import ABC, abstractmethod
class Filterer(ABC):
    def __init__(self):
        super().__init__()

    @abstractmethod
    def filter(self, array, num):
        pass

class Minimum(Filterer):
    def filter(self,array,num):
        list = []
        for i in array:
            if i > num:
                list.append(i)
        print("The numbers above the minimum of {} are {}".format(num,list))

class Maximum(Filterer):
    def filter(self,array,num):
        list = []
        for i in array:
            if i < num:
                list.append(i)
        print("The numbers below the maximum of {} are {}".format(num,list))
