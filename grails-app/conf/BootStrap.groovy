class BootStrap {

    def init = { servletContext ->
    	Person p = new Person(
    		name: 'John Smith',
    		birthdays: [
    			new Birthday(new Date())
    		]
    	)
    	p.save(flush: true)
    	println "errors: ${p.errors.allErrors}" 
    }
    def destroy = {
    }
}
