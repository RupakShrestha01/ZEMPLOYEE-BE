package zemployee
class Employee {
    String firstName
    String lastName
    String designation
    String gender
    String nationality
    String phoneNumber
    String address
    String email
    boolean isTeamlead
    static hasMany = [teamLead: TeamLead]
    static belongsTo = [team: Team, department: Department]
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
