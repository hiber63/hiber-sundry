package cn.hiber.core.config;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import java.util.Properties;

/**
 * @author hiber
 */
public class BaseJpaConfig {

    protected LocalContainerEntityManagerFactoryBean abstractBaseEntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean abstractBaseEntityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setDatabase(Database.MYSQL);
        jpaVendorAdapter.setShowSql(true);
        jpaVendorAdapter.setGenerateDdl(false);
        //不加会自动生成myisam
        jpaVendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQL5InnoDBDialect");
        Properties jpaProperties = new Properties();
        jpaProperties.setProperty("hibernate.hbm2ddl.auto","update");
        jpaProperties.setProperty("hibernate.connection.charSet","UTF-8");
        jpaProperties.setProperty("hibernate.format_sql","true");
        HibernatePersistenceProvider persistenceProvider = new HibernatePersistenceProvider();
        HibernateJpaDialect jpaDialect = new HibernateJpaDialect();
        abstractBaseEntityManagerFactory.setJpaVendorAdapter(jpaVendorAdapter);
        abstractBaseEntityManagerFactory.setJpaProperties(jpaProperties);
        abstractBaseEntityManagerFactory.setPersistenceProvider(persistenceProvider);
        abstractBaseEntityManagerFactory.setJpaDialect(jpaDialect);
        return abstractBaseEntityManagerFactory;
    }

}
