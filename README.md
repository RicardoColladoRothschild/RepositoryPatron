# Java Swing App para Gestionar Gastos



### Esta aplicación Java Swing está diseñada para permitirte gestionar tus gastos de manera eficiente. Utiliza una base de datos PostgreSQL para almacenar los datos de los gastos y una interfaz de usuario simple y fácil de usar.

## Clonar el Repositorio
Para clonar el repositorio, sigue estos pasos:

Abre tu terminal.
Ejecuta el siguiente comando:
bash
```bash
git clone https://github.com/RicardoColladoRothschild/RepositoryPatron.git
```

Abrir el Proyecto en IntelliJ IDEA
Para abrir el proyecto en IntelliJ IDEA, sigue estos pasos:


## Estructura del Proyecto
El proyecto sigue una estructura básica de paquetes que separa las diferentes partes de la aplicación:

model: Contiene las clases que representan los datos de la aplicación.
repository: Contiene las clases encargadas de interactuar con la base de datos.
util: Contiene clases de utilidad, como la clase de conexión a la base de datos.
view: Contiene la interfaz de usuario de la aplicación, implementada con Java Swing.
Explicación del Código<a name="explicación-del-código"></a>
Modelo (Model)
En el paquete org.corecode.model, encontrarás la clase Expenses, que representa un gasto. Esta clase tiene atributos como amount (cantidad), category (categoría), description (descripción), etc.

## Repositorio (Repository)
El paquete org.corecode.repository contiene la clase ExpensesRepository, que se encarga de interactuar con la base de datos para realizar operaciones CRUD (crear, leer, actualizar, eliminar) en la tabla de gastos.

## Utilidades (Util)
En el paquete org.corecode.util, encontrarás la clase DataBaseConnection, que proporciona una conexión a la base de datos PostgreSQL.

## Interfaz de Usuario (View)
El paquete org.corecode.view contiene la clase SwingApp, que representa la interfaz de usuario de la aplicación. Utiliza componentes de Java Swing como botones y tablas para interactuar con el usuario y mostrar los datos de los gastos.

## Ejecutar la Aplicación
Para ejecutar la aplicación, simplemente abre el proyecto en IntelliJ IDEA, asegúrate de tener configurada una base de datos PostgreSQL local con los mismos parámetros de conexión que se encuentran en la clase DataBaseConnection, y ejecuta la clase SwingApp. Esto iniciará la aplicación y podrás empezar a gestionar tus gastos.

## DB_PostgreSQL
La base de datos no ha sido incluida, en su lugar un archivo docker-compose
que sube el motor de base de datos y crea la base de datos.
Tambien hay un archivo init.sql que va a crear las tablas de la DB y colocar
una primera insercion para que la tabla no este vacia.

Desde la carpaeta del proyecto para subir el contenedor (teniendo docker desptop)

```bash
docker-compose.yml up
```
PD: Tambien agregue pgAdmin