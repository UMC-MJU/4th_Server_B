const arr = ["apple", "banana", "orange"];
const newArr = toUpperCase(arr);
console.log(newArr); 

function toUpperCase(arr) {
  const newArr = [];
  for (let i = 0; i < arr.length; i++) {
    newArr.push(arr[i].toUpperCase());
  }
  return newArr;
}