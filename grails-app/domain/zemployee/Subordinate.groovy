package zemployee
import grails.rest.*
@Resource(uri='/subordinate')
class Subordinate {
    String firstName
    String lastName
    String designation
static belongsTo = [employee: Employee]
    static constraints = {
    }
}
