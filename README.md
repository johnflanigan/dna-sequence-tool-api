# dna-sequence-tool-api

### Notes
* Was unable to add uniqueness constraint due to size of data. Could explore this further.
* A race condition exists between checking for uniqueness and inserting data. Concurrent users could lead to duplicate data. 

### Resources

* https://spring.io/guides/tutorials/bookmarks/
