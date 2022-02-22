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
    def get_time(self,array):
        pass

    @abstractmethod
    def explain(self):
        pass
    
class QuickSort(Sorter):
    # from : https://realpython.com/sorting-algorithms-python/#the-quicksort-algorithm-in-python
    def sort(self):
        # If the input array contains < two elements, return as result of function
        if len(self.array) < 2:
            return self.array

        low, same, high = [], [], []

        # Select your `pivot` element randomly
        pivot = self.array[randint(0, len(self.array) - 1)]

        for item in self.array:
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
        return self.sort(low) + same + self.sort(high)


    def get_time(self):
        tic = time.perf_counter()
        sort(self.array) 
        toc = time.perf_counter() 
        return toc - tic

    def explain(self):
        print("Quick Sort is best for long lists.")

class InsertionSort(Sorter):
    # from : https://realpython.com/sorting-algorithms-python/#the-quicksort-algorithm-in-python
    def sort(self,array):
        print("here")
        # Loop from the second element of the array until last element
        for i in range(1, len(array)):
            # This is the element we want to position in itscorrect place
            key_item = array[i]

            # Initialize the variable that will be used to
            # find the correct position of the element referenced by `key_item`
            j = i - 1

        # Run through the list of items (the left portion of the array) &
        # find the correct position of the element referenced by `key_item`. 
        # Do this only if `key_item` is smaller than its adjacent values.
        while j >= 0 and array[j] > key_item:
            # Shift the value one position to the left & repos j to point to  next element (from right to left)
            array[j + 1] = array[j]
            j -= 1

        # When you finish shifting the elements, you can pos `key_item` in its correct location
        array[j + 1] = key_item

        return array

    def get_time(self,array):
        tic = time.perf_counter()
        sort(array) 
        toc = time.perf_counter() 
        return toc - tic

    def explain(self):
        print("Inserstion Sort is best for short lists.")