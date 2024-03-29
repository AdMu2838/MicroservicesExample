# Configuración global de config-server:

- Conexión a la base de datos.
- Conexión a eureka.

## Configuración de precio en config server:

- default:  
  - puerto `2061`
- develop:  
  - puerto `1061`
- prelt:
  - puerto `3061`
- prepru:
  - puerto `7061`
- production:  
  - puerto `6061`

## Configuración de articulo en config server:

- default:
  - puerto `2062`
- develop:
  - puerto `1062`
- prelt:
  - puerto `3062`
- prepru:
  - puerto `4562`
- production:
  - puerto `6062`

## Configuración de pais en config server:
- default:
  - puerto `2063`
- develop:
  - puerto `1063`
- prepru:
  - puerto `4563`
- preint:
  - puerto `5763`
- production:
  - puerto `6063`

## OpenApi:
`Todos los servicios deben coincidir con la especificación del openapi.`

# Microservicios:
### Global:		
  - Todos los microservicios tienen que consumirse entre ellos mediante load balancer (No gateway)
  - Ningún los microservicio debe tener en su @RestClient el Request mapping "/api/v1", esto se agrega a través del gateway

  - Precio:
      - Si no existe el articulo o el pais, debe mostrar un 400 Bad Request (No importa el mensaje, con que muestre bad request está OK).
      - endpoint: 
          - `[POST]/api/v1/price`:
              - Debe consumir a articulo mediante `exists/{id}`, para validar si existe el artículo, antes de persistir la entidad precio. Usando Feign Client
              - Debe consumir a país mediante `exists/{id}`, para validar si existe el país, antes de persistir la entidad precio. Usando Feign Client
          - `[GET]/api/v1/price/article/{articleId}`:
              - Debe consumir a articulo mediante `exists/{id}`, para validar si existe el artículo, antes de consultar la base de datos. Usando Rest Template con load balancer
          - `[GET]/api/v1/price/country/{countryId}`:
               - Debe consumir a país mediante `exists/{id}`, para validar si existe el país, antes de consultar la base de datos. Usando Rest Template con load balancer

## Configuración del gateway:
 - (Todas las fechas tienen que estar con el GMT-5)
 - Puerto del gateway: 8080
 - El openapi muestra el puerto 8080, este es el puerto del gateway (8080).

 - Precio:
   - Quiero acceder a través de /api/v1/price, es decir: localhost:8080/api/v1/price
   - Quiero que para acceder al precio solo se pueda hasta las 7:45am del 2 de enero de 2024.
   - Quiero que solo se pueda acceder si se tiene el header "X-My-Header" con el valor "Examen2024"
   - Quiero que al yo realizar alguna petición al microservicio de precio, el consumidor del gateway reciba una cookie con la clave "Examen" y valor "2024"
 - Articulo:
   - Quiero que para acceder al artículo solo se pueda después las 9:37pm del 5 de febrero 2024
   - Quiero que a la respuesta se agregue el header "JavaMicro", con el valor "Examen2024"
   - Quiero que el microservicio reciba la cookie "my-cookie" con valor "examen" sin necesidad de que el consumidor envíe la cookie.
   - Quiero que solo se pueda acceder si se tiene la cookie "chocolate" con valor "70"
 - Pais:
   - Quiero que para acceder al país solo se pueda entre las 2:45am del 19 de enero de 2024 y las 7:31pm del 17 de febrero 2024
   - Quiero que se quite el header "X-My-Header" del Request.
   - Quiero que se agregue un header "X-My-Header" con el valor "17012024" al Response.
   - Quiero que se elimine un header "X-Untrusted-Header" del Response.
   - Quiero que solo se pueda acceder si se tiene la cookie "auth" con valor "java"

   Gateway Global: Si es necesario que se envíe un Header o una Cookie al gateway, para acceder al microservicio:
   - El microservicio no tiene que recibir ninguno de esos headers o cookies.

## Docker:
    - Todos los artefactos tienen que tener su Dockerfile funcional exponiendo el puerto por defecto.

## Nombre de las ramas:
    
El nombre de las ramas debe ser escrito en minúsculas y con el siguiente formato:
    feature/`<primer_apellido>`-`<segundo_apellido>`-`<primer_nombre>`

Por ejemplo mi rama sería:
    feature/delacruz-acosta-hans (El apellido tiene varias palabras pero sigue junto).
