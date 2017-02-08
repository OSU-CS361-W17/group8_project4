# BattleShip Program
#### By Bruce Garcia, Jashua Lioy, Chase McWhirt, Tsewei Peng

Link to [Java Code](https://github.com/OSU-CS361-W17/group8_project1/tree/master/src/main/java/edu/oregonstate/cs361/battleship)

Link to [Front-End Code](https://github.com/OSU-CS361-W17/group8_project1/tree/master/src/main/resources/public)

#### At the very bottom of this file, there is a programming guideline.

### Current Data Structure:
```json
{
    "aircraftCarrier": {
        "name": "aircraftCarrier",
        "length": 5,  
        "start": { "row": 0,"col": 0 },
        "end": {"row": 0, "col": 0}
    },
    ... 
    "computer_aircraftCarrier": {
        "name": "computer_AircraftCarrier",
        "length": 5,
        "start": { "row": 2,"col": 2 },
        "end": {"row": 2, "col": 7}
    },
    "computer_battleship": {
        "name": "computer_Battleship",
        "length": 4,
        "start": { "row": 2,"col": 8 },
        "end": {"row": 6, "col": 8}
    },
    "computer_cruiser": {
        "name": "computer_Cruiser",
        "length": 3,
        "start": { "row": 4, "col": 1 },
        "end": {"row": 4, "col": 4}
    },
    "computer_destroyer": {
        "name": "computer_Destroyer",
        "length": 2,
        "start": { "row": 7, "col": 3 },
        "end": {"row": 7, "col": 5}
    },
    "computer_submarine": {
        "name": "computer_Submarine",
        "length": 2,
        "start": { "row": 9, "col": 6 },
        "end": {"row": 9, "col": 8}
    },
    "playerHits": [{row: 5, col: 10}...],
    "playerMisses": [{row: 4, col: 10}...],
    "computerHits": [{row: 2, col: 1}...],
    "computerMisses": [row: 10, col: 5}...]
}
```
### To start battleship:
Type this in brower:
```
localhost:4567
```
### Placing ship request:
```
http://localhost:4567/placeShip/{shipname}/{row}/{col}/{horizontal | vertical}
```
an example request is:
```
http://localhost:4567/placeShip/aircraftCarrier/1/1/horizontal
```

### User fire request:
```
http://localhost:4567/fire/{row}/{col}
```
an example request is:
```
http://localhost:4567/fire/4/3
```

## Plan
## (If you have something add it)
### Expand the game
- Make condition for gameover's and also restarting a game
- Split the game into 2 phases: - placing ships | - firing
- Make the user be able to choose the number of rows and columns, and choose the amound of ships they can have. 
- Split the ships into different classes inheriting from Ship class. We might do more types of ships, etc. 
### Migrate to a newer data structure
- We need to make this type of dataStructure in order to expand the game.
- (Make this ASAP)
``` json
{
    "userShips": [
        "aircraftCarrier": {
            "name": "AircraftCarrier",
            "length": 5,  
            "start": { "row": 0,"col": 0 },
            "end": {"row": 0, "col": 0}
        },
        ...
    ],
    "computerShips": [
        "computer_aircraftCarrier": {
            "length": 5,
            "start": { "row": 2,"col": 2 },
            "end": {"row": 2, "col": 7}
        },
        ...
    ]
    "playerHits": [{row: 5, col: 10}...],
    "playerMisses": [{row: 4, col: 10}...],
    "computerHits": [{row: 2, col: 1}...],
    "computerMisses": [row: 10, col: 5}...]
}
```
### Computer AI
Make it general and abstract, to adapt to different sizes of boards)
- Make AI able to place their own ships (Hard)
- Make AI fire at user ships, while not firing out of bound (Hard)

### Error Handling
(Will have to discuss to inforce which error handling on front-end or back-end)
- When user place a ship that is out of bound, return error
- When user fire at something out of bound, (Not sure if that is even possible)

### Front-end
- Design the interface so it looks more pleasant, includes: 
    - Make a starting menu
    - Make two boards in one screen
    - Show user very distinguishable visual of what to do (fire, placing, computer fire, etc)
    - Make user click on board to place order instead of doing it through a option table.
    - Make a 404 page.
    - Make some ship graphics with svg would be cool (Hard)
    - Make the page responsive to different width
    
## Programming guideline
### Changes to the naming
- across and down becomes row and column for the sake of sanity.
- All name follow this format: e.g. userFireBattleshipModel (always start with lowercase letter)
- All classes name start with Uppercase letters.

### Planning
- Please plan before you code, if there is something you are confused about post it on slack.

### Coding
- Don't make your function exceed 30 lines, because that means you are probably doing something that can be simplified.
- Don't add a lot of functions into Main class if they can be put into a different class. For the sake of visibility.
- Make classes if code can be simpler and more readable, don't be reluctant to do so.
- For each class you must have a constructor, and accessor and mutators are not required, but please provide it if it can be used. (Based on your design)
- For some functions that can be used across all program, put it into Utility class, it can be accessed by Utility.func(whatever whatever)

### Comment
- Comments are necessary, but not too much that it decrease the readablity of codes.
- For functions that are not constructor, accessor, mutator, please briefly explain what the function does.
- In Utilty functions, please make comments on what the parameter can, and what is returned.

### In conclusion
Think about what kind of code you want to see when you are receiving it, make it that way.