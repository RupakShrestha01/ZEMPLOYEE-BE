package zemployee

class BootStrap {

    def init = { servletContext ->
    new Employee("firstName" : "Rupak",
"lastName" : "Shrestha",
"designation" : "Intern",
"gender" : "Male",
"nationality" : "Nepali",
"phoneNumber" : "9814722817",
"address" : "Matatirtha-4,KTM",
"email": "rupakshrestha2002@gmail.com"


).save()
new Employee("firstName" : "Akash",
"lastName" : "Baniya",
"designation" : "Web Dev",
"gender" : "Male",
"nationality" : "Nepali",
"phoneNumber" : "9814722817",
"address" : "Matatirtha-4,KTM",
"email": "rupakshrestha2002@gmail.com"


).save()

new Employee("firstName" : "Sunita",
"lastName" : "Baram",
"designation" : "Web Designer",
"gender" : "Female",
"nationality" : "Nepali",
"phoneNumber" : "9814722817",
"address" : "Matatirtha-4,KTM",
"email": "rupakshrestha2002@gmail.com"


).save()
new Employee("firstName" : "Dristi",
"lastName" : "Sigdel",
"designation" : "Data Analyst",
"gender" : "Female",
"nationality" : "Nepali",
"phoneNumber" : "9814722817",
"address" : "Matatirtha-4,KTM",
"email": "rupakshrestha2002@gmail.com"


).save()
    }
    def destroy = {
    }
}
