package test.steps;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.java.escenario.MetodosEscenario;

public class LinkedinSteps extends BaseSteps {
	
	private String resultadoEvaluar;
		
	@Given("^Que quiero autenticarme con el usuario de linkein con email \"([^\"]*)\" y password \"([^\"]*)\"$")
	public void autenticarme(String email, String password) throws Throwable {
		MetodosEscenario.login(email, password);
	}
	
	
	@When("^quiero buscar a mi contacto \"([^\"]*)\" y visualizar su perfil$")
	public void quiero_buscar_a_mi_contacto_y_visualizar_su_perfil(String nombrePerfil) {
		resultadoEvaluar = MetodosEscenario.vizualizarPerfil(nombrePerfil);
	}
	
	@Then("^encuentro el perfil de \"([^\"]*)\"$")
	public void encontrar(String nombre) throws Throwable {
		MetodosEscenario.cerrarVentana();
		Assert.assertEquals(nombre, resultadoEvaluar);	

	}

		
	@When("^el usuario no esta registrado$")
	public void quiero_mi_usuario_no_esta_registrado() {
		resultadoEvaluar = MetodosEscenario.usuarioNoEncontrado();
	    
	}

	@Then("^me muestra mensaje \"([^\"]*)\"$")
	public void me_muestra_mensaje(String mensaje) {
		MetodosEscenario.cerrarVentana();
		Assert.assertTrue(resultadoEvaluar.contains(mensaje));
	}
	
	
	
	
	@When("^ingreso a mi perfil$")
	public void ingreso_a_mi_perfil() {
	    MetodosEscenario.ingresarAMiPerfil();
	}

	@When("^agrego una seccion de experiencia laboral de \"([^\"]*)\"$")
	public void a_ado_una_seccion_de_experiencia_laboral(String experienciaLaboral) {
	    MetodosEscenario.agregoUnaExperienciaLaboral(experienciaLaboral);
	}
	
		
	@When("^compartir con mi red$")
	public void compartir_con_mi_red() {
	    MetodosEscenario.compartirRed();
	}
	
	@Then("^mi perfil es actualizado correctamente$")
	public void mi_perfil_es_actualizado_correctamente() {
		MetodosEscenario.cerrarVentana();
	}


}
