# Assignment 2
## 48740276 - Shenoy Nirovro Baroi

To run compile files in src using javac and run.
Visual Studio Code can also be used to autocompile and run.

First I created WeatherReader, a singleton which goes to the url http://13.238.167.130/weather and fetches the data, splits into appropriate data types and provides it to other objects. It provides realtime information to the game to influence npcs, character and the world. I could have implemented an observer pattern but to keep things simple I'm going to be creating variables which objects requiring the values can just extract from singleton instance.

I am going to use Wind X and Y using position and value to make npcs have a direction that they will move in.

Created a baby cat which is lighter and will move with wind using MoveStrategy MoveRandomlyWithWind which uses weather windx and windy variables to select move direction.

As for streams and lamba implementation. There are many scenarios where they can be used. I changed some of the code to use lambdas and streams. Such as in Stage line 87 onwards. Almost all of the listofactor code can be replaced to streams and lambdas. It can be used to filter player out and only work with bots aswell. It can also be used with cells where certain types can be filtered and worked on for different purposes

Temperature can be used to reduce player health in hot areas or too cold areas. Bots can have different interaction and movement resprective to player and their own optimal temps and be direction using player movement towards temperature zones created from the data from the server and then be dealth with if hostile, or protected if friendly. Management is added to the game using this functionality.