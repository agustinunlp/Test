Exercise to solve:

Take this paragraph of text and return an alphabetized list of ALL unique words.  A unique word is any form of a word often communicated with essentially the same meaning. For example, fish and fishes could be defined as a unique word by using their stem fish. For each unique word found in this entire paragraph, determine the how many times the word appears in total. Also, provide an analysis of what sentence index position or positions the word is found. The following words should not be included in your analysis or result set: "a", "the", "and", "of", "in", "be", "also" and "as".  Your final result MUST be displayed in a readable console output in the same format as the JSON sample object shown below.
 
Sample Output:
 
{
  "results": [
    {
      "word": "ALL",
      "total-occurances": 1,
      "sentence-indexes": [0]
    },
    {
      "word": "alphabetized",
      "total-occurances": 1,
      "sentence-indexes": [0]
    },
   {
      "word": "analysis",
      "total-occurances": 2,
      "sentence-indexes": [4], [5]
    },
   ...
  ]
}

Resolution:
Test.java is a class that has a main() method that does the hole job. I parsed a text, in paragraphs, then in sentences and then in words, 
I used an algorithm to stem the words (stemming is the process of reducing inflected (or sometimes derived) words to their word stem, base or root form—generally a written word form))
Yo can see more about the library in http://snowball.tartarus.org/
The version and dependency package was managed with maven 

		<!-- https://mvnrepository.com/artifact/com.github.rholder/snowball-stemmer -->
		<dependency>
			<groupId>com.github.rholder</groupId>
			<artifactId>snowball-stemmer</artifactId>
			<version>1.3.0.581.1</version>
		</dependency>
		
After process each word, I stored it in a map, with the occurrencies, and the sentences index of each occurrency.
After finish the words process, I sorted the alphabetically and finally parse the structure values into a Json Object(I used faster classes to generate the output with Json format)

	<!-- https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind -->
		<dependency>
			<groupId>com.fasterxml.jackson.core</groupId>
			<artifactId>jackson-databind</artifactId>
			<version>2.0.0</version>
		</dependency>
		

An example text is:

"After a century of decline, tiger numbers are on the rise. At least 3,890 tigers remain in the wild, but much more work is needed to protect this species that’s still vulnerable to extinction. Demand for tiger parts in some Asian countries is resulting in poaching and trade that will empty forests of the last wild tigers.
Three tiger subspecies—Bali, Javan, and Caspian—have already been wiped out. The South China tiger is on its way to extinction. All of the five other remaining subspecies are in danger of the same fate if we don’t act now. Together, we can save the tiger for future generations.
Your donation will help WWF to protect and connect tiger habitats on a massive scale, support and increase antipoaching efforts, and clamp down on tiger trade."

The Output is:

