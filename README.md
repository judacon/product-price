# README
## Product Prices

Api que provee end point rest de consulta  tal que:

Acepta como parámetros de entrada:
- Fecha de aplicación
- Identificador de producto
- Identificador de cadena.

Devuelve como datos de salida:
- Identificador de producto
- Identificador de cadena
- Tarifa a aplicar
- Fechas de aplicación
- Precio final a aplicar.

## Tecnologias

Se utilizo el siguiente stack tecnologico para su desarrollo

| Tecnologia | Descripcion                                   |
|------------|-----------------------------------------------|
| Java 17    | Jenguaje de programacion                      |
| Spring     | Framework de desarrollo                       |
| Spring JPA | API de persistencia desarrollada para Java EE |
| H2         | Base de datos en memoria                      |
| Lombock    | Herramienta para minimizar boilerplate code   |
| Junit      | Framework para testing                        |
| Swagger 3  | Documentacion                                 |

## Instalacion

Para ejecutar el proyecto

```sh
./mvnw spring-boot:run
```


## Documentacion

Una vez ejecutado el proyecto se puede acceder a la documentacion con Swagger 3
```sh
http://localhost:8080/swagger-ui/index.html
```

## Ejecutar los tests

```shell
./mvnw test
```

## Ejecutar los tests con coverage

```shell
./mvnw clean test jacoco:report
```

## Test e2e

Los test e2e fueron desarrollados con Postman, se deben importar desde:

```shell
e2e/product-prices-e2e.postman_collection.json
```
## Docker

Si se desea se puede ejecutar la aplicacion utilizando el archivo Dockerfile que configura el ambiente
y clona el repositorio directamente

```shell
docker/Dockerfile
```


## Enunciado

En la base de datos de comercio electrónico de la compañía disponemos de la tabla PRICES que refleja el precio final
(pvp) y la tarifa que aplica a un producto de una cadena entre unas fechas determinadas. A continuación se muestra un
ejemplo de la tabla con los campos relevantes:

### PRECIOS

| BRAND_ID | START_DATE          | END_DATE            | PRICE_LIST | PRODUCT_ID | PRIORITY | PRICE | CURR |
|----------|---------------------|---------------------|------------|------------|----------|-------|------|
| 1        | 2020-06-14-00.00.00 | 2020-12-31-23.59.59 | 1          | 35455      | 0        | 35.50 | EUR  |
| 1        | 2020-06-14-15.00.00 | 2020-06-14-18.30.00 | 2          | 35455      | 1        | 25.45 | EUR  |
| 1        | 2020-06-15-00.00.00 | 2020-06-15-11.00.00 | 3          | 35455      | 1        | 30.50 | EUR  |
| 1        | 2020-06-15-16.00.00 | 2020-12-31-23.59.59 | 4          | 35455      | 1        | 38.95 | EUR  |

**Campos**:

* **BRAND_ID**: foreign key de la cadena del grupo (1 = ZARA).
* **START_DATE, END_DATE**: rango de fechas en el que aplica el precio tarifa indicado.
* **PRICE_LIST**: Identificador de la tarifa de precios aplicable.
* **PRODUCT_ID**: Identificador código de producto.
* **PRIORITY**: Desambiguador de aplicación de precios. Si dos tarifas coinciden en un rango de fechas se aplica la de
  mayor prioridad (mayor valor numérico).
* **PRICE**: precio final de venta.
* **CURR**: iso de la moneda.</br></br>

**Se pide:**

Construir una aplicación/servicio en SpringBoot que provea una end point rest de consulta tal que:

Acepte como parámetros de entrada: fecha de aplicación, identificador de producto, identificador de cadena.

Devuelva como datos de salida: identificador de producto, identificador de cadena, tarifa a aplicar, fechas de
aplicación y precio final a aplicar.

Se debe utilizar una base de datos en memoria (tipo h2) e inicializar con los datos del ejemplo, (se pueden cambiar el
nombre de los campos y añadir otros nuevos si se quiere, elegir el tipo de dato que se considere adecuado para los
mismos).

Desarrollar unos test al endpoint rest que validen las siguientes peticiones al servicio con los datos del ejemplo:

* Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA)
* Test 2: petición a las 16:00 del día 14 del producto 35455 para la brand 1 (ZARA)
* Test 3: petición a las 21:00 del día 14 del producto 35455 para la brand 1 (ZARA)
* Test 4: petición a las 10:00 del día 15 del producto 35455 para la brand 1 (ZARA)
* Test 5: petición a las 21:00 del día 16 del producto 35455 para la brand 1 (ZARA)

**Se valorará:**

* Diseño y construcción del servicio.
* Calidad de Código.
* Resultados correctos en los test.