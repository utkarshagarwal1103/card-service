# Sample Full Stack example using Java and React 
Project name - card-service<br>
This is test project to add the credit card details and display the existing cards in tabular format.

Step to execute -
1. Clone the repository
2. Run the Spring boot project using maven or Spring boot main Application file - CardServiceApplication.java
3. Once Spring boot application is started, open powershell ,go to frontend directory
4. run - npm start 
5. front end Application will be started on -http://localhost:3000 and Backend api will be running on http://localhost:8090/card-service

Project Details -

# Java-Backend<br>
Two Apis are exposed
1. * **URL**         - http://localhost:8090/card-service/add
   * **Method**      - POST
   * **Data Params** - {
    "name": "\<name>",
    "creditCardNumber":"\<credit card number>",
    "limit" : \<limit for credit card>
} 
* **Success Response** - 200 Ok
* ** Failure Response** - 422 UNPROCESSABLE_ENTITY
 {
    "timestamp": "\<TimeStamp>",
    "message": "Credit Card number not valid"
}

2.* **URL**         - http://localhost:8090/card-service/getcardlist
   * **Method**      - GET
   * **Sample Response Body** - [
    {
        "id": 1,
        "name": "test1",
        "creditCardNumber": "12345674",
        "balance": 0,
        "limit": 2000
    },
    {
        "id": 2,
        "name": "test2",
        "creditCardNumber": "12345674",
        "balance": 0,
        "limit": 2005
    }
]
 
 **Key points** -
 1. Test cases are written as part of Unit testing
 2. In Memory Db is used to store Data when Application is running table name - Card
 3. Credit Card is validated using luhn Algo.
 4. Spring boot dependencies, lambok is utiized
 
 Next Steps
 1. logging can be added.
 2. More test cases can written to get more coverage.To evaluate coverage jacoco can be integrated.
 3. further refactoring of code.
 
# Front End<br>
Single Screen is created to interact two apis
![image](https://user-images.githubusercontent.com/86582547/123579684-470aed80-d7d0-11eb-83bd-6a1fe5dc3bc9.png)

When User add valid card Details then it gets added in existing card list

Technical flow
App.js -->addcard-->index.js -->Displaycard.js

for CSS - CombinedPage.css 

Accessibility is added for textboxes

Next Steps-  
1. UI level validation to be added to validate User Inputs
2. Handled invalid card response
3. Refactor UI as per Screen


 
 


