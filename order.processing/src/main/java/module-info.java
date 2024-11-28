module order.processing {
    requires static lombok;
    //requires order.storage;
    requires java.base;
    requires java.sql;
    requires javafaker;
    exports org.example;
}