package com.google.code.stk.server.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2010-09-23 20:58:48")
/** */
public final class AutoTweetMeta extends org.slim3.datastore.ModelMeta<com.google.code.stk.shared.model.AutoTweet> {

    /** */
    public final org.slim3.datastore.CoreUnindexedAttributeMeta<com.google.code.stk.shared.model.AutoTweet, com.google.code.stk.shared.Enums.Cycle> cycle = new org.slim3.datastore.CoreUnindexedAttributeMeta<com.google.code.stk.shared.model.AutoTweet, com.google.code.stk.shared.Enums.Cycle>(this, "cycle", "cycle", com.google.code.stk.shared.Enums.Cycle.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.google.code.stk.shared.model.AutoTweet> endMMdd = new org.slim3.datastore.StringAttributeMeta<com.google.code.stk.shared.model.AutoTweet>(this, "endMMdd", "endMMdd");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.google.code.stk.shared.model.AutoTweet, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<com.google.code.stk.shared.model.AutoTweet, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.google.code.stk.shared.model.AutoTweet> startMMdd = new org.slim3.datastore.StringAttributeMeta<com.google.code.stk.shared.model.AutoTweet>(this, "startMMdd", "startMMdd");

    /** */
    public final org.slim3.datastore.StringUnindexedAttributeMeta<com.google.code.stk.shared.model.AutoTweet> tweet = new org.slim3.datastore.StringUnindexedAttributeMeta<com.google.code.stk.shared.model.AutoTweet>(this, "tweet", "tweet");

    /** */
    public final org.slim3.datastore.StringUnindexedAttributeMeta<com.google.code.stk.shared.model.AutoTweet> tweetTime = new org.slim3.datastore.StringUnindexedAttributeMeta<com.google.code.stk.shared.model.AutoTweet>(this, "tweetTime", "tweetTime");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.google.code.stk.shared.model.AutoTweet, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<com.google.code.stk.shared.model.AutoTweet, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final AutoTweetMeta slim3_singleton = new AutoTweetMeta();

    /**
     * @return the singleton
     */
    public static AutoTweetMeta get() {
       return slim3_singleton;
    }

    /** */
    public AutoTweetMeta() {
        super("AutoTweet", com.google.code.stk.shared.model.AutoTweet.class);
    }

    @Override
    public com.google.code.stk.shared.model.AutoTweet entityToModel(com.google.appengine.api.datastore.Entity entity) {
        com.google.code.stk.shared.model.AutoTweet model = new com.google.code.stk.shared.model.AutoTweet();
        model.setCycle(stringToEnum(com.google.code.stk.shared.Enums.Cycle.class, (java.lang.String) entity.getProperty("cycle")));
        model.setEndMMdd((java.lang.String) entity.getProperty("endMMdd"));
        model.setKey(entity.getKey());
        model.setStartMMdd((java.lang.String) entity.getProperty("startMMdd"));
        model.setTweet((java.lang.String) entity.getProperty("tweet"));
        model.setTweetTime((java.lang.String) entity.getProperty("tweetTime"));
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        com.google.code.stk.shared.model.AutoTweet m = (com.google.code.stk.shared.model.AutoTweet) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setUnindexedProperty("cycle", enumToString(m.getCycle()));
        entity.setProperty("endMMdd", m.getEndMMdd());
        entity.setProperty("startMMdd", m.getStartMMdd());
        entity.setUnindexedProperty("tweet", m.getTweet());
        entity.setUnindexedProperty("tweetTime", m.getTweetTime());
        entity.setProperty("version", m.getVersion());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        com.google.code.stk.shared.model.AutoTweet m = (com.google.code.stk.shared.model.AutoTweet) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        com.google.code.stk.shared.model.AutoTweet m = (com.google.code.stk.shared.model.AutoTweet) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        com.google.code.stk.shared.model.AutoTweet m = (com.google.code.stk.shared.model.AutoTweet) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void incrementVersion(Object model) {
        com.google.code.stk.shared.model.AutoTweet m = (com.google.code.stk.shared.model.AutoTweet) model;
        long version = m.getVersion() != null ? m.getVersion().longValue() : 0L;
        m.setVersion(Long.valueOf(version + 1L));
    }

    @Override
    protected void prePut(Object model) {
        assignKeyIfNecessary(model);
        incrementVersion(model);
    }

    @Override
    public String getSchemaVersionName() {
        return "slim3.schemaVersion";
    }

    @Override
    public String getClassHierarchyListName() {
        return "slim3.classHierarchyList";
    }

}