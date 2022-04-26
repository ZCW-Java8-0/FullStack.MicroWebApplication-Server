package com.nyce.tube.domain;

import java.time.ZonedDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Comment.class)
public abstract class Comment_ {

	public static volatile SingularAttribute<Comment, ZonedDateTime> date;
	public static volatile SingularAttribute<Comment, Videos> videos;
	public static volatile SingularAttribute<Comment, Long> id;
	public static volatile SingularAttribute<Comment, String> text;

	public static final String DATE = "date";
	public static final String VIDEOS = "videos";
	public static final String ID = "id";
	public static final String TEXT = "text";

}

