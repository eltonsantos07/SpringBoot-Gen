package br.org.generation.blogPessoal.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

public class UsuarioTest {

	@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
	public class ContatoModelTest {
		public Usuario usuario;
		@Autowired
		private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

		@BeforeEach
		public void start() {
			usuario = new Usuario("Gabriel", "gabriel07", "Admin99/", "gabriel.souza@gmail.com");
		}

		@Test
		public void testValidationAtributos() {
			usuario.setNome("João");
			usuario.setUsuario("gabs08");
			usuario.setSenha("21837559");
			Set<ConstraintViolation<Usuario>> violations = validator.validate(usuario);
			System.out.println(violations.toString());
			assertTrue(violations.isEmpty());
		}
	}

}
