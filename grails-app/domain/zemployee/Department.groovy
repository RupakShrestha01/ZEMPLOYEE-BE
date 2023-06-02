package zemployee 

class Department{
    String departName
    static hasMany = [teams: Team]

    static constraints = {
        departName nullable: false
    }

}