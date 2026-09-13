Estudiante: Angel David Chara Vargas
Universidad Mi remington

Proyecto: GESTION DE TORNEOS

Este es un proyecto que gestiona los datos de un torneo de futbol.
Para dar continuidad al proyecto antes guardabamos los datos y la informacion se perdia, 
Ahora los datos son persistentes y se guardaran mediante JPA e HIBERNATE y podra consultarse despues.


En esta segunda versión del proyecto incorporé persistencia de datos utilizando JPA, Hibernate y H2. Convertí la clase Torneo en una entidad persistente mediante las anotaciones @Entity, @Id y @GeneratedValue.

También creé un repositorio que extiende de JpaRepository, lo que permite utilizar automáticamente operaciones como guardar, consultar, actualizar y eliminar registros.

En la capa de servicio implementé las operaciones CRUD y una consulta personalizada para buscar torneos por ciudad. El controlador expone los endpoints HTTP y utiliza ResponseEntity para devolver códigos coherentes como 200, 201, 204 y 404.

Finalmente, configuré H2 como base de datos y Hibernate como herramienta de persistencia. Esto permite que los torneos creados puedan consultarse posteriormente, incluso después de reiniciar la aplicación.

se agregan dependencias de JPA Y H2

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>

<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <scope>runtime</scope>
</dependency>

Y se configura la base datos H2 con su respectiva propiedad y funcion.
spring.datasource.url --> Define dónde se almacenan los datos.
jdbc:h2:file:./data/torneosdb-->Utiliza una base de datos H2 persistente en archivos.
ddl-auto=update-->Hibernate crea o actualiza la tabla según la entidad.
show-sql=true-->Permite ver las consultas SQL en la terminal.
h2-console.enabled=true-->Habilita la consola web de H2.


Se agrega @Entity esta clase nos indica que sera una entidad persistente.
@Table(name = "torneos") nos define el nombre de la tabla en la base de datos
@Id indica cual es el identificador
@GeneratedValue(strategy = GenerationType.IDENTITY) se genera automaticamente el ID


operaciones CRUD que se tiene ahora

CREATE — Crear  
POST /api/torneos
Registra un nuevo torneo en la base de datos.
READ — Consultar
GET /api/torneos
GET /api/torneos/{id}
Consulta todos los registros o uno específico.
UPDATE — Actualizar
PUT /api/torneos/{id}
Modifica un torneo existente.
DELETE — Eliminar
DELETE /api/torneos/{id}
Elimina un torneo de la base de datos.


CORRER EL PROGRAMA.
para iniciar la aplicacion 
./mvnw spring-boot:run