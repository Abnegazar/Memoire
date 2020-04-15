package com.memoire.wohaya.services;

import com.memoire.wohaya.domaine.Utilisateur;
import com.memoire.wohaya.repository.UtilisateurRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;

    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    public Utilisateur save (Utilisateur utilisateur){
        return utilisateurRepository.save(utilisateur);
    }

    public Utilisateur getOneByTelephoneAndPassword(String telephone, String password) {
        return utilisateurRepository.findByTelephoneAndPwd(telephone, password);
    }

    public Utilisateur getOneByTelephone(String telephone) {
        return utilisateurRepository.findByTelephone(telephone);
    }


    public List<Utilisateur> getAll(){
        return utilisateurRepository.findAll();
    }

    public boolean existByPhoneAndPwd(String phone, String pwd){
        return utilisateurRepository.existsByTelephoneAndPwd(phone, pwd);
    }

    public Long count(){
        return utilisateurRepository.count();
    }

    public Utilisateur updateUser(Utilisateur utilisateur){
        return utilisateurRepository.saveAndFlush(utilisateur);
    }

    public void deleteOne(String phone, String pwd){
         utilisateurRepository.deleteByTelephoneAndPwd(phone, pwd);
    }

    public void deleteAll(){
        utilisateurRepository.deleteAll();
    }

    /*public List<Utilisateur> getAllByRole(String role) {
        return utilisateurRepository.findAllByRole(role);
    }*/
}
