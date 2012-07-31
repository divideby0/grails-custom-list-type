import org.grails.datastore.mapping.engine.types.AbstractMappingAwareCustomTypeMarshaller;
import org.grails.datastore.mapping.model.PersistentProperty;

import com.mongodb.BasicDBList
import com.mongodb.DBObject;


class BirthdayListType extends AbstractMappingAwareCustomTypeMarshaller<BirthdayList, DBObject, DBObject> {
	BirthdayListType() {
		super(BirthdayList)
	}
	
    @Override
    protected Object writeInternal(PersistentProperty property, String key, BirthdayList value, DBObject nativeTarget) {
		BasicDBList list = new BasicDBList();
		for(Birthday birthday : value) {
			list.add(birthday.date.time)
		}
        nativeTarget.put(key, list)
        return list
    }

    @Override
    protected BirthdayList readInternal(PersistentProperty property, String key, DBObject nativeSource) {
        final sourceList = nativeSource.get(key)
        if(num instanceof List<Long>) {
            BirthdayList list = new BirthdayList()
			for(Long num : sourceList) {
				list.add(new Birthday(num))
			}
			return list
        }
        return null
    }
}