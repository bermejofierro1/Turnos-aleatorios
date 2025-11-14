# 🕒 Gestor de Turnos para Camareros
### Aplicación de Escritorio – JavaFX + MongoDB

![JavaFX](https://img.shields.io/badge/JavaFX-Application-blue?style=for-the-badge&logo=java)
![MongoDB](https://img.shields.io/badge/MongoDB-NoSQL-green?style=for-the-badge&logo=mongodb)
![Java](https://img.shields.io/badge/Java-17%2B-orange?style=for-the-badge&logo=oracle)
![MVC](https://img.shields.io/badge/Pattern-MVC-yellow?style=for-the-badge)

Aplicación de escritorio desarrollada con **JavaFX** para generar y gestionar cuadrantes semanales de camareros, con asignación automática inteligente y almacenamiento en **MongoDB**.

---

## ✨ Características principales

### 👥 Gestión de camareros
- ✅ Crear camareros (nombre + género)
- 📋 Consultar listado desde MongoDB
- ✏️ Editar disponibilidad semanal
- 🗑️ Borrar disponibilidad por día o completa

### 🗓️ Configuración de disponibilidad
Cada camarero posee un mapa de disponibilidad con claves día-turno:

{
  "LM": true,
  "LT": false,
  "MM": true,
  "MT": true
}



## 🤖 Generación automática del horario
### 🔍 Reglas de asignación inteligente

Distribución equitativa según disponibilidad total

Mínimo de mujeres por turno (configurable)

Evita asignar mañana + tarde el mismo día si no corresponde

Evita repetir tarde del día siguiente

Prioriza a camareros con menos turnos asignados

### 🧠 Proceso

Analiza la disponibilidad general

Genera un mapa día → camareros disponibles

Construye un objeto Horario

Muestra los turnos finales listos para imprimir o exportar

### 👁️ Vista del cuadrante

Camareros asignados por mañana y tarde

Opción para elegir quién se queda de tarde

Botón para regenerar los turnos

Tabla final lista para imprimir

## 📦 Tecnologías utilizadas
Tecnología	Uso
Java 17+	Backend y lógica
JavaFX + FXML	Interfaz gráfica
MongoDB	Base de datos NoSQL
ObservableList	Colecciones reactivas
Task / Threads	Evitar bloqueo de UI
MVC Pattern	Arquitectura limpia

### 🗂️ Estructura del proyecto
src/
 └── app/gui
     ├── controller/
     ├── modelo/
     ├── services/
     │    └── HorariosService.java
     ├── ventanas/
     │    ├── HorarioController.java
     │    ├── MostrarController.java
     │    ├── CrearController.java
     └── mongo/
          └── MongoSession.java



## 🚀 Cómo usar la aplicación

Registrar camareros

Configurar disponibilidad semanal

Pulsar “Crear horario”

Pulsar “Generar turnos” (algoritmo inteligente)

Ver o exportar el cuadrante final

## 🔮 Mejoras futuras

📄 Exportar cuadrante a PDF

🎨 Colores por género o tipo de turno

🔐 Sistema de login para administradores

🧮 Algoritmos avanzados basados en antigüedad o preferencias
