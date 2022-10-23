
package com.app.portfolio.Security.Controller;

import com.app.portfolio.Security.Dto.JwtDto;
import com.app.portfolio.Security.Dto.LoginUser;
import com.app.portfolio.Security.Dto.NewUser;
import com.app.portfolio.Security.Entity.Rol;
import com.app.portfolio.Security.Entity.Usuario;
import com.app.portfolio.Security.Enums.RoleName;
import com.app.portfolio.Security.JWT.JwtProvider;
import com.app.portfolio.Security.Service.RoleService;
import com.app.portfolio.Security.Service.UserService;
import java.util.HashSet;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {
    @Autowired
    PasswordEncoder passwordencoder;
    @Autowired
    AuthenticationManager authmanager;
    @Autowired
    UserService userservice;
    @Autowired
    JwtProvider jwtprovider;
    @Autowired
    RoleService roleservice;
    
    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@Valid @RequestBody NewUser newuser, BindingResult bindingresult){
        if (bindingresult.hasErrors())
            return  new ResponseEntity(new Mensaje("Campos incorrectos o email invalido"), HttpStatus.BAD_REQUEST);
        if (userservice.existsByUsername(newuser.getUsername()))
            return new ResponseEntity(new Mensaje("El nombre de usuario ya esta en uso"), HttpStatus.BAD_REQUEST);
        if (userservice.existsByUsername(newuser.getEmail()))
            return new ResponseEntity(new Mensaje("El email de usuario ya esta en uso"), HttpStatus.BAD_REQUEST);
        
        Usuario usuario= new Usuario(newuser.getNombre(), newuser.getUsername(), newuser.getEmail(), passwordencoder.encode(newuser.getPassword()));
        
        Set<Rol> roles= new HashSet<>();
        roles.add(roleservice.getByRoleName(RoleName.ROLE_USER).get());
        
        if (newuser.getRoles().contains("admin"))
            roles.add(roleservice.getByRoleName(RoleName.ROLE_ADMIN).get());
        usuario.setRoles(roles);
        userservice.save(usuario);
        
        return new ResponseEntity(new Mensaje("Usuario creado"),HttpStatus.CREATED);
    }
    
    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUser loginusuario, BindingResult bindingresult){
        if (bindingresult.hasErrors())
            return new ResponseEntity(new Mensaje("Campos incorrectos"), HttpStatus.BAD_REQUEST);
        
        Authentication authentication= authmanager.authenticate(new UsernamePasswordAuthenticationToken(loginusuario.getUsername(), loginusuario.getPassword()));
        
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        String jwt= jwtprovider.generateToken(authentication);
        
        UserDetails userdetails = (UserDetails) authentication.getPrincipal();
        
        JwtDto jwtdto = new JwtDto(jwt, userdetails.getUsername(), userdetails.getAuthorities());
        
        return new ResponseEntity(jwtdto, HttpStatus.OK);
    }
}
