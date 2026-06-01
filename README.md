# 🎬 Cine Alvarez

Sistema de gestión para cine desarrollado con Spring Boot y MySQL.

---

## 🛠️ Tecnologías

- Java 21
- Spring Boot 4.0.6
- MySQL 8.0
- Gradle (Kotlin DSL)
- Docker & Docker Compose

---

## 🚀 Cómo ejecutar el proyecto

### Requisito único: tener [Docker Desktop](https://www.docker.com/products/docker-desktop) instalado y corriendo.

No hace falta instalar Java, Gradle ni MySQL.

### Pasos

```bash
# 1. Clonar el repositorio
git clone https://github.com/tu-usuario/Cine_Alvarez.git
cd Cine_Alvarez

# 2. Levantar todo
docker-compose up --build
```

Esperar a ver en la terminal:

```
Started CineAlvarezApplication
```

### 3. Abrir en el navegador

```
http://localhost:8080
```

---

## 🗄️ Base de datos

La base de datos `cine_db` se crea automáticamente al iniciar.  
El archivo `data.sql` carga datos de prueba la primera vez.

No es necesario crear nada manualmente.

---

## ⚙️ Comandos útiles

```bash
# Levantar (sin reconstruir la imagen)
docker-compose up

# Levantar con rebuild (tras cambios en el código)
docker-compose up --build

# Ver logs en tiempo real
docker-compose logs -f app

# Detener
docker-compose down

# Detener y borrar todos los datos (empezar de cero)
docker-compose down -v
```

---

## 📁 Estructura del proyecto

```
Cine_Alvarez/
├── src/                        # Código fuente
│   └── main/
│       ├── java/               # Entidades, repositorios, controladores, mappers, DTOs y servicios
│       └── resources/
│           ├── static/         # Frontend (HTML + JS)
│           ├── data.sql        # Carga de datos para la base de datos
│           └── application.properties
├── Dockerfile                  # Imagen de la aplicación
├── compose.yaml                # Orquestación de contenedores
└── build.gradle.kts
```

---

## 🐳 Arquitectura Docker

```
┌─────────────────────────────────────────┐
│           Docker (red interna)          │
│                                         │
│  ┌─────────────┐     ┌───────────────┐  │
│  │    MySQL    │◄────│  Spring Boot  │  │
│  │  puerto     │     │  puerto 8080  │  │
│  │  3306       │     │               │  │
│  └─────────────┘     └───────────────┘  │
│                              ▲          │
└──────────────────────────────┼──────────┘
                               │
                      localhost:8080
```

- La app espera a que MySQL esté saludable antes de iniciar
- Los datos de MySQL persisten entre reinicios gracias a un volumen Docker
- Para resetear la base de datos: `docker-compose down -v`
