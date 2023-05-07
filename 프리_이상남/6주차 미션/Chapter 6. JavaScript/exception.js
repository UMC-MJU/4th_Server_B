const readline = require('readline');
 
// 인터페이스 객체를 만들자.
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});
try {
  const result = num / 0;
  console.log("Result: " + result);
} catch (error) {
  console.log("Cannot divide by zero");
}