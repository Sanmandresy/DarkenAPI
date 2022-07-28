# DarkenAPI

This is an API made with Spring that takes an image from a HttpClient and render it with a gray shade.

How to use it ?

 1) You must have Java installed on your computer/laptop.
  > I use Java 18 and JDK 18
  
 2) Clone the repository :
 
 ```sh
    git clone https://github.com/Sanmandresy/DarkenAPI.git
 ```
 
 3) Install all the necessary maven dependencies.
 
 4) You can run the project with whatever IDE you use.
 
 5) The project will be running on the port 8080, which is TomCat port.
 
 6) To test if the API is responding to your call :
 
    - If you just use your Browser then go to **http://localhost:8080**
    - If you have Postman installed, then do a GET Request to **http://localhost:8080**
   
  > These two will render the same output : "Hello from the API".
  
 7) To change an image shade to gray :
  
  - You must do a POST Request to **http://localhost:8080/image**
  - In the request body, you must add the image (use form-data);
 
 8) If the image's size is not too high and the type is accepted then the new image will be rendered.
