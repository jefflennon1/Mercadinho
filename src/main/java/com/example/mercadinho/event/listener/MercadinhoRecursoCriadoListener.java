package com.example.mercadinho.event.listener;

import java.net.URI;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.mercadinho.event.MercadinhoRecursoCriadoEvent;


@Component
public class MercadinhoRecursoCriadoListener implements  ApplicationListener<MercadinhoRecursoCriadoEvent>{

	@Override
	public void onApplicationEvent(MercadinhoRecursoCriadoEvent event) {
		
		HttpServletResponse response = event.getResponse();
		Long codigo = event.getCodigo();
		
		headerLocationAoCriarRecurso(response, codigo);		
	}

	private void headerLocationAoCriarRecurso(HttpServletResponse response, Long codigo) {
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}").buildAndExpand(codigo).toUri();
		response.setHeader("Location", uri.toASCIIString());
	}

}
