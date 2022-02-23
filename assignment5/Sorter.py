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
    def explain(self):
        pass
    
class BubbleSort(Sorter):
    # from : https://realpython.com/sorting-algorithms-python/#the-quicksort-algorithm-in-python
    def sort(self):
        tic = time.perf_counter()
        n = len(self.array)
        for i in range(n):
            # flag that will allow the function to term if nothing left to sort
            already_sorted = True

            # look at each item of the list & compare with  adjacent value.
            for j in range(n - i - 1):
                if self.array[j] > self.array[j + 1]:
                    # If the item you're looking at is >  adjacent value, then swap 
                    self.array[j], self.array[j + 1] = self.array[j + 1], self.array[j]

                    # Since you had to swap two elements, set the `already_sorted` flag to `False`  --> algorithm not finish early
                    already_sorted = False

            #  no swaps during the last iteration ? array is already sorted --> terminate
            if already_sorted:
                break

        toc = time.perf_counter() 
        print("Timing:       This sort took {} seconds".format(toc - tic))
        print("Sorted List:  {}".format(self.array))

    def explain(self):
        print("Explain:")
        print("              Bubble Sort's main advantage is its simplicity.")
        print("              The disadvantage is that it is slow with a runtime complexity of O(n2)")

class InsertionSort(Sorter):
    # from : https://realpython.com/sorting-algorithms-python/#the-quicksort-algorithm-in-python
    def sort(self):
        tic = time.perf_counter()
        # Loop: 2nd  element of the array --> last element
        for i in range(1, len(self.array)):
            key_item = self.array[i] #element we want to position in correct place

            # Init var that will be used to find correct pos of the element ref by `key_item`
            j = i - 1

        # Run through the list of items & find the correct pos of the element referenced by `key_item`. 
        # IFF `key_item`  <  its adjacent values.
            while j >= 0 and self.array[j] > key_item:
                # Shift the value one position to the left & repos j to point to next element 
                self.array[j + 1] = self.array[j]
                j -= 1

            # pos `key_item` in its correct location
            self.array[j + 1] = key_item

        toc = time.perf_counter() 
        print("Timing:       This sort took {} seconds".format(toc - tic))
        print("Sorted List:  {}".format(self.array))

    def explain(self):
        print("Explain:")
        print("              Insertion Sort is much more efficient than other quadratic implementations such as bubble sort.")
        print("              Recursive functions such as quick sort or merge sort fail to beat insertion on small lists.")
        print("              Insertion sort is used internally in some quicksort and timsort algorithms")