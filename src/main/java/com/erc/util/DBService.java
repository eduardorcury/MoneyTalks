package com.erc.util;

import com.erc.App;
import com.erc.domain.Category;
import com.erc.domain.ChartData;
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

    public static void saveChartData(ChartData chartData) {
        session.beginTransaction();
        session.save(chartData);
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

    public static ChartData findChartDataByCategory (Category category) {

        Query findChartDataByCategory = session.createQuery("from ChartData where category=:category");
        findChartDataByCategory.setParameter("category", category);

        try {
            return (ChartData) findChartDataByCategory.uniqueResult();
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

    public static List<ChartData> getAllChartData() {
        return (List<ChartData>) session.createQuery("from ChartData").list();
    }

}
