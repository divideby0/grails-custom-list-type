class Birthday implements Comparable, Serializable {

	Date date
    
	Birthday(Date date) {
        this.date = date
    }

    @Override
    int compareTo(Object t) {
        date.compareTo(t.date)
    }
}