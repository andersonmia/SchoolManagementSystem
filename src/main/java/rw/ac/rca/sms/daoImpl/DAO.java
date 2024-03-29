package rw.ac.rca.sms.daoImpl;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import rw.ac.rca.sms.util.SmsSessionFactory;

public class DAO {
    protected DAO() {
    }
    /**
     *
     * @return session
     */
    public static Session getSession() {
        return SmsSessionFactory.getSession();
    }
    /**
     * begins transaction
     */
    protected void begin() {
        getSession().beginTransaction();
    }

    /**
     * saves changes to the database
     */
    protected void commit() {
        getSession().getTransaction().commit();
    }

    /**
     * rolls back for failed transaction closes databases connection
     *
     * @throws HibernateException
     *
     */
    protected void rollback() {
        try {
            getSession().getTransaction().rollback();
        } catch (HibernateException e) {
            System.out.println("Cannot rollback: " + e.toString());
        }
        finally{
            close();
        }
    }

    protected void close() {
        try {
            getSession().close();
        } catch (HibernateException e) {
            System.out.println("Cannot close: " + e.toString());
        }
    }

    public void clear() {
        getSession().clear();
    }
}