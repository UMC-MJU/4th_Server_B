class User {
  constructor(name, email, phone) {
    this.name = name;
    this.email = email;
    this.phone = phone;
  }

  printInfo() {
    console.log("Name: " + this.name);
    console.log("Email: " + this.email);
    console.log("Phone: " + this.phone);
  }
}

const user = new User("김현성", "rlagustjd2684@gmail.com", "010-2167-8629");
user.printInfo();