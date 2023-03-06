Feature: Yo como usuario, deseo crear una nueva cuenta en gmail
  @Stories @Scenario1
  Scenario Outline: Creación exitosa de usuario en gmail
    Given para crear una nueva cuenta en mercadolibre, necesite crear una cuenta de gmail
    And me dirijo a la página principal de google y me dirijo al botón 'acceder'
    And selecciono la opcion 'crear cuenta'
    And selecciono una cuenta de uso personal
    And registro mi <nombre>, <apellido>
    And registro el nombre de mi <usuario>, <contraseña>
    And registro mi confirmacion de <confirmacion>
    And doy clic sobre el boton 'siguiente' y registro mi <numero>
    And registro fecha de nacimiento <dia>, <mes>, <año>
    And selecciono mi <genero>
    And doy clic sobre el boton 'siguiente1'
    When de clic al boton 'aceptar' terminos y condiciones
    Then carga el home de google

    Examples:
      |nombre|apellido|usuario|contraseña|confirmacion|numero|dia|mes|año|genero|
      |  |testing|  |  |Javier109378589|3228942647|21|Octubre|1995|Hombre|
      |javier|testing|javiertestpicap4|Javier109378589|Javier109378589|3228942647|21|Octubre|1995|Hombre|
