# Plan de Desarrollo Asistido: Proyecto de Estructura de Datos (Primer Parcial)
**Stack:** C# + MudBlazor (WebAssembly o Server)
**Arquitectura:** Separación en Proyecto_P1.UI (Interfaz) y Proyecto_P1.Lib (Modelos, Repositorios, Servicios).

## Instrucciones Generales para el Asistente (Antigravity)
Actúa como un desarrollador C# Senior. Vamos a construir un proyecto universitario de Estructura de Datos paso a paso. Debes respetar estrictamente la encapsulación, el manejo de excepciones, y usar MudBlazor para una UI moderna basada en tonos azules y blancos (estilo institucional).

---

### Fase 1: Capa de Dominio y Lógica de Negocio (Proyecto_P1.Lib)

**Prompt 1: Creación de Modelos con Encapsulamiento y Validaciones**
"Crea una clase `Vehiculo` dentro de `Proyecto_P1.Lib.Models`. Aplica encapsulamiento estricto (atributos privados, propiedades públicas get/set). Implementa validaciones en los `set`: 
1. `Placa`: Solo debe aceptar entre 7 y 8 caracteres alfanuméricos. Si no cumple, lanza `ArgumentException`.
2. `Propietario`: Solo debe contener letras y espacios. Si no cumple, lanza `FormatException`.
Ambos campos no pueden ser nulos ni vacíos."

**Prompt 2: Repositorios y Colecciones**
"Crea una interfaz `IVehiculoRepository` y su implementación `VehiculoRepository` en `Proyecto_P1.Lib.Repositories`. Usa un arreglo (`Vehiculo[]`) o `List<Vehiculo>` como almacenamiento en memoria. Implementa los métodos CRUD básicos: `Insertar`, `Eliminar` (por índice o placa), `Modificar` y `ObtenerTodos`. Maneja excepciones si se intenta acceder a un índice fuera de rango."

**Prompt 3: Servicios y Lógica de Negocio**
"Crea una clase `VehiculoService` en `Proyecto_P1.Lib.Services` que inyecte `IVehiculoRepository`. Aquí debes envolver las llamadas al repositorio en bloques `try-catch` y lanzar excepciones personalizadas o mensajes claros si la validación falla antes de llegar al repositorio."

---

### Fase 2: Interfaz Gráfica Base (Proyecto_P1.UI con MudBlazor)

**Prompt 4: Configuración del Layout Principal**
"Crea el componente `MainLayout.razor`. Usa `<MudLayout>`. Configura un `<MudDrawer>` permanente en el lado izquierdo con un color de fondo azul claro/grisáceo. Dentro del drawer, añade un `<MudNavMenu>` con los siguientes `<MudNavLink>`: 'Arreglos' (icono de lista), 'Recursividad' (icono de bucle), 'Ordenamiento' (icono de sort), 'Búsqueda' (icono de lupa) y 'Salir' (icono de logout). En el centro del `MudMainContent`, coloca un contenedor para el body."

**Prompt 5: Pantalla de Login**
"Crea la página `Login.razor` (Ruta `/`). Usa un diseño centrado vertical y horizontalmente. El fondo general debe ser azul. Coloca un `<MudPaper>` blanco o transparente con bordes redondeados. Incluye: un espacio para un logo, un `<MudTextField>` para 'Usuario', un `<MudTextField>` tipo password para 'Password', y un `<MudTextField>` para 'Empresa'. Añade un `<MudButton>` que redirija a la página de '/arreglos'."

---

### Fase 3: Módulos del Sistema (Vistas)

**Prompt 6: Módulo Funcional - Arreglos (`Arreglos.razor`)**
"Crea la página `Arreglos.razor` (Ruta `/arreglos`). 
1. A la izquierda (dentro del área de contenido, no el menú principal), crea un submenú vertical tipo sidebar con botones tipo `<MudButton>` de color azul sólido: 'Insertar', 'Eliminar', 'Modificar', 'Buscar' y 'Atrás'.
2. En el área central, implementa la visualización del arreglo. Inyecta `VehiculoService`. Muestra los datos insertados simulando un arreglo contiguo usando `<MudPaper>` dispuestos horizontalmente (ej. usando Flexbox `d-flex flex-row`).
3. Implementa la lógica para que el botón 'Insertar' abra un diálogo o formulario simple que permita ingresar Placa y Propietario, validando y mostrando los errores de excepciones en pantalla mediante un `<MudAlert>` o Snackbar de MudBlazor."

**Prompt 7: Módulos Visuales Simulados**
"Crea tres páginas en Blazor:
1. `Recursividad.razor` (Ruta `/recursividad`): Submenú izquierdo con botones azules 'Factorial', 'Fibonacci' y 'Salir'. Centro vacío con espacio para un logo.
2. `Ordenamiento.razor` (Ruta `/ordenamiento`): Submenú izquierdo con 'Método Burbuja', 'Método Selección', 'Método Inserción', 'Método Quicksort', 'Salir'. Centro vacío.
3. `Busqueda.razor` (Ruta `/busqueda`): Submenú izquierdo con 'Búsqueda Binaria', 'Búsqueda Secuencial', 'Salir'. Centro vacío.
Asegúrate de que visualmente sigan el mismo patrón estructural que la página de Arreglos."

---

### Fase 4: Entregables

**Prompt 8: Generación de Diagrama de Clases**
"Genera el código Mermaid para el diagrama de clases del proyecto, incluyendo `Vehiculo`, las interfaces de repositorios, la implementación del repositorio y el servicio. Asegúrate de mostrar las propiedades privadas y los métodos públicos."

**Prompt 9: Consolidación de Código**
"Muestra el código final del `Program.cs` asegurándote de que el método `Main` esté explícitamente definido como `public static async Task Main(string[] args)`, e incluye el registro de los servicios (Dependency Injection) para el Repositorio y Servicio creados."
