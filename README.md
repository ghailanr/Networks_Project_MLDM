### Network Project Master MLDM 1A 2021

GHAILANE Benjamin

**Part I - Project**

The project consists of implementing a peer-to-peer structure to share files in a similar fashion to what BitTorrent
does. In its current state the project has some base level mechanics implemented but is far from being done. 

On the network part, it contains a basic functioning Repository that keep tracks of the Readers that connect to it. It
can accept multiple Readers at once and send a list of all the Readers' IP to a Reader asking for it. The list itself is 
updated regularly. The scope of action is limited to the localhost.

On the data management part, nothing testable has been done yet. The models are still at their beginning and the protocols
to exchange datas haven't been done as of now.

I've seen multiple example of source code to understand what everything does. However I actually never used it directly and
wrote everything by myself.

**Part II - How to build**

To launch and experiment, you need to first run the Repository and then run the Reader. To simulate multiple Readers, 
launch it multiple times in a different terminal. 
The Readers listen to what is being written in their terminal. Typing "list" will ask the Repository for its list of 
Readers currently connected, wherteas "quit" will disconnect and stop the Reader.

**Part III - Architecture description**

The Repository upon obtaining its ServerSocket launches a new thread that will listen for new connections 
(RepositoryAcceptConnection). Once the thread is running, the Repository will focus on keeping its list of Readers up to 
date. 
The RepositoryAcceptConnection thread, upon accepting a connection, will start a new thread ReaderHandler that will handle 
all the communications between the Reader and the Repository (sending the list of Readers or shutting down when the Reader leaves).

The Reader will, after acquiring a Socket, launch a thread ReaderConnection that will handle all its communications with 
the Repository (using the ReaderHandler thread that was assigned to it). The Reader main task is to listen to the user's input.
