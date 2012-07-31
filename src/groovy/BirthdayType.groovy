import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.grails.datastore.mapping.engine.types.AbstractMappingAwareCustomTypeMarshaller;
import org.grails.datastore.mapping.model.PersistentProperty;
import org.grails.datastore.mapping.mongo.query.MongoQuery;
import org.grails.datastore.mapping.query.Query;

class BirthdayType extends AbstractMappingAwareCustomTypeMarshaller<Birthday, DBObject, DBObject> {
	BirthdayType() {
		super(Birthday)
	}
	
    @Override
    protected Object writeInternal(PersistentProperty property, String key, Birthday value, DBObject nativeTarget) {
        final converted = value.date.time
        nativeTarget.put(key, converted)
        return converted
    }

    @Override
    protected Birthday readInternal(PersistentProperty property, String key, DBObject nativeSource) {
        final num = nativeSource.get(key)
        if(num instanceof Long) {
            return new Birthday(new Date(num))
        }
        return null
    }
}