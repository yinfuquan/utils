/**
 * 
 */
package com.yfq.db.bettlsql;


import static com.yfq.db.bettlsql.SqlKit.$;

/**
 * @author Bean
 *
 */
public interface
ActiveRecord {

	default void updateStamp() {}
	
	default void createStamp() {}
	
    default boolean save() {
        /*  */
    		createStamp();
        return $().insertTemplate(this) > 0;
    }

    default boolean saveDo() {
    		//
    		createStamp();	
        return $().insertTemplate(this, true) > 0;
    }

    
    default boolean update() {
    		//
    		updateStamp();
        return $().updateTemplateById(this) > 0;
    }

    default boolean delete() {
    		//
        return $().deleteObject(this) > 0;
    }
}