{
  "results": [
    {
      "word": "3890",
      "sentenceIndexes": [
        1
      ],
      "totalOccurrences": 1
    },
    {
      "word": "After",
      "sentenceIndexes": [
        0
      ],
      "totalOccurrences": 1
    },
    {
      "word": "All",
      "sentenceIndexes": [
        6
      ],
      "totalOccurrences": 1
    },
    {
      "word": "Asian",
      "sentenceIndexes": [
        2
      ],
      "totalOccurrences": 1
    },
    {
      "word": "At",
      "sentenceIndexes": [
        1
      ],
      "totalOccurrences": 1
    },
    {
      "word": "Caspianhav",
      "sentenceIndexes": [
        4
      ],
      "totalOccurrences": 1
    },
    {
      "word": "China",
      "sentenceIndexes": [
        5
      ],
      "totalOccurrences": 1
    },
    {
      "word": "Demand",
      "sentenceIndexes": [
        2
      ],
      "totalOccurrences": 1
    },
    {
      "word": "Javan",
      "sentenceIndexes": [
        4
      ],
      "totalOccurrences": 1
    },
    {
      "word": "South",
      "sentenceIndexes": [
        5
      ],
      "totalOccurrences": 1
    },
    {
      "word": "The",
      "sentenceIndexes": [
        5
      ],
      "totalOccurrences": 1
    },
    {
      "word": "Three",
      "sentenceIndexes": [
        4
      ],
      "totalOccurrences": 1
    },
    {
      "word": "Togeth",
      "sentenceIndexes": [
        7
      ],
      "totalOccurrences": 1
    },
    {
      "word": "WWF",
      "sentenceIndexes": [
        9
      ],
      "totalOccurrences": 1
    },
    {
      "word": "Your",
      "sentenceIndexes": [
        9
      ],
      "totalOccurrences": 1
    },
    {
      "word": "act",
      "sentenceIndexes": [
        6
      ],
      "totalOccurrences": 1
    },
    {
      "word": "alreadi",
      "sentenceIndexes": [
        4
      ],
      "totalOccurrences": 1
    },
    {
      "word": "antipoach",
      "sentenceIndexes": [
        9
      ],
      "totalOccurrences": 1
    },
    {
      "word": "ar",
      "sentenceIndexes": [
        0,
        6
      ],
      "totalOccurrences": 2
    },
    {
      "word": "been",
      "sentenceIndexes": [
        4
      ],
      "totalOccurrences": 1
    },
    {
      "word": "but",
      "sentenceIndexes": [
        1
      ],
      "totalOccurrences": 1
    },
    {
      "word": "can",
      "sentenceIndexes": [
        7
      ],
      "totalOccurrences": 1
    },
    {
      "word": "centuri",
      "sentenceIndexes": [
        0
      ],
      "totalOccurrences": 1
    },
    {
      "word": "clamp",
      "sentenceIndexes": [
        9
      ],
      "totalOccurrences": 1
    },
    {
      "word": "connect",
      "sentenceIndexes": [
        9
      ],
      "totalOccurrences": 1
    },
    {
      "word": "countri",
      "sentenceIndexes": [
        2
      ],
      "totalOccurrences": 1
    },
    {
      "word": "danger",
      "sentenceIndexes": [
        6
      ],
      "totalOccurrences": 1
    },
    {
      "word": "declin",
      "sentenceIndexes": [
        0
      ],
      "totalOccurrences": 1
    },
    {
      "word": "donat",
      "sentenceIndexes": [
        9
      ],
      "totalOccurrences": 1
    },
    {
      "word": "dont",
      "sentenceIndexes": [
        6
      ],
      "totalOccurrences": 1
    },
    {
      "word": "down",
      "sentenceIndexes": [
        9
      ],
      "totalOccurrences": 1
    },
    {
      "word": "effort",
      "sentenceIndexes": [
        9
      ],
      "totalOccurrences": 1
    },
    {
      "word": "empti",
      "sentenceIndexes": [
        2
      ],
      "totalOccurrences": 1
    },
    {
      "word": "extinct",
      "sentenceIndexes": [
        1,
        5
      ],
      "totalOccurrences": 2
    },
    {
      "word": "fate",
      "sentenceIndexes": [
        6
      ],
      "totalOccurrences": 1
    },
    {
      "word": "five",
      "sentenceIndexes": [
        6
      ],
      "totalOccurrences": 1
    },
    {
      "word": "for",
      "sentenceIndexes": [
        2,
        7
      ],
      "totalOccurrences": 2
    },
    {
      "word": "forest",
      "sentenceIndexes": [
        2
      ],
      "totalOccurrences": 1
    },
    {
      "word": "futur",
      "sentenceIndexes": [
        7
      ],
      "totalOccurrences": 1
    },
    {
      "word": "gener",
      "sentenceIndexes": [
        7
      ],
      "totalOccurrences": 1
    },
    {
      "word": "habitat",
      "sentenceIndexes": [
        9
      ],
      "totalOccurrences": 1
    },
    {
      "word": "help",
      "sentenceIndexes": [
        9
      ],
      "totalOccurrences": 1
    },
    {
      "word": "i",
      "sentenceIndexes": [
        1,
        2,
        5
      ],
      "totalOccurrences": 3
    },
    {
      "word": "if",
      "sentenceIndexes": [
        6
      ],
      "totalOccurrences": 1
    },
    {
      "word": "increas",
      "sentenceIndexes": [
        9
      ],
      "totalOccurrences": 1
    },
    {
      "word": "it",
      "sentenceIndexes": [
        5
      ],
      "totalOccurrences": 1
    },
    {
      "word": "last",
      "sentenceIndexes": [
        2
      ],
      "totalOccurrences": 1
    },
    {
      "word": "least",
      "sentenceIndexes": [
        1
      ],
      "totalOccurrences": 1
    },
    {
      "word": "massiv",
      "sentenceIndexes": [
        9
      ],
      "totalOccurrences": 1
    },
    {
      "word": "more",
      "sentenceIndexes": [
        1
      ],
      "totalOccurrences": 1
    },
    {
      "word": "much",
      "sentenceIndexes": [
        1
      ],
      "totalOccurrences": 1
    },
    {
      "word": "need",
      "sentenceIndexes": [
        1
      ],
      "totalOccurrences": 1
    },
    {
      "word": "now",
      "sentenceIndexes": [
        6
      ],
      "totalOccurrences": 1
    },
    {
      "word": "number",
      "sentenceIndexes": [
        0
      ],
      "totalOccurrences": 1
    },
    {
      "word": "on",
      "sentenceIndexes": [
        0,
        5,
        9,
        9
      ],
      "totalOccurrences": 4
    },
    {
      "word": "other",
      "sentenceIndexes": [
        6
      ],
      "totalOccurrences": 1
    },
    {
      "word": "out",
      "sentenceIndexes": [
        4
      ],
      "totalOccurrences": 1
    },
    {
      "word": "part",
      "sentenceIndexes": [
        2
      ],
      "totalOccurrences": 1
    },
    {
      "word": "poach",
      "sentenceIndexes": [
        2
      ],
      "totalOccurrences": 1
    },
    {
      "word": "protect",
      "sentenceIndexes": [
        1,
        9
      ],
      "totalOccurrences": 2
    },
    {
      "word": "remain",
      "sentenceIndexes": [
        1,
        6
      ],
      "totalOccurrences": 2
    },
    {
      "word": "result",
      "sentenceIndexes": [
        2
      ],
      "totalOccurrences": 1
    },
    {
      "word": "rise",
      "sentenceIndexes": [
        0
      ],
      "totalOccurrences": 1
    },
    {
      "word": "same",
      "sentenceIndexes": [
        6
      ],
      "totalOccurrences": 1
    },
    {
      "word": "save",
      "sentenceIndexes": [
        7
      ],
      "totalOccurrences": 1
    },
    {
      "word": "scale",
      "sentenceIndexes": [
        9
      ],
      "totalOccurrences": 1
    },
    {
      "word": "some",
      "sentenceIndexes": [
        2
      ],
      "totalOccurrences": 1
    },
    {
      "word": "speci",
      "sentenceIndexes": [
        1
      ],
      "totalOccurrences": 1
    },
    {
      "word": "still",
      "sentenceIndexes": [
        1
      ],
      "totalOccurrences": 1
    },
    {
      "word": "subspeci",
      "sentenceIndexes": [
        6
      ],
      "totalOccurrences": 1
    },
    {
      "word": "subspeciesBali",
      "sentenceIndexes": [
        4
      ],
      "totalOccurrences": 1
    },
    {
      "word": "support",
      "sentenceIndexes": [
        9
      ],
      "totalOccurrences": 1
    },
    {
      "word": "that",
      "sentenceIndexes": [
        1,
        2
      ],
      "totalOccurrences": 2
    },
    {
      "word": "thi",
      "sentenceIndexes": [
        1
      ],
      "totalOccurrences": 1
    },
    {
      "word": "tiger",
      "sentenceIndexes": [
        0,
        1,
        2,
        2,
        4,
        5,
        7,
        9,
        9
      ],
      "totalOccurrences": 9
    },
    {
      "word": "to",
      "sentenceIndexes": [
        1,
        1,
        5,
        9
      ],
      "totalOccurrences": 4
    },
    {
      "word": "trade",
      "sentenceIndexes": [
        2,
        9
      ],
      "totalOccurrences": 2
    },
    {
      "word": "vulner",
      "sentenceIndexes": [
        1
      ],
      "totalOccurrences": 1
    },
    {
      "word": "wai",
      "sentenceIndexes": [
        5
      ],
      "totalOccurrences": 1
    },
    {
      "word": "we",
      "sentenceIndexes": [
        6,
        7
      ],
      "totalOccurrences": 2
    },
    {
      "word": "wild",
      "sentenceIndexes": [
        1,
        2
      ],
      "totalOccurrences": 2
    },
    {
      "word": "will",
      "sentenceIndexes": [
        2,
        9
      ],
      "totalOccurrences": 2
    },
    {
      "word": "wipe",
      "sentenceIndexes": [
        4
      ],
      "totalOccurrences": 1
    },
    {
      "word": "work",
      "sentenceIndexes": [
        1
      ],
      "totalOccurrences": 1
    }
  ]
}
