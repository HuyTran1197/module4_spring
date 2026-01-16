package com.example.demo_customer_orm.repository;

import com.example.demo_customer_orm.entity.Product;
import com.example.demo_customer_orm.util.ConnectionUtil;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepo implements IProductRepo{

    @Override
    public List<Product> getList() {
        Session session = ConnectionUtil.sessionFactory.openSession();
        TypedQuery<Product> typedQuery = session.createQuery("from Product", Product.class);
        return typedQuery.getResultList();
    }

    @Override
    public boolean add(Product product) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();

        try {
            session.save(product);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public Product findById(int id) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        return session.find(Product.class,id);
    }

    @Override
    public boolean edit(Product product) {
        if (product!=null){
            Transaction transaction = null;
            try(Session session = ConnectionUtil.sessionFactory.openSession();) {
                transaction = session.beginTransaction();
                session.update(product);
                transaction.commit();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                if (transaction!=null){
                    transaction.rollback();
                }
            }
        }
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        Product product = findById(id);
        if (product!=null){
            Transaction transaction = null;
            try(Session session = ConnectionUtil.sessionFactory.openSession();) {
                transaction = session.beginTransaction();
                session.remove(product);
                transaction.commit();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                if (transaction!=null){
                    transaction.rollback();
                }
            }
        }
        return false;
    }

    @Override
    public Product detail(int id) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        return session.find(Product.class,id);
    }

    @Override
    public List<Product> search(String searchName, String searchProduce) {
        return List.of();
    }
}
