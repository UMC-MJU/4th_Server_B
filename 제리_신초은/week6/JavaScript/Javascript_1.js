//문자열로 이루어진 배열이 주어졌을 때, 배열에 있는 모든 문자열을 대문자로 바꾸어 반환하는 함수를 작성하세요.
// 단, map 메서드를 사용하지 않고 for 루프를 사용하여 작성하세요

const arr = ["apple", "banana", "orange"];
const newArr = toUpperCase(arr);    //대문자로 변환
console.log(newArr); // ["APPLE", "BANANA", "ORANGE"]

function toUpperCase(arr) {
    const newArr = [];
    for (let i = 0; i < arr.length; i++) {
        newArr.push(arr[i].toUpperCase());
    }
    return newArr;
}