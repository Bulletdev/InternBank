package com.projeto.InternBank.db;

import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.projeto.InternBank.db.models.Admin;
import com.projeto.InternBank.db.models.Usuario;
import com.projeto.InternBank.db.repositories.AdminRepository;
import com.projeto.InternBank.db.repositories.UsuarioRepository;

@SpringBootTest
class InternBankApplicationTests {

	/* Add the necessary annotations to execute the application
	and verify that the Admin and User are created in the database.
	*/
	private AdminRepository adminRepository;


	private UsuarioRepository usuarioRepository;

	@Autowired
	private InternBankApplication internBankApplication;

	@Test
	void contextLoads() {
	}

	@Test
	void initAdmin_createsAdminIfNotExists() throws Exception {
		when(adminRepository.findById(1)).thenReturn(Optional.empty());

		internBankApplication.initAdmin(adminRepository).run();

		verify(adminRepository, times(1)).save(any(Admin.class));
	}

	@Test
	void initAdmin_doesNotCreateAdminIfExists() throws Exception {
		when(adminRepository.findById(1)).thenReturn(Optional.of(new Admin()));

		internBankApplication.initAdmin(adminRepository).run();

		verify(adminRepository, never()).save(any(Admin.class));
	}

	@Test
	void initUser_createsUserIfNotExists() throws Exception {
		when(usuarioRepository.findByEmail("usuario")).thenReturn(Optional.empty());

		internBankApplication.initUser(usuarioRepository).run();

		verify(usuarioRepository, times(1)).save(any(Usuario.class));
	}

	@Test
	void initUser_doesNotCreateUserIfExists() throws Exception {
		when(usuarioRepository.findByEmail("usuario")).thenReturn(Optional.of(new Usuario()));

		internBankApplication.initUser(usuarioRepository).run();

		verify(usuarioRepository, never()).save(any(Usuario.class));
	}
}