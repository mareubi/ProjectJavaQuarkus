# Customer API - Quarkus RESTful Service

Este proyecto es un servicio RESTful desarrollado en Java usando el framework **Quarkus**. Permite gestionar una lista de clientes con operaciones CRUD y validaciones, incluyendo la consulta del gentilicio del país del cliente desde un servicio externo.

## ✨ Funcionalidades
- Crear cliente
- Obtener todos los clientes
- Obtener clientes por país
- Obtener cliente por ID
- Actualizar cliente (correo, dirección, teléfono, país)
- Eliminar cliente

## 🧱 Estructura del proyecto
```
src/main/java/com/example/customerapi
├── controller        # Exposición de endpoints REST
├── service           # Lógica de negocio
├── repository        # Persistencia de datos (PanacheRepository)
├── model             # Entidades JPA
├── dto               # Data Transfer Objects
├── client            # Cliente HTTP para restcountries.com
├── exception         # Manejo de errores y excepciones
```

## 🛠️ Requisitos
- Java 17+
- Maven 3.8+

## 🚀 Cómo ejecutar el proyecto
```bash
git clone https://github.com/usuario/customer-api.git
cd customer-api
./mvnw quarkus:dev
```

El servicio estará disponible en: `http://localhost:8080`

## 🔌 Endpoints disponibles
| Método | Endpoint                     | Descripción                              |
|--------|------------------------------|------------------------------------------|
| POST   | `/customers`                 | Crear un nuevo cliente                   |
| GET    | `/customers`                 | Obtener todos los clientes               |
| GET    | `/customers/country/{code}` | Obtener clientes por código de país ISO  |
| GET    | `/customers/{id}`           | Obtener cliente por ID                   |
| PUT    | `/customers/{id}`           | Actualizar campos permitidos del cliente |
| DELETE | `/customers/{id}`           | Eliminar cliente                         |

## 🌍 Servicio Externo
- Se usa la API pública `https://restcountries.com/v3.1/alpha/{code}` para obtener el gentilicio (nationality) del país a partir del código ISO 3166.

## 🧪 Pruebas
- Las pruebas unitarias se encuentran en el paquete `service`.
- Para ejecutar:
```bash
./mvnw test
```

## 📊 Diagrama de arquitectura
![architecture](diagrams/architecture.png) <!-- Reemplaza con la URL real si está en línea -->

## 📄 Consideraciones
- Se usa una base de datos en memoria (H2) para pruebas.
- Se aplica inyección de dependencias con CDI (Jakarta).
- Las validaciones se realizan en la capa de servicio.
- Cliente HTTP implementado usando `RestClient` de Quarkus.

## 📬 Contacto
Desarrollado como parte de una prueba técnica de back-end. Cualquier consulta técnica puede ser dirigida al autor del repositorio.
