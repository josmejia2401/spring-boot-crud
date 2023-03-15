# Cree una imagen de Spring Boot Docker

Asegúrese de tener instalado Docker Engine. Para verificarlo, ejecute el comando docker ps o docker info en la pantalla del terminal. Si no se encuentra el comando, es posible que primero deba instalar Docker. En este caso, siga este enlace y busque el instalador para su sistema operativo.

Ejecute su Docker Engine. Busque la carpeta con el Dockerfile de su proyecto Spring Boot en la terminal y ejecute el siguiente comando (asegúrese de finalizar el comando con un espacio y un punto):

```sh
docker build -t spring-boot-docker:spring-docker .
```

El comando "construir" construirá una imagen de acuerdo con las instrucciones que le pasamos al Dockerfile y el indicador -t se usa para agregar una etiqueta para nuestra imagen.



# Ejecute la imagen Spring Boot Docker en un contenedor

Ahora ejecutaremos nuestra imagen en un contenedor, pero primero nos aseguraremos de que no obtengamos un error al intentar señalar el puerto de nuestro contenedor con el localhost.

Ejecute el siguiente comando:

```sh
docker run -p 8081:8081 spring-boot-docker:spring-docker .
```

Puede agregar el indicador -d antes de -p para evitar ver registros y ejecutar el contenedor en segundo plano.

La bandera -p crea una regla de firewall que asigna el puerto del contenedor expuesto anteriormente: 8081 al puerto: 8081 en su máquina.

Si todo se hace bien, nuestro contenedor debería estar funcionando.