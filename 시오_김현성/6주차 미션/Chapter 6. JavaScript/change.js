const arr = ["umc", "ABCDEF", "kim hyun seong"];
const newArr = toUpperCase(arr);
console.log(newArr); // ["APPLE", "BANANA", "ORANGE"]

function toUpperCase(arr) {
  const newArr = [];
  for (let i = 0; i < arr.length; i++) {
    newArr.push(arr[i].toUpperCase());
  }
  return newArr;
}