package com.prix.Service;

import com.prix.model.Cliente;
import com.prix.repo.IClienteRepo;
import com.prix.repo.IGenericRepo;
import org.keycloak.admin.client.CreatedResponseUtil;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class ClienteService extends CRUDImpl<Cliente, String> {

    @Autowired
    private IClienteRepo repo;

    @Autowired
    private RealmResource realmResource;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    private List<CredentialRepresentation> credencial;
    @Override
    protected IGenericRepo<Cliente, String> getRepo() {
        return repo;
    }

    public Cliente registrarCliente(Cliente cliente)throws Exception{
        UserRepresentation userRepresentacion = new UserRepresentation();
        CredentialRepresentation credencial = new CredentialRepresentation();

        userRepresentacion.setUsername(cliente.getEmail());
        userRepresentacion.setEnabled(true);
        credencial.setType(CredentialRepresentation.PASSWORD);
        credencial.setValue(cliente.getPassword());
        credencial.setTemporary(false);

        userRepresentacion.setCredentials(Arrays.asList(credencial));

        var responde = realmResource.users().create(userRepresentacion);
        String idUser = CreatedResponseUtil.getCreatedId(responde);

        cliente.setIdCliente(idUser);
        cliente.setFechaRegistro(LocalDateTime.now());

        String pass = this.passwordEncoder.encode(cliente.getPassword());
        cliente.setPassword(pass);

        return repo.save(cliente);

    }

    public long totalClientes()throws Exception{
        return repo.totalClientes();
    }

    public long totalClientes24()throws Exception{
        return repo.totalClientes24();
    }

}
