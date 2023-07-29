
## Project date:
29 July, 2023


## Technology:
java, Spring-Boot, MongoDb
#Blog_Backend_api
by using this we can add blog with id, title, contnt, author.
we can delete or update
User can also add commnts on post , can update,can delete

# Installation guide:
1. just install vs code
2. install extension in vs code: 
   java extension pack
   ,spring boot extension pack
3. Now you have to install Postman for sending all type of request:

## How to start backend api:
1. open project in vs code then
2. now you will find Spring boot dashboard at left sidebar, there will be option to run blog_backend
after spring boot application started open Postman:
project is not depoyed so you have to open local host which is running on 8080 port.If another process is running on that port then first of all close that process.

## directories for different calls:
// this will give you all blogs which is saved
GET request: localhost:8080/api/posts/all

// this will post in database

provide data in json format:

POST request: localhost:8080/api/posts/add

example:

{

    "id":"tech",

    "title":"how to grow ev in world",

    "content": "first of all make is easy to reach and easy to use",

    "author": "Sunil"

}

you can see all methods from BlogController and type of request.
If there is any issue in using then call me: 8387841596


