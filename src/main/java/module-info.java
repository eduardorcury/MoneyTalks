module com.erc {
    requires javafx.controls;
    requires java.persistence;
    requires java.sql;
    requires java.naming;
    requires org.hibernate.orm.core;
    requires net.bytebuddy;
    requires java.xml.bind;
    requires com.sun.xml.bind;
    opens com.erc.domain to org.hibernate.orm.core, javafx.base;
    exports com.erc;
}