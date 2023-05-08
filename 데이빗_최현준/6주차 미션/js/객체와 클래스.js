// 사용자 정보를 저장하는 User 클래스를 작성하세요. User 클래스는 사용자의 이름(name), 이메일(email), 연락처(phone)를 멤버 변수로 가지며, 생성자와 정보를 출력하는 printInfo() 메서드를 작성하세요.
class User {
    constructor(name, email, phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
    
    printInfo() {
        console.log("이름: " + this.name);
        console.log("이메일: " + this.email);
        console.log("연락처: " + this.phone);
    }
}
