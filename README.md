# DataStructsProject3
Use a circular array, as described in paragraphs 8.10 – 8.16, to implement a queue, based on an array with one unused location and no counter.
Test all methods before you proceed to use your class in  the application.

Write a program to simulate a Train route.
A train route consists of a number of Stations, starting and ending with a terminal station. The time that a train needs to travel between a pair of two consecutive stations on the route is given.
Each station has a Queue of Passengers (use the Queue class that you developed in Problem 1)
Passengers are generated at random times, assigned to entry stations randomly, and have random destination stations.
Alternatively, you may assume that every 10 minutes (or any other appropriate interval) a random amount of passengers (different for different station) arrive at each station and join the queue.
Trains leave a terminal at regular intervals and stop at all of the stations on the route.
When a train stops at a station, all passengers for that station are removed from the train and then all the passengers waiting in the queue at the station board the train until either the queue is empty or the train is full.
The simulation continues for the user-specified amount of time.
