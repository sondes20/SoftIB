package tn.banque.softib.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
	@GetMapping("/all")
	public String allAccess() {
		return "Public Content.";
	}
	
	@GetMapping("/client")
	@PreAuthorize("hasRole('CLIENT') or hasRole('AGENT') or hasRole('ADMIN')")
	public String userAccess() {
		return "Client Content.";
	}

	@GetMapping("/agent")
	@PreAuthorize("hasRole('agent')")
	public String moderatorAccess() {
		return "Agent Board.";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('admin')")
	public String adminAccess() {
		return "Admin Board.";
	}
}
