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
        name nullable: false, blank: false
        designation nullable: false
    }

}
