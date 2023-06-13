package zemployee 
class TeamLead {
    String firstName
    String lastName
    String designation
    String gender
    String nationality
    String phoneNumber
    String address
    String email
    static belongsTo = [team: Team]
    static hasMany = [employee: Employee]

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
