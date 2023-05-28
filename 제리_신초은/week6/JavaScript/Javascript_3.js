//사용자로부터 입력받은 수를 0으로 나누는 코드를 작성하세요.
// 이때, 0으로 나누려는 경우 "Cannot divide by zero"라는 메시지를 출력하고, 그 외의 경우에는 나눈 값을 출력하세요.
const num = prompt("Enter a number");   //수 입력받기
try {
    const result = num / 0;
    console.log("Result: " + result);
} catch (error) {
    console.log("Cannot divide by zero");
}