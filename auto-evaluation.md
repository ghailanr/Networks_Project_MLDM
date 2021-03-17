
**What works and what doesn't ?**


Well putting the whole data management side, the Repository fills its purpose keeping track of connected Readers and sending 
that list to the Readers that ask for it. 


The Readers can ask the repository for the list of the other currently connected Readers' IP but do not handle yet interactions
between one another.


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

