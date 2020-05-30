package com.erc.util;

import com.erc.App;
import com.erc.domain.Category;
import com.erc.domain.Data;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.NonUniqueResultException;
import java.util.List;

public class DBService {

    private static Session session = App.getSession();

    public static void saveCategory(Category category) {
        session.beginTransaction();
        session.save(category);
        session.getTransaction().commit();
    }

    public static void saveData(Data data) {
        session.beginTransaction();
        session.save(data);
        session.getTransaction().commit();
    }

    public static Category findCategoryByName (String categoryName) {

        Query findCategoryByName = session.createQuery("from Category where name=:name");
        findCategoryByName.setParameter("name", categoryName);

        try {
            return (Category) findCategoryByName.uniqueResult();
        } catch (NonUniqueResultException exception) {
            return null;
        }
    }

    public static List<Category> getAllCategories() {
        return (List<Category>) session.createQuery("from Category").list();
    }

    public static List<Data> getAllData() {

        return (List<Data>) session.createQuery("from Data").list();
    }

    public static List<String> getAllNames() {
        return (List<String>) session.createQuery("Select categoryName from Category").list();
    }

}
