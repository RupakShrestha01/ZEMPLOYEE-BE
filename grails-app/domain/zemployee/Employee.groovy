package zemployee
// import grails.rest.*
// @Resource(uri='/employee')

class Employee {
    String firstName
    String lastName
    String designation
    String gender
    String nationality
    String phoneNumber
    String address
    String email
    static hasMany = [subordinates: Subordinate]
    static constraints = {
        firstName nullable: false
        lastName nullable: false
        gender nullable: false, inList : ["Male", "Female"]
        designation nullable: false
        nationality nullable: false
        phoneNumber nullable: false
        address nullable: false
        email nullable: false
    }
}
