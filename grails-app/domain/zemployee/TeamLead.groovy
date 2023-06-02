package zemployee 
class TeamLead {
    String name
    String designation

    static belongsTo = [team: Team]

    static constraints = {
        name nullable: false, blank: false
        designation nullable: false
    }

}
