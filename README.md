# HOW TO

## NB!!! Sul peab olema loodud EduVPN ühendus kooliga, muidu ei saa andmebaasiga ühendust.

Local build start: `./gradlew bootrun`

 
## Production setup:
### On second run ignore steps 3.*

Step 1: Build clean project
`./gradlew clean build`

Step 2: Create/update Docker Image
`docker build -t dekons/parkla_backend .`

Step 3.1: Tag the Image
`docker tag dekons/parkla_backend dekons/parkla_backend:latest`

Step 3.2: Login to docker hub (password is stored in password.txt)
`cat password.txt | docker login --username dekons --password-stdin`

Step 4: Push Image to Dockerhub
`docker push dekons/parkla_backend:latest`

