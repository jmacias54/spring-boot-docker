# spring-boot-docker
Proyecto con Spring Boot (Hola mundo ) con las configuraciones correspondientes para hacerla una imagen para docker 


El proyecto ha sido montado sobre gradle, así que si no lo tienes instalado deberás.

Descargar gradle de la web oficial
Descomprimir los binarios en un directorio dentro de tu filesystem
Importar el directorio /bin del gradle a la variable de entorno PATH
Para verificar que hemos configurado gradle correctamente deberemos hacer

1
gradle -v
Instalación de Docker
Deberás por otra parte tener instalado en tu PC Docker. Si no lo tienes instalado, descargar de la página oficial Docker. Para verificar que tienes instalado docker correctamente hacer en el terminal.

1
docker version
Crear cuenta en hub.docker.com
Es necesario que te crees una cuenta en hub.docker.com donde podrás almacenar tus imágenes docker en la nube, de tal forma que podrás ejecutar tus imagenes allá donde quieras.


4. Ficheros

A continuación se muestra el build.gradle. Para crear nuestra primera imagen Docker a partir de un microservicio de SpringBoot simplemente deberemos incluir la dependencia se.transmode.gradle:gradle-docker:1.2, el plugin docker y finalmente la tarea gradle que nos permita generar la imagen.


La tarea buildDocker es la que nos va a crear nuestra imagen docker, la cual se encontrará tras la compilación en el directorio build/docker. Atributos a especificar

push. Indica si queremos subir la imagen docker a nuestro hub. Para ello habrá que realizar un login previo en docker (docker login) y autenticarnos con nuestras credenciales de hub.docker.com
applicationName. Nombre de la imagen Docker que se creará
tag. Nombre del repositorio en el hub de docker en donde subiremos nuestra imagen
dockerfile. Fichero en donde se indica la imagen base que se utilizará para crear nuestra imagen docker además de los pasos necesarios para arrancar nuestra imagen

Como vemos a continuación vamos a utilizar la imagen base frolvlad/alpine-oraclejdk8:latest para construir nuestra imagen de SpringBoot. Ésta contiene básicamente una jdk8 sobre la que arrancar nuestras aplicaciones Java. Podréis encontrar en store.docker.com el repositorio de imagenes disponibles.

5. Creación y ejecución de imagen docker

En primer lugar, nos logamos en docker para poder subir nuestra imagen a nuestro repositorio en hub.docker.com.

1
docker login
A continuación creamos y subimos nuestra imagen docker a nuestro repositorio

1
gradle buildDocker -Ppush


Para descargarla y ejecutarla deberemos hacer

1
docker run -p8080:8080 jorgehernandezramirez/spring-boot-docker:1.0-SNAPSHOT
Para mayor aclaración lo que se está ejecutando dentro del contenedor es nuestro microservicio de SpringBoot que hemos construído anteriormente.
