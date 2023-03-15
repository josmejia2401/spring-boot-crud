# Proyecto de ejemplo de "microservicio" de Spring Boot

Esta es una aplicación Java/Maven/Spring Boot (versión 2.x) de muestra que se puede usar como iniciador para crear un microservicio completo con verificación de estado integrada, métricas y mucho más. Espero que te ayude.

## ¿ Como correr ?

Esta aplicación está empaquetada como una guerra que tiene integrado Tomcat 8. No es necesaria la instalación de Tomcat o JBoss. Lo ejecutas usando el comando ``java -jar``

* Clonar este repositorio
* Asegúrese de estar usando JDK 1.8 y Maven 3.x
* Puede compilar el proyecto y ejecutar las pruebas ejecutando ``mvn clean package``
* Una vez construido con éxito, puede ejecutar el servicio mediante uno de estos dos métodos:

```
        java -jar -Dspring.profiles.active=test target/spring-boot-crud.jar
or
        mvn spring-boot:run -Drun.arguments="spring.profiles.active=test"
```
* Verifique el archivo stdout o boot_example.log para asegurarse de que no se produzcan excepciones.

Una vez que se ejecute la aplicación, debería ver algo como esto

```
2017-08-29 17:31:23.091  INFO 19387 --- [           main] s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat started on port(s): 8090 (http)
2017-08-29 17:31:23.097  INFO 19387 --- [           main] com.josmejia2401.Application        : Started Application in 22.285 seconds (JVM running for 5.032)
```

## Sobre el Servicio

El servicio es simplemente un servicio REST de administración de tareas. Utiliza una base de datos en memoria (H2) para almacenar los datos. También puedes hacerlo con una base de datos relacional como MySQL o PostgreSQL. Si las propiedades de conexión de su base de datos funcionan, puede llamar a algunos puntos finales REST definidos en ``com.josmejia2401.Application`` el **puerto 8081** . (vea abajo)


Puede usar este servicio de muestra para comprender las convenciones y configuraciones que le permiten crear un servicio RESTful respaldado por base de datos. Una vez que comprenda y se sienta cómodo con la aplicación de muestra, puede agregar sus propios servicios siguiendo los mismos patrones que el servicio de muestra.
 
Esto es lo que demuestra esta pequeña aplicación:

* Integración completa con el último Spring Framework: inversión de control, inyección de dependencia, etc.
* Asignación de excepciones de excepciones de aplicaciones a la respuesta HTTP correcta con detalles de excepción en el cuerpo
 Spring Data Integration con JPA/Hibernate con solo unas pocas líneas de configuración y anotaciones familiares.
* Funcionalidad CRUD automática contra la fuente de datos utilizando el patrón Spring Repository
* Todas las API están "documentadas" en **POSTMAN**.

### Obtenga información sobre el estado del sistema, configuraciones, etc.

```
http://localhost:8081/api/tasks
```

# Acerca de Spring Boot

Spring Boot es un marco de arranque de aplicaciones "obstinado" que facilita la creación de nuevos servicios RESTful (entre otros tipos de aplicaciones). Proporciona muchas de las instalaciones habituales de Spring que se pueden configurar fácilmente, por lo general sin ningún XML. Además de la fácil configuración de Spring Controllers, Spring Data, etc. Spring Boot viene con el módulo Actuator que brinda a la aplicación los siguientes puntos finales útiles para monitorear y operar el servicio.

### Para ver su base de datos en memoria H2

El perfil de "prueba" se ejecuta en la base de datos en memoria H2. Para ver y consultar la base de datos, puede navegar a http://localhost:8081/h2-console . El nombre de usuario predeterminado es 'sa' con una contraseña en blanco. Asegúrese de deshabilitar esto en sus perfiles de producción. Para obtener más información, consulte https://goo.gl/U8m62X

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