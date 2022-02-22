from abc import ABC, abstractmethod
from random import randint
import time
class Sorter(ABC):
    def __init__(self):
        super().__init__()

    @abstractmethod
    def sort(self):
        pass

    @abstractmethod
    def get_time(self):
        pass

    @abstractmethod
    def explain(self):
        pass
    
class QuickSort(Sorter):
    # from : https://realpython.com/sorting-algorithms-python/#the-quicksort-algorithm-in-python
    def sort(self,array):
        # If the input array contains < two elements, return as result of function
        if len(array) < 2:
            return array

        low, same, high = [], [], []

        # Select your `pivot` element randomly
        pivot = array[randint(0, len(array) - 1)]

        for item in array:
            # Elements that are smaller than the `pivot` go to `low` list. 
            # Elements that are larger than `pivot` go to `high` list. 
            # Elements that are = to `pivot` go to `same` list.
            if item < pivot:
                low.append(item)
            elif item == pivot:
                same.append(item)
            elif item > pivot:
                high.append(item)

        # The final result combines sorted `low` list w/ the `same` list & sorted `high` list
        return sort(low) + same + sort(high)

    def get_time(self,array):
        tic = time.perf_counter()
        sort(array) 
        toc = time.perf_counter() 
        return toc - tic

    def explain(self):
        print("Quick Sort is best for long lists.")

class InsertionSort(Sorter):
    # from : https://realpython.com/sorting-algorithms-python/#the-quicksort-algorithm-in-python
    def sort(self,array):
        print("here")

    def get_time(self,array):
        tic = time.perf_counter()
        sort(array) 
        toc = time.perf_counter() 
        return toc - tic

    def explain(self):
        print("Inserstion Sort is best for short lists.")