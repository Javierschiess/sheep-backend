package com.prix.Service;

import com.prix.model.Comercio;
import com.prix.model.Municipio;
import com.prix.repo.IComercioRepo;
import com.prix.repo.IGenericRepo;
import com.prix.repo.IMunicipioRepo;
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
import java.util.Optional;

@Service
public class ComercioService extends CRUDImpl<Comercio, String> {

    private final IComercioRepo repo;
    private final IMunicipioRepo municipioRepo;

    @Autowired
    private RealmResource realmResource;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    private List<CredentialRepresentation> credencial;

    public ComercioService(IComercioRepo repo, IMunicipioRepo municipioRepo) {
        this.repo = repo;
        this.municipioRepo = municipioRepo;
    }

    @Override
    protected IGenericRepo<Comercio, String> getRepo() {
        return repo;
    }

    public Comercio registrarComercio(Comercio comercio)throws Exception{
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
        String pass = passwordEncoder.encode(comercio.getPassword());
        comercio.setPassword(pass);
        comercio.setFechaRegistro(LocalDateTime.now());
        return repo.save(comercio);
    }

    public long totalComercios()throws Exception{
        return repo.totalComercios();
    }

    public long totalComercios24()throws Exception{
        return repo.totalComercios24();
    }

}
