[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/hqkbRWkD)
# FinalCS1 - Card Engine

This is a submission repository for my final project.
The Card Engine (better name pending) is a development tool for a card game that I am working on. Currently, the only available feature is outputing a test card image with several fields filled in. Planned features are:

* Exporting to json format for TableTopSimulator
* Saving card data to json for internal use
* Importing card data from spreadsheets
* Creating Decks
* Adding Art to cards
* Outputting cards to a unique directory

## For Users:

This application is really only intended to be used by me, however it is very possible for other people to use it just fine due to the relative simplicity of the interface. The program itself will walk you through the process of creating a card all the way to exporting an image file.

### Installation

To install, first download the latest release. After downloading, run the following command into the command prompt (terminal) while in the same directory as CardEngine.jar:

`java -jar CardEngine.jar`

Installation Tips:
* I recommend putting CardEngine.jar into its own folder, as the output files currently output to the same folder as it.
* (For Windows) it makes life a lot easier if you right click the folder you are in and click "Open in Terminal" to open the command prompt.

## For Not-Users:

There are two relavent files: CardEngine.java (the main one) and Card.java. Card.java contains the Card class, which is an object that represents a single card. it has several members and methods, most of which will be documented below. CardEngine.java houses the CardEngine class, which just runs the user experience.

The following is a short documentation of relavent methods:

| Method        | Description   | Class         |
|:-------------:|-------------|:-------------:|
| promptStart();| A basic and inflexible method that begins the program on the user's end, prompting them with two options: create a card or create a deck. Currently, only creating a card is available. | public class CardEngine|
| promptCardCreation();     | A bulky and inflexible method that makes the majority of the user experience. Specifically, it handles the creation of a card. | public class CardEngine     |
| isInteger(String str); | A method that determines if a String is am intger. The code was not written by me, but instead provided by corsiKa (https://stackoverflow.com/users/330057/corsika) on StackOverflow (https://stackoverflow.com/questions/5439529/determine-if-a-string-is-an-integer-in-java) | public class CardEngine |
| [Not a method] members | The Card class has  | public class Card has 12 members, but only 11 are used in the code and only 8 are displayed on output cards currently. Most of these members are used to represent an attribute of a card. |
| [Not a method] private String[] identity = new String[2]; | A String array member representing the name and type of the card (in that order). | public class Card |
| [Not a method] private String[] stats = new String[2]; | A String array member representing the attack, max hp, and blood cost of a card (in that order). | public class Card |
| outputCardImage(); | A method that creates a new image of a card. The output image will share the name of the card. | public class Card |
| correctText(); | A primitive text wrap method. Used for the card's ability text in outputCardImage(); | public class Card |
| padString(); | A primitive text padding method. Used for the card's name and type in outputCardImage(); | public class Card |
| getCardBackgroundImage(); | A method that returns a BufferedImage that is the card template. Used in outputCardImage();  | public class Card |
| getter methods | The Card class provides several getter methods for its private members. Some getter methods provide a copy of the member's value rather than the value itself. | public class Card |
| setter methods | The Card class provides several setter methods for its private members.  | public class Card |
| Font setter methods | A set of 4 methods used in outputCardImage(); to change the size of the text written at each step. | public class Card |

It should be noted that Card includes no static methods, so any methods must be called on an instance of the Card class.

## Extra Notes

This project is grossly incomplete, but it is in a state of being useful. Many thanks to the following people and resources used during the making of this project:
* https://www.dafont.com/basis33.font
* User Zach Scrivena(https://stackoverflow.com/users/20029/zach-scrivena) on this thread: https://stackoverflow.com/questions/500891/generating-an-image-with-data-fields-using-java
* User corsiKa (https://stackoverflow.com/users/330057/corsika) on this thread: https://stackoverflow.com/questions/5439529/determine-if-a-string-is-an-integer-in-java
* Modified Ascii art from patorjk.com/software/taag/
* Several pages from the Java Oracle documentation

About the card game itself; it is heavily inspired by the steam game Inscyption; and came about from the idea of "Hey what if this cool game was in paper?" That being said, it is not a complete rip off, as I've developed it slowly into something I can call my own, with my own art and mechanics. I have been working on this for around 3.5 years now without a playable version to display. However, I am constantly updating the game and its mechanics to find a sweetspot. If you want me to talk about it more (or to see more) contact me in Discord (@CABABO2000)
