# Assignment 2
## 48740276 - Shenoy Nirovro Baroi

To run compile files in src using javac and run.
Visual Studio Code can also be used to autocompile and run.

First I created WeatherReader, a singleton which goes to the url http://13.238.167.130/weather and fetches the data, splits into appropriate data types and provides it to other objects. It provides realtime information to the game to influence npcs, character and the world. I could have implemented an observer pattern but to keep things simple I'm going to be creating variables which objects requiring the values can just extract from singleton instance.

I am going to use Wind X and Y using position and value to make npcs have a direction that they will move in.