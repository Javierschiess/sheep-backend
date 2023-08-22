package com.prix.Service;

import com.prix.model.Comercio;
import com.prix.repo.IComercioRepo;
import com.prix.repo.IGenericRepo;
import org.keycloak.admin.client.CreatedResponseUtil;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class ComercioService extends CRUDImpl<Comercio, String> {

    private final IComercioRepo repo;

    @Autowired
    private RealmResource realmResource;

    private List<CredentialRepresentation> credencial;

    public ComercioService(IComercioRepo repo) {
        this.repo = repo;
    }

    @Override
    protected IGenericRepo<Comercio, String> getRepo() {
        return repo;
    }

    public Comercio registrarComercio(Comercio comercio)throws Exception{
        System.out.println(comercio);
        UserRepresentation userRepresentation = new UserRepresentation();
        CredentialRepresentation credencial = new CredentialRepresentation();

        userRepresentation.setUsername(comercio.getUsername());
        userRepresentation.setEnabled(true);
        credencial.setType(CredentialRepresentation.PASSWORD);
        credencial.setValue(comercio.getPassword());
        credencial.setTemporary(false);

        userRepresentation.setCredentials(Arrays.asList(credencial));

        var responde = realmResource.users().create(userRepresentation);
        String idUser = CreatedResponseUtil.getCreatedId(responde);

        comercio.setIdComercio(idUser);
        comercio.setFechaRegistro(LocalDateTime.now());
        return repo.save(comercio);
    }

}
