# ControlGastosJavaFx
Aplicación JavaFX para registrar y gestionar gastos con SQLite

Cómo creé el repositorio en GitHub y subí mi proyecto (usando solo interfaz gráfica de IntelliJ)
1.	Creación del repositorio en GitHub
o	Entré a GitHub y me conecté a mi cuenta.
o	Hice clic en New Repository.
o	Asigné un nombre al repositorio 
o	Seleccioné la visibilidad (público)
o	Le di a crear con READ ME
o	Presioné Create Repository.
o	GitHub me dio la URL HTTPS del repositorio 
 
2.	Abrir el proyecto en IntelliJ y habilitar Git
o	Abrí mi proyecto en IntelliJ IDEA.
o	Fui a VCS → Enable Version Control Integration y seleccioné Git.
o	Esto convirtió mi carpeta de proyecto en un repositorio Git local.
 
3.	Primer commit local
o	Fui al panel lateral Git en IntelliJ.
o	Seleccioné los archivos que quería subir.
o	Hice clic en Commit..., escribí un mensaje: "Primer commit" y confirmé.
o	Esto guardó los cambios solo en mi repositorio local.
 
4.	Creación de una nueva rama
o	En la esquina inferior derecha, donde dice la rama actual , hice clic.
o	Seleccioné New Branch y escribí el nombre de la nueva rama (prod)
o	IntelliJ cambió mi trabajo a esa rama.

5.	Enlazar el repositorio local con GitHub y hacer push
o	Fui a Git → Proyect form versión control y añadí la URL HTTPS (https://github.com/AivenChacon/ControlGastosJavaFx) de mi repositorio en GitHub.
o	Con el proyecto en la rama prod, fui a Git → Push....
o	IntelliJ me pidió autenticarme con mi cuenta de GitHub.
o	Confirmé y subí mi código a esa rama del repositorio remoto.
 
   
Cómo correr el proyecto desde cualquier equipo usando GitHub
1.	Instalar Git en el nuevo equipo
o	Descargué Git desde git-scm.com y lo instalé.
2.	Clonar el repositorio
o	En IntelliJ, seleccioné File → New → Project from Version Control → Git.
o	Pegué la URL del repositorio de GitHub (https://github.com/AivenChacon/ControlGastosJavaFx).
o	IntelliJ descargó todo el proyecto en la computadora.
3.	Cambiar a la rama donde está el código
o	En la esquina inferior derecha de IntelliJ, seleccioné la rama donde trabajé (prod)
4.	Ejecutar el proyecto
o	Configuré el entorno necesario (si es Java, seleccioné la versión de JDK correcta).
o	Presioné el botón Run para ejecutar el proyecto normalmente.

NOTA: PARA QUE SE PUEDAN CORRER LAS PRUEBAS UNITARIAS HAY QUE HACER LO SIGUIENTE
1.	Abrir IntelliJ IDEA y carga el proyecto.
2.	En la barra superior, ir a Run > Edit Configurations...
3.	En la ventana que aparece, busca la configuración de ejecución de tests que usas (puede estar como un perfil de ejecución tipo JUnit o All in package).
o	Si no tienes una configuración creada, crea una nueva pulsando el botón + y selecciona JUnit.
4.	Selecciona la configuración de test a la que quieres agregar las opciones.
5.	En el campo VM options, agrega las siguientes líneas --add-opens org.junit.platform.commons/org.junit.platform.commons.util=ALL-UNNAMED --add-opens org.junit.platform.commons/org.junit.platform.commons.logging=ALL-UNNAMED --add-opens org.junit.platform.commons/org.junit.platform.commons=ALL-UNNAMED 
6.	Guardar la configuración y cerrar la ventana.
7.	Correr los tests
