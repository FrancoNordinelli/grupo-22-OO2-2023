# grupo-22-OO2-2023.
Repositorio para el Trabajo Práctico Integrador 

Trabajo práctico cuatrimestral
Universidad Nacional de Lanús
Programación orientada a objetos 2
Periodo: Primer cuatrimestre 2023
Profesores:
● Mg. Alejandra Vranic
● Lic. Gustavo Siciliano
Tecnologías mínimas a utilizar:
● Java (versión mínima: 8. Versión a utilizar a definir por parte del grupo)
● Spring
● MySQL o Postgres (a definir por parte del grupo)
● Maquetado de las vistas: Mínimo HTML, CSS y JavaScript (se puede usar una
plantilla gratuita de bootstrap o similar. A definir por parte del grupo).
● IDE. Libre, a definir por parte del grupo (internamente no necesitan usar el mismo).
Sugerido por la cátedra: Spring Tool Suite.
● Versionado del proyecto. Git y Github.
Cronograma de entregables por el campus:
● 18/5/2023 parte 1: Listado de integrantes del grupo con su usuario de github (solo
pueden tener y usar uno por persona).
● 25/5/2023 parte 2: Link público del repositorio donde se va a guardar el código en
Github. El formato debe ser grupo-[número del grupo designado]-OO2-2023.
● 22/6/2023 parte 3: Proyecto terminado, indicando cual integrante desarrolló N caso
de uso.
● 22/6/2023 parte 4: Video donde cada participante explicará su desarrollo y hará una
demostración del uso sobre la plataforma (duración por persona de entre 5 y 8
minutos).
Consigna
Sistema de Smart City orientado al
predio de la UNLa
“Antes de nada, ¿tienes claro qué significa ser una Smart City? Una ciudad es inteligente
cuando la inversión social, las comunicaciones, las infraestructuras y el capital humano
conviven en armonía con el desarrollo económico sostenible y se apoya en el uso integrado
de las nuevas tecnologías. Además, comparten la información de que disponen con el
ciudadano y otros actores de la ciudad para que puedan aprovecharse de esa información.”
(https://www.grupocibernos.com/blog/descubre-los-ejemplos-de-smart-cities-ms-destacadas,
2023).
De forma simple, se entiende por Smart City a un lugar en donde diversos dispositivos de
IOT (por ejemplo sensores, alarmas, cámaras inteligentes, etc) miden datos del mundo real
para ejecutar acciones automáticas en el mismo. Dichas acciones deben tener un efecto
positivo en la vida de las personas y el medio ambiente del lugar.
Se espera que el TP cuente con los siguientes puntos:
1. Definir una solución de IOT por integrante.
Ejemplos de soluciones posibles:
○ Estacionamiento inteligente (Smart Parking). Sensores o cámaras que
detectan lugares libres y ocupados por autos.
○ Alumbrado inteligente. Sensores de luz que prenden o apagan alumbrado
según sea necesario.
○ Cuidado del espacio verde inteligente. Sensores de humedad que rieguen
automáticamente el pasto si la humedad ambiente es baja.
○ Baños ocupados. Cámaras que detectan cuando un baño está siendo
higienizado para avisar que no se puede usar.
○ Luces automáticas. Sensores o cámaras que indiquen si un aula está libre u
ocupada de forma que prendan la luz y/o accionan la apertura o cierre de
cortinas.
○ Recolectores inteligentes. Sensores que informen cuando un contenedor está
lleno. Sensores que accionen limpiadores automáticos en zonas específicas.
Cámaras que notifiquen de uso indebido del contenedor. Etc.
○ Etc. Se puede elegir una solución que no esté en el listado.
2. Se puede asumir que se puede contar con el dispositivo IOT necesario para resolver
la tarea física de la solución.
3. Tener una sección de ABM (la baja debe ser lógica) donde se pueda administrar el
uso y agregado de los dispositivos de cada solución al sistema.
4. Simular con archivos Java ejecutable (main class) la obtención de datos por parte de
los dispositivos.
5. Tener una sección donde se visualicen los datos de los eventos de cada solución.
Dicha sección debe funcionar como reportes, se tiene que poder hacer filtros varios
(fecha, dispositivo, estado del dispositivo, etc). A definir por cada estudiante.
6. El sistema debe tener un usuario administrador (el cual tendrá acceso total a
plataforma). Y un usuario auditor, el cual tendrá acceso solo a los informes.
Se espera que en la plataforma como mínimo pueda:
1. Iniciar sesión como Administrador o Auditor.
2. Como Administrador
a. Dar de alta un tipo de dispositivo.
b. Dar de alta un dispositivo de un tipo en particular.
3. Registrar un evento de un dispositivo específico.
4. Como Auditor
a. Ingresar en la sección de reportes y solicitar información de diferentes
eventos en el sistema.
5. Cerrar sesión.
