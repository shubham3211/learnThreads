let string  = "I am A good A very  A smart A  charasamatic A boy";
let regex1 =  new RegExp('good');
let regex2 = /good/;
let regex3 = /a\s/gi // /s is used to demote space in regular expression 

// console.log(regex1.test(string));
// console.log(regex2.test(string));

// console.log(regex1.exec(string));
// console.log(regex2.exec(string));

// /g is useed for global
// i is used for case insensitivity
// m multiline match


// console.log(string.match(regex2));
// console.log(string.replace(regex1, 'h1'));
// console.log(string.split(regex1));
// console.log(string.split(regex3));

console.log(regex3.exec(string));
//here it would retain the index for last match and start form there
console.log(regex3.exec(string));
console.log(regex3.exec(string));

// . is a single character in a string . doesnot matches a newline character
let r4 = /ra./g
console.log(r4.exec(string));

// \. is used to escape characters like . $ in regex

// \t tab \v vertical tab \n newline \r carriage return

// gr[ae]y in this case it would match either gray grey
// [abcd][i] woouldmatch a or b or c or d from first group and i form secod group
// metacharacters donot act as meta characters inside square brackets they act like a complete character
// range in regex [1-4] 
// if we want to use a - in a character set then we would have to escape it
//each a=character st would amtcha singlw character
// we can specify range only between individual charactres not between a range of character ie like [10-20] 
// each number is treater as a group of characters like 19 is 1 and 9 not nineteen 
// we use ^ neagte a set of characters in  character set
// \w also match the _ character 
// \d[0-9] \w[a-zA-Z0-9]  \s[ \t\r\n] \D[^0-9] \W[^a-zA-Z0-9] \s[^ \t\r\n]
// \w also matches the _ character

// + matches one or more occurences ? matches zero or one occurence * matches zero or more occurence
// \d? means 0 or 1 consecutive occurence of number 
// \d* means 0 or more consecutive occurence of number 
// \d+ means 1 or more consecutive occurence of number 
// \<p>.*</p>\ would match every thing ie it would match <p>dkjqndk</p><p>dkqwndnkwq</p> here it would amtch both the p tag.
// but if we write \<p>.*?</p>\ then it would become lazy and match as little as possible ie it would only match the first p tag in the above expression
// similarly \<p>.*?\ would only match <p> even as it is lazy

// {min, max} match from min to max
// {min} matches min occurencen
// {min, } matches from min to infinity occurences
// {min, max}? will only capture min characters as it is lazy but wheen we have a boundary like
// {min, max}?- it will find between min and amx till it find the -
// ^ matches to the start of the line
// $ matches to the last of line
// \^The\m would match The at the start of each line
// in case of multiline expression the $ work for end of data or start of newline
// \bplan would match the word plan to the left of which is non word character is alphaplan won't work
// but planalpha would work it is not necessary to use a word we can also wirte \bpan to\b
// \B would match only if there are characters to the left in case of \Bplan we can use \bthe\b in case of both left and right
// | is the or expression in regex but it has to be only 1 pipe ie \\bmonday|tuesday|wednesday|thursday|friday|saturday|sunday\b\
// in case of pipe symbol use \b each time of the reqular expession surrounded by pipe
// ([a-z][1-5]){5} matches the entire group five times ie it would match a1b2c3d4e5 
// instead of putting word boundary for every expression in pipe we can group the entire pipe and put the word boundary
// ie \b(monday|tuesday|wedesday|thursday|friday|saturady|sunday)\b
// (\w+\s)\1 would match the exact same set of charactrs identified by (\w+\s) in the pattern it is a back reference 
// it only referes to what is in the group
// \w+(?=\.com) matches a sting ending with a .com

// \^(?=.{8,})(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9]).*$\
// In the regualr expression above the first group matches form the start of string 8 characters or more
// The second group would match form the start of the string if a upper case character is found
// The third group would find any lower case character from the start of the string
// The fourth group would fidn any letter from the start of the string
// This is for password 
//  \^(?=.{8,})(?=.*[A-Z])(?=.*[a-z])(?!.*[0-9]).*$\
// The above regex would follow all the conditions mentioned above but it should not conatin a number as shown by negative lookahead group as we have written ?!
// \\u0061\ would match a as it is the unicode character for a 
// we can also do [\u0061-\u0067] to match a range of characters
// genrally the unicode character conatin only 4 characters after u but if we have 5 characters after u ie 1D11e then we should do it like this \u{1D11E} in this case we would have to specify a u flag
// /^[^\s@.]+@[^\s@.]+\.[^\s@.]+$/ is for email
// ^@\w+$ match a twitter handle but check on internet
// ^(3[01]|[12][0-9]|0?[1-9])\/(0?[1-9]|1[0-2])\/([0-9]{2})?([0-9]{2})$ match dates
// 