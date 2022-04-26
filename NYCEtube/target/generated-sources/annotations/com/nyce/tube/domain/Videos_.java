package com.nyce.tube.domain;

import java.time.ZonedDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Videos.class)
public abstract class Videos_ {

	public static volatile SingularAttribute<Videos, ZonedDateTime> date;
	public static volatile SetAttribute<Videos, Comment> comments;
	public static volatile SingularAttribute<Videos, String> videoContentType;
	public static volatile SingularAttribute<Videos, String> name;
	public static volatile SingularAttribute<Videos, Long> id;
	public static volatile SingularAttribute<Videos, byte[]> video;

	public static final String DATE = "date";
	public static final String COMMENTS = "comments";
	public static final String VIDEO_CONTENT_TYPE = "videoContentType";
	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String VIDEO = "video";

}

