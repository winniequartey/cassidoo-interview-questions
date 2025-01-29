var natoMap = {"A": "Alpha","B": "Bravo","C": "Charlie","D": "Delta","E": "Echo","F": "Foxtrot","G": "Golf","H": "Hotel","I": "India","J": "Juliett","K": "Kilo",
    "L": "Lima","M": "Mike","N": "November","O": "Oscar","P": "Papa","Q": "Quebec","R": "Romeo","S": "Sierra","T": "Tango","U": "Uniform","V": "Victor",
    "W": "Whiskey","X": "X-ray","Y": "Yankee","Z": "Zulu","0": "Zero","1": "One","2": "Two","3": "Three","4": "Four","5": "Five","6": "Six","7": "Seven",
    "8": "Eight","9": "Nine"," ": "{Space}",".": "{Fullstop}",",": "{Comma}","'": "{Apostrophe}","-": "{Dash}","_": "{Underscore}","/": "{Slash}",
    ":": "{Colon}",";": "{SemiColol}"};

function natoify(providedString){
    let upperCaseResult = providedString.toUpperCase();
    var natoifiedString = "";
    for (let char of upperCaseResult) {
        natoifiedString = natoifiedString + natoMap[char] + " ";
    }
    console.log(natoifiedString.trim());
}

natoify("hello world");
natoify("3spooky5me");