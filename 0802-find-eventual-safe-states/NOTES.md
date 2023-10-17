My thought process
​
* We can use kahns algo
* Terminal nodes are safe. So node connected to terminal nodes are safe.
* Add the terminal nodes to queue for bfs
* To efficiently find the nodes connected to terminal nodes
* Prepare an adj list by reversing the edges
* this way we can easily locate nodes connected to terminal nodes
* and decrement the count.