package zemployee 


class TeamLead {
    String name

    static belongsTo = [team: Team]

    static constraints = {
        name nullable: false, blank: false
    }
}
