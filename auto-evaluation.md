
**What works and what doesn't ?**


Well putting the whole data management side, the Repository fills its purpose keeping track of connected Readers and sending 
that list to the Readers that ask for it. 


The Readers can ask the repository for the list of the other currently connected Readers' IP but do not handle yet interactions
between one another.

**Results compared to objectives**
Considering the context in which I put myself into, I knew that I wouldn't have the time to finish it. However I believed that I could at least 
achieve the networking part of the project (i.e : having a repository handling multiple readers and readers being able to interact with one another).
On that, I consider the repository to be working as intended. On the other hand, the readers aren't able to initiate a connection to one another.


**Time investment**

I did not really keep track of the time I worked on this project. An honest fork would be between 30h and 40h. A third of 
it was spent looking at documentations and methodology (both from the classes and online). 




**Good Development Practices**

1 - About documents : the markdown files are ok. 

2 - About git : 
* No generated files and no zip files
* Commit/pushes made when an issue has been solved
* Very descriptive commit messages
* English for all commit messages
* No pair programming

3 - About the code :
* Code is in english 100%
* Code is indented and formatted properly
* No mix between spaces and tabs
* Use of the Java convention

4 - About software :
* Very few testing
* No automated tests
* No stress tests
* No tests for bad behavior
* No documentation

