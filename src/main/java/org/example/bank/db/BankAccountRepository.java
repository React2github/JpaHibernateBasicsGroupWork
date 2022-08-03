package org.example.bank.db;

import org.example.bank.model.BankAccount;
import org.example.shared.io.db.Repository;

import java.util.Optional;

public class BankAccountRepository implements Repository<BankAccount> {
    @Override
    public BankAccount save(BankAccount bankAccount) {
        return null;
    }

    @Override
    public Optional<BankAccount> findById(Long id) {
        return Optional.empty();
    }

//    public UserEntity getUserByIdWithNativeQuery(Long id) {
//        Query nativeQuery
//                = getEntityManager().createNativeQuery("SELECT * FROM users WHERE id=:userId", UserEntity.class);
//        nativeQuery.setParameter("userId", id);
//        return (UserEntity) nativeQuery.getSingleResult();
//    }

}
