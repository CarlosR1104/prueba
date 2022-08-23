package com.muebles_valencia.seguridad2;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.muebles_valencia.entidades.cliente.Cliente;

@Component
public class InfoAdicionalToken implements TokenEnhancer{
	
	@Autowired
	private IUsuarioService usuarioService;

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		System.out.println("OAuth2AccessToken " + authentication.getName());
		Cliente usuario = usuarioService.findByCorreo(authentication.getName());
		Map<String, Object> info = new HashMap<>();
		info.put("info_adicional", "Hola que tal!".concat(authentication.getName()));
		info.put("Estado", usuario.getEstado_cliente());
		info.put("nombre", usuario.getNombre());
		info.put("apellido", usuario.getApellido_cliente());
		info.put("email", usuario.getCorreo());
		
		((DefaultOAuth2AccessToken)accessToken).setAdditionalInformation(info);
		return accessToken;
	}

	
}
