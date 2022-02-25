# Smoothie
    # Add a new branch for each microservice of the backend and use backend branch as a parent.
    # Add a new branch for each componenet,service of the frontend ad use frontend branch as a parent. 

## Orderflow from web
 Customer QRScanning --> Customer Registration/Login --> Resturant Menu --> Customer Food Ordering --> Resturant Order Details --> Customer Payment

## Orderflow from Phone App
 Customer QRScanning --> Resturant Menu --> Customer Food Ordering --> Resturant Order Details --> Resturant Order Fetching --> Customer Payment

## Customer Services
    # Customer QRScanning
        1- When user scans a QRcode a user session should be started and and this will initiate a user login/registration session.
        2- After scanning the code user will be redirected to see Customer Registration/Login service.
        
    # Customer Registration/Login
        1- Simple Registration service and after successful registration the user will be redirected to Customer Ordering Registration.        

    # Customer Food Ordering 
        1- Think of it like shopping on Amazon webiste and adding the food to cart with order button.
        2- An additional functionality this service should have is for the user to edit the completed order.
        3- This service is a Producer(FoodCompletionEvent) and Consumner(Resturant Order Fetching Details) service uses the event.  
        
    # Customer Payment
        1- Stripe integration.  
        
## Resturant Services

    # Resturant Order Fetching 
        1- Event-driven micorservice
        2- Whenever Customer Food Orderging service produces a food completion event this service will use that event.<!--https://www.confluent.io/learn/data-streaming/-->,<!-- https://stackoverflow.com/questions/42151544/when-to-use-rabbitmq-over-kafka -->

    # Resturant Menu 
        1-This microservice should be for a resturant to upload the food menu.
        2- Resturant Menu DB will store the information about the food menu.         

## DataBase
    # Customer Registration DB 
    {
        "customerName": "Irfan Mustafa",
        "password":"********",
    }

    # Customer Ordering DB  
    {
        "foodItems": [{
            "price": "14.55",
            "quantity":"2"
            "foodItemName": "Flafel",
            "foodItemCode": "008123655",<!-- This is the code associated with the orderd food usually provided by resuturant -->
            "tableNumber": "3",
            "foodStatus": "Deleivered/Ordered/Completed/InProgress",
            "OrderNotes": "I want food to be extra spicy"
            }   
        ]
    }

    # Resuturant Food Menu
    {
        "foodItemName":"Flafel",
        "price":"14.55",
        "foodItemCode": "008123655",<!-- This is the code associated with the orderd food usually provided by resuturant -->
        "Availablity Status":"Available/NotAvailable"
        
    }

## Add your files

- [ ] [Create](https://docs.gitlab.com/ee/user/project/repository/web_editor.html#create-a-file) or [upload](https://docs.gitlab.com/ee/user/project/repository/web_editor.html#upload-a-file) files
- [ ] [Add files using the command line](https://docs.gitlab.com/ee/gitlab-basics/add-file.html#add-a-file-using-the-command-line) or push an existing Git repository with the following command:

```
cd existing_repo
git remote add origin https://gitlab.com/Irfan-CU/smoothie.git
git branch -M main
git push -uf origin main
```

## Integrate with your tools

- [ ] [Set up project integrations](https://gitlab.com/Irfan-CU/smoothie/-/settings/integrations)

## Collaborate with your team

- [ ] [Invite team members and collaborators](https://docs.gitlab.com/ee/user/project/members/)
- [ ] [Create a new merge request](https://docs.gitlab.com/ee/user/project/merge_requests/creating_merge_requests.html)
- [ ] [Automatically close issues from merge requests](https://docs.gitlab.com/ee/user/project/issues/managing_issues.html#closing-issues-automatically)
- [ ] [Enable merge request approvals](https://docs.gitlab.com/ee/user/project/merge_requests/approvals/)
- [ ] [Automatically merge when pipeline succeeds](https://docs.gitlab.com/ee/user/project/merge_requests/merge_when_pipeline_succeeds.html)

## Test and Deploy

Use the built-in continuous integration in GitLab.

- [ ] [Get started with GitLab CI/CD](https://docs.gitlab.com/ee/ci/quick_start/index.html)
- [ ] [Analyze your code for known vulnerabilities with Static Application Security Testing(SAST)](https://docs.gitlab.com/ee/user/application_security/sast/)
- [ ] [Deploy to Kubernetes, Amazon EC2, or Amazon ECS using Auto Deploy](https://docs.gitlab.com/ee/topics/autodevops/requirements.html)
- [ ] [Use pull-based deployments for improved Kubernetes management](https://docs.gitlab.com/ee/user/clusters/agent/)
- [ ] [Set up protected environments](https://docs.gitlab.com/ee/ci/environments/protected_environments.html)

***

