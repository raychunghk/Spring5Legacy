package com.ray.dao;


import com.ray.entity.Customer;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    // need to inject the session factory


    //   private SessionFactory ssf;
    @Autowired
    MySessionFactory fac;

    @Autowired
    SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    private Session getSession() {
        //return fac.openSession();
        return sessionFactory.getCurrentSession();
        //return sessionFactory.buildSessionFactory().openSession();
        // return ssf.openSession();
    }

    @Override

    public List<Customer> getCustomers() {

        // get the current hibernate session
        Session sess = getSession();
        //  sess.beginTransaction();
        // create a query

        Query  q= sess.createQuery ("from "+Customer.class.getName()+" order by lastName" );

        // execute query and get result list
        List<Customer> customers = q.list(); //.getResultList();
        // sess.getTransaction().commit();
        //  sess.close();
        // return the results
        return customers;
    }


    @Override
    @Transactional
    public void saveCustomer(Customer customer) {
        Session sess = getSession();
        try {

            //sess.save(customer);

            sess.saveOrUpdate(customer);


        } catch (Exception e) {
            // Logger.getLogger("x").log(Level.ALL, "here");
            e.printStackTrace();
            throw e;
        } finally {
            //  sess.close();
        }

    }

    @Override
    public Customer getCustomer(int id) {
        Session sess = getSession();
        Customer c = sess.get(Customer.class, id);
        // sess.close();
        return c;
    }

    @Override
    public void deleteCustomer(int id) {
        Session sess = getSession();
        org.hibernate.Query q = sess.createQuery("delete Customer where id=:cid");
        q.setParameter("cid", id);
        q.executeUpdate();
        // sess.close();
        return;
    }

}






