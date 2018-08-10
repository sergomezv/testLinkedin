# encoding: utf-8

Feature: Perfil sitio linkedin
    
Scenario: Autenticacion
    Given Que quiero autenticarme con el usuario de linkein con email "sergomezv@gmail.com" y password "PruebaSelenium2018"
    When quiero buscar a mi contacto "Sergio" y visualizar su perfil
    Then encuentro el perfil de "Sergio Gomez Venegas | LinkedIn"


Scenario: Autenticacion Erronea
    Given Que quiero autenticarme con el usuario de linkein con email "selenium@pruebaselenium.com" y password "pruebaselenium"
    When el usuario no esta registrado
    Then me muestra mensaje "Vuelve a intentarlo."
    
Scenario: Actualizacion Perfil
   Given Que quiero autenticarme con el usuario de linkein con email "sergomezv@gmail.com" y password "PruebaSelenium2018"
   When ingreso a mi perfil
   And agrego una seccion de experiencia laboral de "Analista QA"
   And compartir con mi red
   Then mi perfil es actualizado correctamente
      
    