package com.iti0207.parkla.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
@RequiredArgsConstructor
public class AuthRepository {

    private final EntityManager entityManager;

    public Object getAllParkimiskoht(String email, String password) {
        return entityManager
                .createNativeQuery("SELECT f_on_juhataja(:email, :password)")
                .setParameter("email", email)
                .setParameter("password", password)
                .getSingleResult();
    }
}
